package database;
/*
*Hibernate工具类,Hibernate映射操作公用类
*负责初始化、打开连接、获取连接、关闭连接等操作
*/

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static String CONFIG_FILE_LOCATION = "/hibernate.cfg.xml";// 配置文件位置
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();// 线程
	private static Configuration configuration = new Configuration();
	private static org.hibernate.SessionFactory sessionFactory;// 会话工厂
	private static String configFile = CONFIG_FILE_LOCATION;
	
//	session = sessionFactory.openSession();
	
	
	static {
		try {
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/***
	 * 获得session
	 * 
	 * @return
	 * @throws HibernateException
	 */
	public static Session getSession() throws HibernateException {
		Session session = (Session) threadLocal.get();

		if (session == null || !session.isOpen()) {
			if (sessionFactory == null) {
				rebuildSessionFactory();
			}
			session = (sessionFactory != null) ? sessionFactory.openSession() : null;
			threadLocal.set(session);
		}

		return session;
	}

	/*
	 * 重新创建SessionFactory
	 */
	public static void rebuildSessionFactory() {
		try {
			configuration.configure(configFile);
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("无法 在 baseDao 中 创建 SessionFactory ");
			e.printStackTrace();
		}
	}

	/*
	 * 获取当前session
	 */
	public static Session currentSession() throws HibernateException {
		Session session = sessionFactory.openSession();
		return session;
	}

	/*
	 * 关闭session
	 */
	public static void closeSession(Session session) {
		// Session session = (Session) threadLocal.get();
		threadLocal.set(null);
		if (session != null) {
			session.close();
		}

	}

	/**
	 * return session factory
	 */
	public static org.hibernate.SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * return session factory
	 * <p/>
	 * session factory will be rebuilded in the next call
	 */
	public static void setConfigFile(String configFile) {
		HibernateUtil.configFile = configFile;
		sessionFactory = null;
	}

	/**
	 * return hibernate configuration
	 */
	public static Configuration getConfiguration() {
		return configuration;
	}
}