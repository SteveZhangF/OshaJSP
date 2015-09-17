package form.parser;

import database.dao.factory.DAOFactoryImpl;
import form.bean.Form;
import form.bean.dao.FormDAO;

public class FormOutputHelper {
	public String getFormHtml(String formid) {
		FormDAO fdao = DAOFactoryImpl.getFormDAO();
		Form form = fdao.findFormbyID(formid);
		String xml = form.getTemplate_xml();
		System.out.println(form.getTemplate_xml());
		form = new Form(xml);
		System.out.println(form.getName()+form.getUuid()+form.getTemplate_xml());
		return form.toHtml();
	}
}
