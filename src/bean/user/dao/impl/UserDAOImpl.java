package bean.user.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.user.User;
import bean.user.dao.UserDAO;
import database.ConnectionPool;
import global.MD5;
import global.UUIDGenerator;
import model.TopicElement;

public class UserDAOImpl implements UserDAO {

	@Override
	public void save(User p) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		String sql = "INSERT INTO `user_data`.`pub_users` (`uuid`,`user_email`,`user_password_digest`) values (?,?,?) ";
		try {
			con = ConnectionPool.getInstance().getConnection();
			String uuid = UUIDGenerator.generateUUID();
			ps = con.prepareStatement(sql);
			ps.setString(1, uuid);
			ps.setString(2, p.getUser_email());
			ps.setString(3, p.getUser_password_digest());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().release();
		}
	}

	@Override
	public User getUser(String email) throws SQLException {
		// TODO Auto-generated method stub.
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		String sql = "SELECT *" + " FROM `user_data`.`pub_users`" + " where `user_email`=?";
		try {
			con = ConnectionPool.getInstance().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setActivated(rs.getInt("activated"));
				user.setActivated_at(rs.getLong("activated_at"));
				user.setActivation_digest(rs.getString("activation_digest"));
				user.setCompany_id(rs.getString("company_id"));
				user.setRemember_digest(rs.getString("remember_digest"));
				user.setUpdated_at(rs.getLong("updated_at"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_password_digest(rs.getString("user_password_digest"));
				user.setUuid(rs.getString("uuid"));
				user.setCreate_at(rs.getLong("create_at"));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().release();
		}
		return user;
	}

	@Override
	public User getUserbyID(String id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		String sql = "SELECT *" + " FROM `user_data`.`pub_users`" + " where `id`=?";
		try {
			con = ConnectionPool.getInstance().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setActivated(rs.getInt("activated"));
				user.setActivated_at(rs.getLong("activated_at"));
				user.setActivation_digest(rs.getString("activation_digest"));
				user.setCompany_id(rs.getString("company_id"));
				user.setRemember_digest(rs.getString("remember_digest"));
				user.setUpdated_at(rs.getLong("updated_at"));
				user.setUser_email(rs.getString("user_email"));
				user.setUser_password_digest(rs.getString("user_password_digest"));
				user.setUuid(rs.getString("uuid"));
				user.setCreate_at(rs.getLong("create_at"));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().release();
		}
		return user;
	}

	@Override
	public void update(User p) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public int check(String email, String pwd) throws SQLException {
		// TODO Auto-generated method stub
		int index=0;
		User user = getUser(email);
		if (user != null) {
			if (user.getUser_password_digest().equals(MD5.toMD5(pwd)))
				index = UserDAO.LOGIN_SUCCESS;
			else
				index = UserDAO.LOGIN_PASSWORDWRONG;
		} else
			index = UserDAO.LOGIN_NOUSERFIND;
		return index;
	}

}
