package servlets.form.helpers.formsgenerator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import bean.form.Form;
import bean.form.module.Module;
import bean.form.record.FormRecord;
import bean.form.record.FormRecord.FormRecordType;
import bean.user.data.Company;
import bean.user.data.Employee;
import database.dao.factory.DAOFactoryImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class EmployeeFormGenerator {
	public static List<Form> getForms(String employee_id) {
		Employee employee = DAOFactoryImpl.getEmployeeDAO().getEmployeebyID(employee_id);
		Company company = employee.getCompany();
		List<Form> forms = new ArrayList<>();

		for (Module module : company.getModules()) {
			for (Form f : module.getForms()) {
				if (f.getForm_type() != null && f.getForm_type().equalsIgnoreCase("Employee Form")) {
					forms.add(f);
				}
			}
		}
		return forms;
	}
	
	@Test
	public void test(){
		System.out.println(EmployeeFormGenerator.getModule("402880914fe95e88014fe95ee4a30000"));
	}
	
	public static String getModule(String employee_id){
		Employee employee = DAOFactoryImpl.getEmployeeDAO().getEmployeebyID(employee_id);
		Company company = employee.getCompany();
		
		JSONArray modJSON = new JSONArray();
		for (Module module : company.getModules()) {
			
			JSONArray jsonArray = new JSONArray();
			for(Form form:module.getForms()){
				if(form.getForm_type()!=null && form.getForm_type().equals("Employee Form")){
					JSONObject jso = new JSONObject();
					jso.put("id", form.getUuid());
					jso.put("name", form.getName());
					
					
					for(FormRecord fr: form.getFormRecords()){
						if(fr.getFormreocrd_type()==FormRecordType.EmployeeRecord){
							
						}
					}
					
					
					jsonArray.add(jso);
				}
			}
			//this module has the employee forms
			if(jsonArray.size()!=0){
				JSONObject jsonModule = new JSONObject();
				jsonModule.put("id", module.getId());
				jsonModule.put("name", module.getName());
				jsonModule.put("forms",jsonArray);
				modJSON.add(jsonModule);
			}
		}
		return modJSON.toString();
	}
}
