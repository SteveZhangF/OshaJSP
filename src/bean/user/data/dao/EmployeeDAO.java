package bean.user.data.dao;


import bean.user.data.Employee;

public interface EmployeeDAO {
	public void save(Employee p);

	public Employee getEmployeebyID(String uuid);

	public void delete(String id);
}
