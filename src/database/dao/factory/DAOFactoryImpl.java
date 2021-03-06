package database.dao.factory;

import dao.form.FormComponentDAO;
import dao.form.FormDAO;
import dao.form.impl.FormComponentHBDAOImpl;
import dao.form.impl.FormHbDaoImpl;
import dao.form.module.ModuleDAO;
import dao.form.module.impl.ModuleHBDAOImpl;
import dao.form.record.RecordComponentDAO;
import dao.form.record.RecordDAO;
import dao.form.record.impl.FormRecordComponentHBDAOImpl;
import dao.form.record.impl.FormRecordHBDAOImpl;
import dao.user.UserDAO;
import dao.user.data.CompanyDAO;
import dao.user.data.DepartmentDAO;
import dao.user.data.EmployeeDAO;
import dao.user.data.OrganizationElementDAO;
import dao.user.data.impl.CompanyHBDAOImpl;
import dao.user.data.impl.DepartmentHBDAOImpl;
import dao.user.data.impl.EmployeeHBDAOImpl;
import dao.user.data.impl.OrganizationElementHBDAOImpl;
import dao.user.impl.UserHBDAOImpl;

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
		return new FormHbDaoImpl();
	}
	
	public static FormComponentDAO getFormComponentDAO(){
		return new FormComponentHBDAOImpl();
	}
	
	public static ModuleDAO getModuleDAO(){
		return new ModuleHBDAOImpl();
	}
	
	public static RecordDAO getFormRecordDAO(){
		return new FormRecordHBDAOImpl();
	} 
	
	public static RecordComponentDAO getFormRecordComponentDAO(){
		return new FormRecordComponentHBDAOImpl();
	}
	
	public static OrganizationElementDAO getOrganizationElementDAO(){
		return new OrganizationElementHBDAOImpl();
	}
}
