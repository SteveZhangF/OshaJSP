package dao.user.data.impl;

import bean.dao.BaseDao;
import bean.form.record.FormRecord;
import bean.user.data.Company;
import bean.user.data.Department;
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
		
		Employee employee = this.getEmployeebyID(id);
		Company company = employee.getCompany();
		if(company!=null){
			company.getEmployees().remove(employee);
		}
		Department department = employee.getDepartment();
		if(department!=null){
			department.getEmployees().remove(employee);
		}
		
		for(FormRecord fr:employee.getRecords()){
			fr.setOe(null);
		}
		employee.getRecords().clear();
		super.deleteObject(employee);
	}

}
