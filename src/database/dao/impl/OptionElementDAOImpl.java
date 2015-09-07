package database.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionPool;
import database.dao.OptionElementDAO;
import model.OptionElement;

public class OptionElementDAOImpl implements OptionElementDAO{

	@Override
	public void add(OptionElement p) throws SQLException {
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		String sql = "INSERT INTO `form_model`.`model_item`" + "(" + "`desc`," + "`parent_id`," + "`sequence_code`,"
				+ "`item_type`," + "`name`)" + "VALUES" + "(?,?,?,?,?);";
		try {
			con = ConnectionPool.getInstance().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, p.getDescription());
			ps.setString(2, p.getParentID());
			ps.setString(3, p.getSequenceCode());
			ps.setString(4, p.getClass().getName());
			ps.setString(5, p.getName());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			ConnectionPool.getInstance().release();
		}
	}

	@Override
	public void update(OptionElement p) throws SQLException {
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		String sql = " UPDATE `form_model`.`model_item`" + "SET" + "`desc` = ?," + "`parent_id` = ?,"
				+ "`sequence_code` = ?," + "`item_type` = ?," + "`name` = ?" + "WHERE `id` = ?";

		try {
			con = ConnectionPool.getInstance().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, p.getDescription());
			ps.setString(2, p.getParentID());
			ps.setString(3, p.getSequenceCode());
			ps.setString(4, p.getClass().getName());
			ps.setString(5, p.getName());
			ps.setString(6, p.getId());
			System.out.println(ps.toString());
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			ConnectionPool.getInstance().release();
		}

	}

	@Override
	public void delete(String id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM `form_model`.`model_item` WHERE 'id'=?";
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		try {
			con = ConnectionPool.getInstance().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			ConnectionPool.getInstance().release();
		}

	}

	@Override
	public List<OptionElement> findbyParentID(String id) throws SQLException {
		String sql = "SELECT `model_item`.`id`,`model_item`.`desc`,`model_item`.`parent_id`,`model_item`.`sequence_code`, `model_item`.`item_type`,  `model_item`.`default`,  `model_item`.`name`FROM `form_model`.`model_item`  WHERE parent_id =?";
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;

		List<OptionElement> all = new ArrayList<OptionElement>();

		try {
			con = ConnectionPool.getInstance().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				OptionElement te = null;
				String type = rs.getString("item_type");
				te = (OptionElement) Class.forName(type).newInstance();
				te.setName(rs.getString("name"));
				te.setDescription(rs.getString("desc"));
				te.setId(String.valueOf(rs.getString("id")));
				te.setParentID(rs.getString("parent_id"));
				te.setSequenceCode(rs.getString("sequence_code"));
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
	public OptionElement findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		OptionElement te = null;
		String sql = "SELECT " + " `model_item`.`desc`," + " `model_item`.`parent_id`,"
				+ " `model_item`.`sequence_code`," + " `model_item`.`item_type`," + " `model_item`.`default`,"
				+ " `model_item`.`name`" + " FROM `form_model`.`model_item`" + " where `model_item`.`id`=?";
		try {
			con = ConnectionPool.getInstance().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				String type = rs.getString("item_type");
				te = (OptionElement) Class.forName(type).newInstance();
				te.setName(rs.getString("name"));
				te.setDescription(rs.getString("desc"));
				te.setId(String.valueOf(id));
				te.setParentID(rs.getString("parent_id"));
				te.setSequenceCode(rs.getString("sequence_code"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			ConnectionPool.getInstance().release();
		}
		return te;
	}

	@Override
	public List<OptionElement> findAll() throws SQLException {
		String sql = "SELECT `model_item`.`id`,`model_item`.`desc`,`model_item`.`parent_id`,`model_item`.`sequence_code`, `model_item`.`item_type`,  `model_item`.`default`,  `model_item`.`name`FROM `form_model`.`model_item`";
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;

		List<OptionElement> all = new ArrayList<OptionElement>();

		try {
			con = ConnectionPool.getInstance().getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				OptionElement te = null;
				String type = rs.getString("item_type");
				te = (OptionElement) Class.forName(type).newInstance();
				te.setName(rs.getString("name"));
				te.setDescription(rs.getString("desc"));
				te.setId(String.valueOf(rs.getString("id")));
				te.setParentID(rs.getString("parent_id"));
				te.setSequenceCode(rs.getString("sequence_code"));
				all.add(te);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			ConnectionPool.getInstance().release();
		}

		return all;
	}

}
