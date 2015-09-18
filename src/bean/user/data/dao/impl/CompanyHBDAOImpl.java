package bean.user.data.dao.impl;

import java.sql.SQLException;

import bean.dao.BaseDao;
import bean.user.User;
import bean.user.dao.UserDAO;
import bean.user.data.Company;
import bean.user.data.dao.CompanyDAO;
import database.dao.factory.DAOFactoryImpl;

public class CompanyHBDAOImpl extends BaseDao<Company> implements CompanyDAO {

	@Override
	public Company getCompanybyUserID(String userid){
		UserDAO userDAO = DAOFactoryImpl.getUserDAO();
		User user = userDAO.getUserbyID(userid);
		return user.getCompany();
	}

	@Override
	public void save(Company p) {
		super.saveObject(p);
	}

	@Override
	public Company getCompanybyID(String uuid) {
		return super.getObject(Company.class, uuid);
	}


	@Override
	public void delete(String id) {
		super.deleteObject(getCompanybyID(id));
	}

}
