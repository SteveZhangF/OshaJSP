package database.dao.factory;

import bean.user.dao.UserDAO;
import bean.user.dao.impl.UserHBDAOImpl;
import bean.user.data.dao.CompanyDAO;
import bean.user.data.dao.DepartmentDAO;
import bean.user.data.dao.EmployeeDAO;
import bean.user.data.dao.impl.CompanyHBDAOImpl;
import bean.user.data.dao.impl.DepartmentHBDAOImpl;
import bean.user.data.dao.impl.EmployeeHBDAOImpl;
import form.bean.dao.FormComponentDAO;
import form.bean.dao.FormDAO;
import form.bean.dao.impl.FormComponentDAOImpl;
import form.bean.dao.impl.FormDAOImpl;

public class DAOFactoryImpl {


	public static UserDAO getUserDAO() {
		return new UserHBDAOImpl();
	}
	
	public static CompanyDAO getCompanyDAO(){
		return new CompanyHBDAOImpl();
	}
	
	public static DepartmentDAO getDepartmentDAO(){
		return new DepartmentHBDAOImpl();
	}
	
	public static EmployeeDAO getEmployeeDAO(){
		return new EmployeeHBDAOImpl();
	}
	
	public static FormDAO getFormDAO(){
		return new FormDAOImpl();
	}
	
	public static FormComponentDAO getFormComponentDAO(){
		return new FormComponentDAOImpl();
	}
}
