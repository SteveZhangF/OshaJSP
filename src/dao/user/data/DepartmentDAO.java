package dao.user.data;

import bean.user.data.Department;

public interface DepartmentDAO  {
	public void save(Department p);
	public Department getDepartmentbyID(String uuid);
	public void delete(String id);

}
