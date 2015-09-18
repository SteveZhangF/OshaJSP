package form.parser;

import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import bean.dao.BaseDao;
import form.bean.Form;
import form.bean.FormComponent;

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


	public void save(String formDataXML) {

		org.jsoup.nodes.Document doc = Jsoup.parse(formDataXML);
		org.jsoup.nodes.Element form_element = doc.select("form").first();// find
																			// form
		String form_name = form_element.attr("name");
		Form form = new Form();
		form.setName(form_name);
		form.setTemplate_xml(formDataXML);

		List<org.jsoup.nodes.Element> componentList = form_element.select("component");

		for (int i = 0; i < componentList.size(); i++) {
			Element component_element = (Element) componentList.get(i);
			String component_name = component_element.attr("name");
			String component_type = component_element.attr("type");
//			String component_id = component_element.attr("id");
			FormComponent fc = new FormComponent();
			fc.setComponent_name(component_name);
			fc.setComponent_type(component_type);
			fc.setForm(form);
			fc.setComponent_content(component_element.html());
			form.add(fc);
		}
		new BaseDao<Form>() {
		}.saveObject(form);
	}

}