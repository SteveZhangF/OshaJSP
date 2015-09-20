package bean.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import database.HibernateSessionFactory;
import database.HibernateUtil;

public class BaseDao<T> {

	private static Log log = LogFactory.getLog(BaseDao.class);

	/**
	 * 获取Hibernate的Session对象
	 */
	public Session getSession() {
		return HibernateSessionFactory.getSession();
	}

	/**
	 * 根据主键得到对象
	 */
	public T getObject(Class clazz, Serializable id) {
		Session session = getSession();
		session.clear();
		T obj = (T) session.get(clazz, id);
		return obj;
	}

	public List<T> getAll(Class clzz) {
		Session sess = getSession();
		sess.clear();
		List<T> list =  sess.createCriteria(clzz).list();
		return list;
	}

	/**
	 * 保存对象
	 */
	public void saveObject(T t) {
		Session session = getSession();
		Transaction tx = beginTransaction(session);
		try {
			session.saveOrUpdate(t);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			log.error("保存对象失败");
		} finally {
			this.getSession().flush();
			HibernateUtil.closeSession(session);
		}
	}

	public void deleteObject(T t) {
		Session session = getSession();
		Transaction tx = beginTransaction(session);
		try {
			session.delete(t);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
			log.error("保存对象失败");
		} finally {
			HibernateUtil.closeSession(session);
		}
	}

	/**
	 * 创建事务
	 */
	private Transaction beginTransaction(Session session) {
		return session.beginTransaction();
	}
}