package form.parser;

import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import bean.dao.BaseDao;
import bean.form.CompanyForm;
import bean.form.DepartmentForm;
import bean.form.EmployeeForm;
import bean.form.Form;
import bean.form.component.FormComponent;

/**
 * 
 * 
 * <form id="form_id" name=""><component name="æ–‡æœ¬æ¡†" id="component_id" type
 * ="text"></component>
 * <component><option display_name="é€‰é¡¹ä¸€" value="é€‰é¡¹ä¸€"></option>
 * <option display_name="é€‰é¡¹äºŒ" value="é€‰é¡¹äºŒ"></option>
 * <option display_name="é€‰é¡¹ä¸‰" value="é€‰é¡¹ä¸‰"></option></component>
 * </form>
 * 
 */

public class FormInputHelper {

	public Form createForm(String formDataXML, String formType) {

		org.jsoup.nodes.Document doc = Jsoup.parse(formDataXML);
		org.jsoup.nodes.Element form_element = doc.select("form").first();// find
																			// form
		String form_name = form_element.attr("name");

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

		form.setName(form_name);

		List<org.jsoup.nodes.Element> componentList = form_element.select("component");

		for (int i = 0; i < componentList.size(); i++) {
			Element component_element = (Element) componentList.get(i);
			String component_name = component_element.attr("name");
			String component_type = component_element.attr("type");
			FormComponent fc = new FormComponent();
			fc.setComponent_name(component_name);
			fc.setComponent_type(component_type);
			fc.setForm(form);
			fc.setComponent_content(component_element.html());
			form.add(fc);
		}
		return form;
	}

}