package form.parser;

import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

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
		Form form = new Form(formDataXML);
		form.save();
	}

}