package dao.user.data.impl;

import java.sql.SQLException;

import bean.dao.BaseDao;
import bean.user.User;
import bean.user.data.Company;
import dao.user.UserDAO;
import dao.user.data.CompanyDAO;
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
