package dao.user.data.impl;

import bean.dao.BaseDao;
import bean.user.data.Department;
import bean.user.data.Employee;
import dao.user.data.DepartmentDAO;
import dao.user.data.EmployeeDAO;
import database.dao.factory.DAOFactoryImpl;

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
			this.save(subd);
		}
		department.getSubDepartment().clear();
		EmployeeDAO edao = DAOFactoryImpl.getEmployeeDAO();
		for (Employee emp : department.getEmployees()) {
			emp.setDepartment(null);
			emp.setCompany(department.getCompany());
			edao.save(emp);
		}
		department.getEmployees().clear();
		
		department.getCompany().getDepartments().remove(department);
		super.deleteObject(getDepartmentbyID(id));
	}

}
