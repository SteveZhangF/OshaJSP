package test.servlets.form.helpers;

import org.junit.Test;

import bean.user.data.Employee;
import database.dao.factory.DAOFactoryImpl;
import servlets.form.helpers.recordgenerator.RecordGenerator;

public class EmployeeRecordGeneratorTest {
	@Test
	public void testSave(){
		Employee employee = DAOFactoryImpl.getEmployeeDAO().getEmployeebyID("402880914fe96e2f014fe96fb4190002");
		RecordGenerator erg = new RecordGenerator(employee);
		erg.addRecordComponent("402880914fe473aa014fe479603c0001", "Steve");
		erg.save();
	}
}
