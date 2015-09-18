package bean.user.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.dao.BaseDao;
import bean.user.User;
import bean.user.dao.UserDAO;
import global.MD5;

public class UserHBDAOImpl extends BaseDao<User> implements UserDAO {
	
	@Override
	public void save(User user) {
		super.saveObject(user);
	}

	@Override
	public User getUser(String email) {
		// TODO Auto-generated method stub
		Session session = getSession();
		Transaction tx = null;
		User user = null;
		try {
			tx = session.beginTransaction();
			List users = session.createQuery("FROM User where user_email='"+email+"'").list();
			if(users.size()==0)
				return null;
			user = (User) users.get(0);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}

	@Override
	public User getUserbyID(String uuid) {
		return super.getObject(User.class, uuid);
	}

	@Override
	public void delete(String id) {
		super.deleteObject(getUserbyID(id));
	}

	@Override
	public int check(String email, String pwd) {
		// TODO Auto-generated method stub
		int index=0;
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
