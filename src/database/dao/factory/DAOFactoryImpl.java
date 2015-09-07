package database.dao.factory;

import database.dao.TopicElementDAO;
import database.dao.impl.TopicElementDAOImpl;

public class DAOFactoryImpl {

	public static TopicElementDAO getTopicElementDAO() {
		return new TopicElementDAOImpl();
	}

}
