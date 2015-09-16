package database.dao.factory;

import bean.user.dao.UserDAO;
import bean.user.dao.impl.UserDAOImpl;
import bean.user.data.dao.CompanyDAO;
import bean.user.data.dao.impl.CompanyDAOImpl;
import database.dao.ElementTypeDAO;
import database.dao.OptionElementDAO;
import database.dao.TopicElementDAO;
import database.dao.impl.ElementTypeDAOImpl;
import database.dao.impl.OptionElementDAOImpl;
import database.dao.impl.TopicElementDAOImpl;
import form.bean.dao.FormComponentDAO;
import form.bean.dao.FormDAO;
import form.bean.dao.impl.FormComponentDAOImpl;
import form.bean.dao.impl.FormDAOImpl;

public class DAOFactoryImpl {

	public static TopicElementDAO getTopicElementDAO() {
		return new TopicElementDAOImpl();
	}

	public static OptionElementDAO getOptionElementDAO() {
		return new OptionElementDAOImpl();
	}

	public static ElementTypeDAO getElementTypeDAO() {
		return new ElementTypeDAOImpl();
	}

	public static UserDAO getUserDAO() {
		return new UserDAOImpl();
	}
	
	public static CompanyDAO getCompanyDAO(){
		return new CompanyDAOImpl();
	}
	
	public static FormDAO getFormDAO(){
		return new FormDAOImpl();
	}
	
	public static FormComponentDAO getFormComponentDAO(){
		return new FormComponentDAOImpl();
	}
}
