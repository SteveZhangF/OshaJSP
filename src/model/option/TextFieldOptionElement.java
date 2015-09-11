package model.option;

import engine.htmlengine.TemplatePool;
import model.OptionElement;

public class TextFieldOptionElement extends OptionElement {

	/**
	 * <label> <input type="radio" name="#topic_id" value="#item_id"> #content
	 * </label>
	 */
	public String toHtml() {
		String result = TemplatePool.getInstance().getHtmlTemplate("option:TextFieldOptionElement");
		result = result.replace("####topic_id###", this.getParentID());
		result = result.replace("####item_id###", this.getId());
		result = result.replace("####text_name###", this.getName());
		result = result.replace("####description###", this.getDescription());
		return result;
	}
}
