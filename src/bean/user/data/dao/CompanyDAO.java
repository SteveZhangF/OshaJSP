package bean.user.data.dao;

import java.sql.SQLException;

import bean.user.data.Company;

public interface CompanyDAO {
	public Company getCompanybyUserID(String userid) throws SQLException;
	
	public String save(Company p) throws SQLException;

	public Company getCompanybyID(String uuid) throws SQLException;

	public void update(Company p) throws SQLException;

	public void delete(String id) throws SQLException;

}
