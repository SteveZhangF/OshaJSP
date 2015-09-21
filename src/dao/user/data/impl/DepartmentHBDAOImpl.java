package dao.user.data.impl;

import bean.dao.BaseDao;
import bean.user.data.Company;
import bean.user.data.Department;
import bean.user.data.Employee;
import dao.user.data.DepartmentDAO;

public class DepartmentHBDAOImpl extends BaseDao<Department>implements DepartmentDAO {

	@Override
	public void save(Department p) {
		super.saveObject(p);
	}

	@Override
	public Department getDepartmentbyID(String uuid) {
		return super.getObject(Department.class, uuid);

	}

	@Override
	public void delete(String id) {
		Department department = this.getDepartmentbyID(id);
		for (Department subd : department.getSubDepartment()) {
			subd.setParentDepartment(null);
		}
		department.getSubDepartment().clear();
		for (Employee emp : department.getEmployees()) {
			emp.setDepartment(null);
		}
		department.getEmployees().clear();
		Company company = department.getCompany();
		company.getDepartments().remove(department);
		department.setCompany(null);
		super.deleteObject(department);
	}
}
