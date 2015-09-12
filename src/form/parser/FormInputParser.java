package form.parser;

import java.io.IOException;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

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
public class FormInputParser {
	public void parserXml(String fileName) {
		SAXBuilder builder = new SAXBuilder();

		try {
			Document document = builder.build(fileName);
			Element users = document.getRootElement();
			List<Element> componentList = users.getChildren("component");

			for (int i = 0; i < componentList.size(); i++) {
				Element component = (Element) componentList.get(i);
				String component_name = component.getAttribute("name").getValue();
				int component_id = component.getAttribute("id").getIntValue();
				
				
			}
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}