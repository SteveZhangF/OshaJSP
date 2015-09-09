package model.option;

import engine.htmlengine.TemplatePool;
import model.OptionElement;

public class RadioOptionElement extends OptionElement {

	/**
	 * <label> <input type="radio" name="#topic_id" value="#item_id">
	 * #content</label>
	 * */
	public String toHtml() {
		String result = TemplatePool.getInstance().getHtmlTemplate("option:RadioOptionElement");
		result = result.replace("####topic_id###", this.getParentID());
		result = result.replace("####item_id###", this.getId());
		result = result.replace("####radio_content###", this.getName());
		return result;
	}
}
