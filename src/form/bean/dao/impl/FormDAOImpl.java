package form.bean.dao.impl;

import java.awt.event.FocusEvent;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import database.ConnectionPool;
import form.bean.Form;
import form.bean.dao.FormDAO;
import global.UUIDGenerator;
import model.OptionElement;

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
			String uuid = p.getUuid();
			ps = con.prepareStatement(sql);
			ps.setString(1, uuid);
			ps.setString(2, p.getName());
			ps.setString(3, p.getTemplate_xml());
			
			ps.setBlob(3, new ByteArrayInputStream(p.getTemplate_xml().getBytes()));
			
			
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
		String sql = "SELECT * FROM form_model.tb_form";
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;

		List<Form> all = new ArrayList<Form>();

		try {
			con = ConnectionPool.getInstance().getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Form te = new Form();
				te.setUuid(rs.getString("uuid"));
				te.setName(rs.getString("name"));
				all.add(te);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			ConnectionPool.getInstance().release();
		}

		return all;
	}

	@Override
	public List<Form> findbyIndustry(int industry_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Form findFormbyID(String formid) {
		// TODO Auto-generated method stub
		Form form = new Form();
		String sql = "select * from form_model.tb_form where uuid='"+formid+"'";
		Connection con = ConnectionPool.getInstance().getConnection();
		java.sql.PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				form.setUuid(rs.getString("uuid"));
				form.setName(rs.getString("name"));
				Blob blob = rs.getBlob("template_xml");
				
				BufferedReader br = new BufferedReader(new InputStreamReader(blob.getBinaryStream()));
				String tmp="";
				StringBuffer sb = new StringBuffer();
				try {
					while((tmp=br.readLine())!=null){
						sb.append(tmp);
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				form.setTemplate_xml(sb.toString());
				return form;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
