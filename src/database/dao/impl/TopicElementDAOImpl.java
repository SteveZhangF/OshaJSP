package database.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionPool;
import database.dao.TopicElementDAO;
import model.TopicElement;

public class TopicElementDAOImpl implements TopicElementDAO {

	@Override
	public void add(TopicElement p) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		String sql = "INSERT INTO `form_model`.`model_topic`" + "(" + "`desc`," + "`parent_id`," + "`sequence_code`,"
				+ "`topic_type`," + "`name`)" + "VALUES" + "(?,?,?,?,?);";
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
	public void update(TopicElement p) throws SQLException {
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		String sql = " UPDATE `form_model`.`model_topic`" + "SET" + "`desc` = ?," + "`parent_id` = ?,"
				+ "`sequence_code` = ?," + "`topic_type` = ?," + "`name` = ?" + "WHERE `id` = ?";

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
		String sql = "DELETE FROM `form_model`.`model_topic` WHERE 'id'=?";
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
	public List<TopicElement> findbyParentID(String id) throws SQLException {
		String sql = "SELECT `model_topic`.`id`,`model_topic`.`desc`,`model_topic`.`parent_id`,`model_topic`.`sequence_code`, `model_topic`.`topic_type`,  `model_topic`.`default`,  `model_topic`.`name`FROM `form_model`.`model_topic`  WHERE parent_id =?";
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;

		List<TopicElement> all = new ArrayList<TopicElement>();

		try {
			con = ConnectionPool.getInstance().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				TopicElement te = null;
				String type = rs.getString("topic_type");
				te = (TopicElement) Class.forName(type).newInstance();
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
	public TopicElement findById(String id) throws SQLException {
		// TODO Auto-generated method stub
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;
		TopicElement te = null;
		String sql = "SELECT " + " `model_topic`.`desc`," + " `model_topic`.`parent_id`,"
				+ " `model_topic`.`sequence_code`," + " `model_topic`.`topic_type`," + " `model_topic`.`default`,"
				+ " `model_topic`.`name`" + " FROM `form_model`.`model_topic`" + " where `model_topic`.`id`=?";
		try {
			con = ConnectionPool.getInstance().getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				String type = rs.getString("topic_type");
				te = (TopicElement) Class.forName(type).newInstance();
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
	public List<TopicElement> findAll() throws SQLException {
		String sql = "SELECT `model_topic`.`id`,`model_topic`.`desc`,`model_topic`.`parent_id`,`model_topic`.`sequence_code`, `model_topic`.`topic_type`,  `model_topic`.`default`,  `model_topic`.`name`FROM `form_model`.`model_topic`";
		Connection con = null;
		java.sql.PreparedStatement ps = null;
		ResultSet rs = null;

		List<TopicElement> all = new ArrayList<TopicElement>();

		try {
			con = ConnectionPool.getInstance().getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				TopicElement te = null;
				String type = rs.getString("topic_type");
				te = (TopicElement) Class.forName(type).newInstance();
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
