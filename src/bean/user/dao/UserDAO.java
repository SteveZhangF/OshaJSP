package bean.user.dao;

import java.sql.SQLException;

import bean.user.User;

public interface UserDAO {
	
	public static final int LOGIN_NOUSERFIND = 1;
	public static final int LOGIN_PASSWORDWRONG = 2;
	public static final int LOGIN_SUCCESS = 0;
	
	public void save(User p) throws SQLException;

	public User getUser(String email) throws SQLException;
	
	public User getUserbyID(String uuid) throws SQLException;

	public void update(User p) throws SQLException;

	public void delete(String id) throws SQLException;
	
	public int check(String email, String pwd) throws SQLException;
}
