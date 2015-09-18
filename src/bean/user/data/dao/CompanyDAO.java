package bean.user.data.dao;

import java.sql.SQLException;

import bean.user.data.Company;

public interface CompanyDAO {
	public Company getCompanybyUserID(String userid);
	
	public void save(Company p) ;

	public Company getCompanybyID(String uuid) ;

	public void delete(String id) ;

}

