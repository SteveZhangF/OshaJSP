package dao.user.data;

import java.sql.SQLException;

import bean.user.data.Department;

public interface DepartmentDAO {
	public void save(Department p) throws SQLException;
	
	public Department getDepartmentbyID(String uuid) throws SQLException;


	public void delete(String id) throws SQLException;
	
}
