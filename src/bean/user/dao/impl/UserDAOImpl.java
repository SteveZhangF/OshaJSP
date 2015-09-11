package bean.user.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.user.User;
import bean.user.dao.UserDAO;
import database.ConnectionPool;
import global.MD5;
import model.TopicElement;

public class UserDAOImpl implements UserDAO {

	@Override
	public void save(User p) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public User getUser(String email) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public User getUserbyID(String uuid) throws SQLException {
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
				te = new TopicElement();
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
		return null;
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
		int index;
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
