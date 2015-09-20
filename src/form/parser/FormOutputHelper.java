package form.parser;

import bean.form.Form;
import dao.form.FormDAO;
import database.dao.factory.DAOFactoryImpl;

public class FormOutputHelper {
	public String getFormHtml(String formid) {
		FormDAO fdao = DAOFactoryImpl.getFormDAO();
		Form form = fdao.findFormbyID(formid);
		return form.toHtml();
	}
}
