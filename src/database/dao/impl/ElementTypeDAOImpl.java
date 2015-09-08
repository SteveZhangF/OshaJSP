package database.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.lang.model.element.Element;

import database.ConnectionPool;
import database.dao.ElementTypeDAO;
import model.ElementType;
import model.OptionElement;

public class ElementTypeDAOImpl implements ElementTypeDAO {

	@Override
	public void add(ElementType p) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		String sql = "INSERT INTO `form_model`.`model_type`" + "(" + "`type_name`," + "`type_value`," + "`type_class`)"
				+ "VALUES" + "(?,?,?);";

		try {
			con = ConnectionPool.getInstance().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setString(2, p.getValue());
			ps.setString(3, p.getType_class());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			ConnectionPool.getInstance().release();
		}
	}

	@Override
	public void update(ElementType p) throws SQLException {
		Connection con = null;
		String sql = "select *  from `form_model`.`model_type` where id=" + p.getId();
		try {
			con = ConnectionPool.getInstance().getConnection();
			Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = statement.executeQuery(sql);
			rs.first();
			if (p.getName() != null && !p.getName().equals(""))
				rs.updateString("type_name", p.getName());
			if (p.getType_class() != null && !p.getType_class().equals(""))
				rs.updateString("type_class", p.getType_class());
			if (p.getValue() != null && !p.getValue().equals(""))
				rs.updateString("type_value", p.getValue());
			rs.updateRow();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		} finally {
			ConnectionPool.getInstance().release();
		}
	}

	@Override
	public ElementType findById(String id) throws SQLException {
		ElementType et = new ElementType();
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * from form_model.model_type where id=?";
		try {
			con = ConnectionPool.getInstance().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				et.setId(rs.getString("id"));
				et.setName(rs.getString("type_name"));
				et.setType_class(rs.getString("type_class"));
				et.setValue(rs.getString("type_value"));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().release();
		}
		return et;
	}

	@Override
	public List<ElementType> findAll() throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * from form_model.model_type ";
		List<ElementType> list = new ArrayList<ElementType>();
		try {
			con = ConnectionPool.getInstance().getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				ElementType et = new ElementType();
				et.setId(rs.getString("id"));
				et.setName(rs.getString("type_name"));
				et.setType_class(rs.getString("type_class"));
				et.setValue(rs.getString("type_value"));
				list.add(et);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().release();
		}
		return list;
	}

	@Override
	public List<ElementType> findbyClass(String type_class) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * from form_model.model_type where type_class=?";
		List<ElementType> list = new ArrayList<>();
		try {
			con = ConnectionPool.getInstance().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, type_class);
			rs = ps.executeQuery();
			while (rs.next()) {
				ElementType et = new ElementType();
				et.setId(rs.getString("id"));
				et.setName(rs.getString("type_name"));
				et.setType_class(rs.getString("type_class"));
				et.setValue(rs.getString("type_value"));
				list.add(et);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().release();
		}
		return list;
	}

	@Override
	public void delete(String id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM `form_model`.`model_type` WHERE 'id'=?";
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		try {
			con = ConnectionPool.getInstance().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().release();
		}

	}

}
