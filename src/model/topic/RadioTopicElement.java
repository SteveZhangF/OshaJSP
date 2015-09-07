package model.topic;

import engine.htmlengine.TemplatePool;
import model.FormElement;
import model.TopicElement;

public class RadioTopicElement extends TopicElement {

	/**
	 * <div class="panel panel-default"> <div class="panel-heading"> <h3 class="panel-title">
	 * ####panel_title###</h3> </div> <div class="panel-body"> <div
	 * class="radio">#radio_items</div> </div> </div>
	 * 
	 * */

	@Override
	public String toHtml() {
		String result = TemplatePool.getInstance().getHtmlTemplate("RadioTopicElement");
		result = result.replace("####panel_title###", this.getName());
		StringBuffer sb = new StringBuffer();
		for(FormElement fe : childElement){
			sb.append(fe.toHtml());
		}
		result = result.replace("###radio_item###", sb.toString());
		return result;
	}
}
