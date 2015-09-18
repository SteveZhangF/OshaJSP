package bean.user.dao;

import bean.user.User;

public interface UserDAO {
	
	public static final int LOGIN_NOUSERFIND = 1;
	public static final int LOGIN_PASSWORDWRONG = 2;
	public static final int LOGIN_SUCCESS = 0;
	
	public void save(User p);

	public User getUser(String email);
	
	public User getUserbyID(String uuid) ;


	public void delete(String id) ;
	
	public int check(String email, String pwd);
}
