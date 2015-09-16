package form.parser;

import database.dao.factory.DAOFactoryImpl;
import form.bean.Form;
import form.bean.dao.FormDAO;

public class FormOutputHelper {
	public String getFormHtml(String formid){
		FormDAO fdao = DAOFactoryImpl.getFormDAO();
		Form form = fdao.findFormbyID(formid);
		String xml = form.getTemplate_xml();
		
		
		
		
		return "";
	}
}
