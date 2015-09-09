package database.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionPool;
import database.dao.TopicElementDAO;
import database.dao.factory.DAOFactoryImpl;
import engine.htmlengine.TemplatePool;
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
			ps.setString(1, p.getDescription().trim());
			ps.setString(2, p.getParentID().trim());
			ps.setString(3, p.getSequenceCode().trim());
			ps.setString(4, p.getType().trim());
			ps.setString(5, p.getName().trim());
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().release();
		}
	}

	@Override
	public void update(TopicElement p) throws SQLException {
		Connection con = null;
		String sql = "select *  from `form_model`.`model_topic` where id=" + p.getId();
		try {
			con = ConnectionPool.getInstance().getConnection();
			Statement statement = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = statement.executeQuery(sql);
			rs.first();
			if (p.getDescription() != null && !p.getDescription().equals(""))
				rs.updateString("desc", p.getDescription().trim());
			if (p.getParentID() != null && !p.getParentID().equals(""))
				rs.updateString("parent_id", p.getParentID().trim());
			if (p.getSequenceCode() != null && !p.getSequenceCode().equals(""))
				rs.updateString("sequence_code", p.getSequenceCode().trim());
			if (p.getType() != null && !p.getType().equals(""))
				rs.updateString("topic_type", p.getType().trim());
			if (p.getName() != null && !p.getName().equals(""))
				rs.updateString("name", p.getName().trim());
			rs.updateRow();
		} catch (Exception e) {
			e.printStackTrace();
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
//			System.out.println(ps.executeUpdate());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().release();
		}
	}

	@Override
	public List<TopicElement> findbyParentID(String id) throws SQLException {
		String sql = "SELECT `model_topic`.`id`,`model_topic`.`desc`,`model_topic`.`parent_id`,`model_topic`.`sequence_code`, `model_topic`.`topic_type`,  `model_topic`.`default`,  `model_topic`.`name`FROM `form_model`.`model_topic`  WHERE parent_id =? order by sequence_code";
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
				te.setType(type);
				all.add(te);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
				te.setType(type);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
				te.setType(type);
				all.add(te);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			ConnectionPool.getInstance().release();
		}

		return all;
	}

}
