package dao.user.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.junit.Test;

import bean.dao.BaseDao;
import bean.user.User;
import dao.user.UserDAO;
import global.MD5;

public class UserHBDAOImpl extends BaseDao<User>implements UserDAO {

	
	@Test
	public void Test(){
		UserHBDAOImpl dao = new UserHBDAOImpl();
		dao.getUser("dd");
	}
	@Override
	public int check(String email, String pwd) {
		// TODO Auto-generated method stub
		int index = 0;
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

	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		Session session = getSession();
		List<User> list = session.createQuery(" from User where user_email='" + email + "'").list();
//		session.close();
		if (list.size() == 0)
			return null;
		return list.get(0);
	}

	@Override
	public User getUserbyID(String uuid) {
		// TODO Auto-generated method stub
		User user = super.getObject(User.class, uuid);
		return user;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		super.deleteObject(getUserbyID(id));
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		super.saveObject(user);
		
	}
	@Override
	public List<User> list() {
		return super.getAll(User.class);
	}

}
