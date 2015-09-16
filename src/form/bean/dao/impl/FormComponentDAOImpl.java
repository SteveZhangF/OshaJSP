package form.bean.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import database.ConnectionPool;
import form.bean.Form;
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
	
	public static void main(String[] ar){
		FormComponent fc = new FormComponentDAOImpl().findbyID("7d669d6376ee4a638a452ec9f29cb04c");
		System.out.println(fc.getComponent_type());
	}

	@Override
	public FormComponent findbyID(String id) {
		// TODO Auto-generated method stub
		FormComponent form_component = new FormComponent();
		
		String sql = "SELECT component.*,ctype.name type_name FROM form_model.tb_form_component component inner join form_model.tb_form_component_type ctype on ctype.uuid=component.component_type_id where component.uuid='"+id+"'";
		Connection con = ConnectionPool.getInstance().getConnection();
		java.sql.PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				form_component.setUuid(rs.getString("uuid"));
				form_component.setComponent_name(rs.getString("component_name"));
				form_component.setComponent_type(rs.getString("type_name"));
				form_component.setForm_id(rs.getString("form_id"));
				return form_component;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<FormComponent> findbyFormID(String form_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FormComponent findbyName(String name) {

		return null;
	}

}
