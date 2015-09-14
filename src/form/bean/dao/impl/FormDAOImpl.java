package form.bean.dao.impl;

import java.sql.Connection;
import java.util.List;

import database.ConnectionPool;
import form.bean.Form;
import form.bean.dao.FormDAO;
import global.UUIDGenerator;

public class FormDAOImpl implements FormDAO {

	@Override
	public String save(Form p) {
		// TODO Auto-generated method stub
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		String sql = "INSERT INTO `form_model`.`tb_form`" + "(`uuid`," + "`name`," + "`template_xml`)" + "VALUES"
				+ "(?,?,?);";
		try {
			con = ConnectionPool.getInstance().getConnection();
			String uuid = UUIDGenerator.generateUUID();
			ps = con.prepareStatement(sql);
			ps.setString(1, uuid);
			ps.setString(2, p.getName());
			ps.setString(3, p.getTemplate_xml());
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
	public void delete(Form f) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Form f) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Form> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Form> findbyIndustry(int industry_id) {
		// TODO Auto-generated method stub
		return null;
	}

}
