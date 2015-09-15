package bean.user.data.dao;

import java.sql.SQLException;

import bean.user.data.Department;

public interface DepartmentDAO {
	public String save(Department p) throws SQLException;
	
	public Department getDepartmentbyID(String uuid) throws SQLException;

	public void update(Department p) throws SQLException;

	public void delete(String id) throws SQLException;
	
}
