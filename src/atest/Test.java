package atest;


import bean.dao.BaseDao;
import bean.form.CompanyForm;
import bean.form.EmployeeForm;
import bean.form.component.FormComponent;
import bean.form.module.Module;
import bean.form.record.CompanyRecord;
import bean.form.record.EmployeeRecord;
import bean.form.record.component.FormRecordComponent;
import bean.user.data.Company;
import bean.user.data.Employee;
import database.dao.factory.DAOFactoryImpl;

public class Test {
//	@org.junit.Test
//	public void run(){
//		CompanyForm cf = new CompanyForm();
//		FormComponent fc = new FormComponent();
//		cf.add(fc);
//		cf.setName("companyform");
//		Module module = new Module();
//		module.setName("newModule");
//		module.addForm(cf);
//		
//		
//		BaseDao<Module> dao=new BaseDao<Module>() {
//		};
//		
//		Company company = new Company();
//		company.setCompany_name("My Company");
//		dao.saveObject(module);
//		
//		company.addModule(module);
//		DAOFactoryImpl.getCompanyDAO().save(company);
//		
//		CompanyRecord fr = new CompanyRecord();
//		fr.setCompany(company);
//		fr.setForm(cf);
//		
//		EmployeeForm ef = new EmployeeForm();
//		ef.setName("employee form");
//		
//		module.addForm(ef);
//		EmployeeRecord er = new EmployeeRecord();
//		FormRecordComponent frc = new FormRecordComponent();
//		frc.setfComponent(fc);
//		er.add(frc);
//		
//		
//		Employee ee = new Employee();
//		ee.setEmployeename("steve");
//		
//		DAOFactoryImpl.getEmployeeDAO().save(ee);
//		
//		BaseDao<EmployeeForm> eefdao = new BaseDao<EmployeeForm>() {
//		};
//		eefdao.saveObject(ef);
//		
//		
//		
//		er.setEmployee(ee);
//		er.setForm(ef);
//		BaseDao<EmployeeRecord> dao3=new BaseDao<EmployeeRecord>() {
//		};
//		dao3.saveObject(er);
////		
//		
//		
//		BaseDao<CompanyRecord> dao2=new BaseDao<CompanyRecord>() {
//		};
//		
//		dao2.saveObject(fr);
//		
//		
//	}

	@org.junit.Test
	public void test(){
		Employee e = DAOFactoryImpl.getEmployeeDAO().getEmployeebyID("402880914fe96e2f014fe96fb4190002");
		System.out.println(e.getRecords().size());
	}
	

}
