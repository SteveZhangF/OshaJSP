package form.bean.dao.impl;

import java.sql.Connection;
import java.util.List;

import database.ConnectionPool;
import form.bean.FormComponent;
import form.bean.dao.FormComponentDAO;
import global.UUIDGenerator;

public class FormComponentDAOImpl implements FormComponentDAO {

	@Override
	public String save(FormComponent p) {
		// TODO Auto-generated method stub
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		String sql = "insert into form_model.tb_form_component (uuid,form_id,component_name,component_type_id) select ?,?,?,uuid from form_model.tb_form_component_type where name=?";

		try {
			con = ConnectionPool.getInstance().getConnection();
			String uuid = UUIDGenerator.generateUUID();
			ps = con.prepareStatement(sql);
			ps.setString(1, uuid);
			ps.setString(2, p.getForm_id());
			ps.setString(3, p.getComponent_name());
			ps.setString(4, p.getComponent_type());
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
	public void delete(FormComponent fc) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(FormComponent fc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FormComponent findbyID(int id) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<FormComponent> findbyFormID(int form_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FormComponent findbyName(int name) {
		
		return null;
	}

}
