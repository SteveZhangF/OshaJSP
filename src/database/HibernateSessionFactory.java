package database;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateSessionFactory {
	private static final Logger LOGGER = Logger.getLogger("Hibernate-Tutorial");

	public static void main(String[] args) {
		
//		try {
//			System.out.println(new CompanyHBDAOImpl().getCompanybyUserID("402880914fdf58ec014fdf58ef6b0003").getCompany_name());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
//		UserHBDAOImpl udao = new UserHBDAOImpl();
//		User user = new User();
//		user.setUser_email("emaidddl1`@email.com");
//		Company c = new Company();
//		c.setCompany_name("MyCompany");
//		
//		BaseDao<Company> bc = new BaseDao<Company>() {
//		};
//		Department d = new Department();
//		d.setDepartment_name("departeanasddsa");
//		c.addDepartment(d);
//		bc.saveObject(c);
//		new BaseDao<Department>() {
//		}.saveObject(d);
//		
//		Employee e = new Employee();
//		e.setEmployeename("Steve");
//		d.addEmployee(e);
//		new BaseDao<Employee>() {
//		}.saveObject(e);
//		
//		user.setCompany(c);
//		try {
//			udao.save(user);
////			System.out.println(udao.getUser("email@email.com").getUser_email());
//		} catch (SQLException dz) {
//			// TODO Auto-generated catch block
//			dz.printStackTrace();
//		}
	}

	public static Session getSession() {
//		SessionFactory sessionFactory = null;
//		Session session = null;
//		try {
//			Configuration configuration = new Configuration();
//			configuration.configure("hibernate.cfg.xml");
//			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
//			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//			session = sessionFactory.openSession();
//		} catch (Exception e) {
//			LOGGER.log(Level.SEVERE, e.getMessage(), e);
//		} finally {
//		}
		return HibernateUtil.getSession();
	}
	
}