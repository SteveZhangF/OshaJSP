package form.parser;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import database.dao.factory.DAOFactoryImpl;
import form.bean.Form;
import form.bean.FormComponent;
import form.bean.dao.FormComponentDAO;
import form.bean.dao.FormDAO;
import form.bean.dao.impl.FormComponentDAOImpl;
import form.bean.dao.impl.FormDAOImpl;

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
//		SAXBuilder builder = new SAXBuilder();
		System.out.println(formDataXML);
		Form form = new Form(formDataXML);
		form.save();
//		try {
//			Document document = builder.build(new StringReader(formDataXML));
//			Element form_element = document.getRootElement();
//			Form form = new Form();
//			String form_name = form_element.getAttributeValue("name");
//
//			form.setName(form_name);
//			form.setTemplate_xml(formDataXML);
//
//			List<Element> componentList = form_element.getChildren("component");
//			FormDAO fdao = DAOFactoryImpl.getFormDAO();
//			String form_id = fdao.save(form);
//			for (int i = 0; i < componentList.size(); i++) {
//				Element component_element = (Element) componentList.get(i);
//				String component_name = component_element.getAttribute("name").getValue();
//				String component_type = component_element.getAttribute("type").getValue();
//				FormComponent fc = new FormComponent();
//				fc.setComponent_name(component_name);
//				fc.setComponent_type(component_type);
//				fc.setForm_id(form_id);
//				FormComponentDAO fcdao = new FormComponentDAOImpl();
//				fcdao.save(fc);
//			}
//			System.out.println("save form success");
//		} catch (JDOMException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}

}