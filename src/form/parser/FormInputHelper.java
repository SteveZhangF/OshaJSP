package form.parser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import bean.form.CompanyForm;
import bean.form.DepartmentForm;
import bean.form.EmployeeForm;
import bean.form.Form;
import bean.form.component.FormComponent;
import bean.form.module.Module;
import database.dao.factory.DAOFactoryImpl;


public class FormInputHelper {

	
	public void saveForm(String moduleID,String formType, String formhtml){
		Form form = null;

		switch (formType) {
		case "CompanyForm":
			form = new CompanyForm();
			break;
		case "DepartmentForm":
			form = new DepartmentForm();
			break;
		case "EmployeeForm":
			form = new EmployeeForm();
			break;
		default:
			break;
		}
		Module module = DAOFactoryImpl.getModuleDAO().getModuleById(moduleID);
		module.addForm(form);
		DAOFactoryImpl.getModuleDAO().save(module);
		
		DAOFactoryImpl.getFormDAO().save(form);
		System.out.println(form.getUuid());
		
		org.jsoup.nodes.Document docHtml = Jsoup.parse(formhtml);
		Elements plugins = docHtml.getElementsByClass("fqzplugin");
		
		int i=0;
		for(Element plugin: plugins){
			String name = plugin.attr("name");
			if(plugin.hasClass("fqzplugin-form_name")){
				form.setName(plugin.text());
			}else if(plugin.hasClass("fqzplugin-text")){
				FormComponent fc = new FormComponent();
				fc.setComponent_name(name);
				fc.setComponent_type("text");
				fc.setSequence_code(i);
				fc.setForm(form);
				fc.setComponent_content("");
				form.add(fc);
				
				DAOFactoryImpl.getFormComponentDAO().save(fc);
				plugin.attr("id", fc.getUuid());
				System.out.println(plugin.toString());
			}
		}
		File file = new File("upload/forms/"+form.getUuid());
		Date date = new Date();
		file.mkdirs();
		try {
			file = new File("upload/forms/"+form.getUuid()+"/"+date.getTime()+".html");
			FileWriter fWriter = new FileWriter(file);
			fWriter.write(docHtml.toString());
			fWriter.flush();
			form.setHtmlPath(file.getAbsolutePath());
			DAOFactoryImpl.getFormDAO().save(form);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}