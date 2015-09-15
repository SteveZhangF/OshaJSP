package bean.user.data.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.user.User;
import bean.user.data.Company;
import bean.user.data.dao.CompanyDAO;
import database.ConnectionPool;
import global.UUIDGenerator;

public class CompanyDAOImpl implements CompanyDAO {

	@Override
	public String save(Company p) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		String sql = "INSERT INTO `user_data`.`tb_company` (`uuid`,`company_address`,`company_phone`,`company_name`) values (?,?,?,?) ";
		try {
			con = ConnectionPool.getInstance().getConnection();
			String uuid = UUIDGenerator.generateUUID();
			ps = con.prepareStatement(sql);
			ps.setString(1, uuid);
			ps.setString(2, p.getCompany_address());
			ps.setString(3, p.getCompany_phone());
			ps.setString(4, p.getCompany_name());
			ps.executeUpdate();
			return uuid;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "-1";
		} finally {
			ConnectionPool.getInstance().release();
		}
	}

	@Override
	public Company getCompanybyID(String uuid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Company p) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql = "select *  from `user_data`.`tb_company` where uuid='" + p.getUuid() + "'";
		try {
			con = ConnectionPool.getInstance().getConnection();
			Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = statement.executeQuery(sql);
			rs.first();

			if (p.getCompany_name() != null && !p.getCompany_name().equals(rs.getString("company_name")))
				rs.updateString("company_name", p.getCompany_name());
			if (p.getCompany_address() != null && !p.getCompany_address().equals(rs.getString("company_address")))
				rs.updateString("company_address", p.getCompany_address());
			if (p.getCompany_phone() != null && !p.getCompany_phone().equals(rs.getString("company_phone")))
				rs.updateString("company_phone", p.getCompany_phone());

			rs.updateDate("updated_at", new java.sql.Date(System.currentTimeMillis()));
			rs.updateRow();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			ConnectionPool.getInstance().release();
		}
	}

	@Override
	public void delete(String id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Company getCompanybyUserID(String userid) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT tb_company.*  FROM user_data.tb_company inner join user_data.pub_users on pub_users.company_id=tb_company.uuid where user_data.pub_users.uuid = ?";
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		Company company = null;
		try {
			con = ConnectionPool.getInstance().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, userid);
			rs = ps.executeQuery();
			if (rs.next()) {
				company = new Company();
				company.setUuid(rs.getString("uuid"));
				company.setCompany_address(rs.getString("company_address"));
				company.setCompany_name(rs.getString("company_name"));
				company.setCompany_phone(rs.getString("company_phone"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().release();
		}
		return company;
	}
	// user_data.tb_company.uuid,user_data.tb_company.company_address,user_data.tb_company.company_name,user_data.tb_company.company_phone
}
