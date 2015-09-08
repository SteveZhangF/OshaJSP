package database.dao.factory;

import database.dao.ElementTypeDAO;
import database.dao.OptionElementDAO;
import database.dao.TopicElementDAO;
import database.dao.impl.ElementTypeDAOImpl;
import database.dao.impl.OptionElementDAOImpl;
import database.dao.impl.TopicElementDAOImpl;

public class DAOFactoryImpl {

	public static TopicElementDAO getTopicElementDAO() {
		return new TopicElementDAOImpl();
	}

	public static OptionElementDAO getOptionElementDAO() {
		return new OptionElementDAOImpl();
	}
	
	public static ElementTypeDAO getElementTypeDAO(){
		return new ElementTypeDAOImpl();
	}
}
