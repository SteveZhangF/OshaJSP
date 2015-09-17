package form.bean;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import database.dao.factory.DAOFactoryImpl;
import engine.htmlengine.TemplatePool;
import form.bean.dao.FormDAO;

public class Form {
	private String uuid;
	private String name;
	private String template_xml;
	private int industry_id;// 属于哪个行业（占位）

	private List<FormComponent> children = new ArrayList<>();

	public Form() {
	}

	public Form(String formDataXML) {
		
		org.jsoup.nodes.Document doc = Jsoup.parse(formDataXML);
		org.jsoup.nodes.Element form_element = doc.select("form").first();// find
																			// form
		String form_name = form_element.attr("name");
		String form_id = form_element.attr("id");
		
		this.setUuid(form_id);
		this.setName(form_name);
		this.setTemplate_xml(formDataXML);

		List<org.jsoup.nodes.Element> componentList = form_element.select("component");
		
		for (int i = 0; i < componentList.size(); i++) {
			Element component_element = (Element) componentList.get(i);
			String component_name = component_element.attr("name");
			String component_type = component_element.attr("type");
			String component_id = component_element.attr("id");
			FormComponent fc = new FormComponent();
			fc.setComponent_name(component_name);
			fc.setComponent_type(component_type);
			fc.setForm_id(form_id);
			fc.setUuid(component_id);
			fc.setComponent_content(component_element.html());
			children.add(fc);
		}

//		SAXBuilder builder = new SAXBuilder();
//		try {
//			Document document = builder.build(new StringReader(formDataXML));
//			Element form_element = document.getRootElement();
//			String form_name = form_element.getAttributeValue("name");
//			String form_id = form_element.getAttributeValue("id");
//
//			this.setUuid(form_id);
//			this.setName(form_name);
//			this.setTemplate_xml(formDataXML);
//
//			List<Element> componentList = form_element.getChildren("component");
//
//			for (int i = 0; i < componentList.size(); i++) {
//				Element component_element = (Element) componentList.get(i);
//				String component_name = component_element.getAttribute("name").getValue();
//				String component_type = component_element.getAttribute("type").getValue();
//				String component_id = component_element.getAttributeValue("id");
//
//				XMLOutputter out = new XMLOutputter();
//				String component_content = out.outputString(component_element.getChildren());
//
//				FormComponent fc = new FormComponent();
//				fc.setComponent_name(component_name);
//				fc.setComponent_type(component_type);
//				fc.setForm_id(form_id);
//				fc.setUuid(component_id);
//				fc.setComponent_content(component_content);
//
//				children.add(fc);
//			}
//		} catch (JDOMException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

	}

	public String toHtml() {
		String result = TemplatePool.getInstance().getHtmlTemplate("Form:Form_VIEW");

		result = result.replace("###Form_Name###", this.getName());
		result = result.replace("###Form_ID###", this.getUuid());
		StringBuffer sb = new StringBuffer();
		for (FormComponent fe : children) {
			sb.append(fe.toHtml());
		}
		result = result.replace("###Form_Components###", sb.toString());
		return result;
	}

	public void save() {
		FormDAO dao = DAOFactoryImpl.getFormDAO();
		// new form
		if (uuid == null || uuid.trim().equals("") || dao.findFormbyID(uuid) == null) {
			dao.save(this);
		} else {
			// update old form
			dao.update(this);
		}
		// save children
		for (FormComponent fc : children) {
			fc.setForm_id(uuid);
			fc.save();
		}
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTemplate_xml() {
		return template_xml;
	}

	public void setTemplate_xml(String template_xml) {
		this.template_xml = template_xml;
	}

	public int getIndustry_id() {
		return industry_id;
	}

	public void setIndustry_id(int industry_id) {
		this.industry_id = industry_id;
	}

}
