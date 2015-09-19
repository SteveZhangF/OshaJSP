package dao.user.data.impl;

import bean.dao.BaseDao;
import bean.user.data.Employee;
import dao.user.data.EmployeeDAO;

public class EmployeeHBDAOImpl extends BaseDao<Employee>implements EmployeeDAO {

	@Override
	public void save(Employee p) {
		// TODO Auto-generated method stub
		super.saveObject(p);
	}

	@Override
	public Employee getEmployeebyID(String uuid) {
		// TODO Auto-generated method stub
		return super.getObject(Employee.class, uuid);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		super.deleteObject(getEmployeebyID(id));

	}

}
