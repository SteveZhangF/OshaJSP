package model;

import java.util.ArrayList;
import java.util.List;

import engine.htmlengine.TemplatePool;


public class TopicElement extends FormElement{
	
	protected List<FormElement> childElement = new ArrayList<FormElement>();
	
	public void addChild(FormElement child){
		this.childElement.add(child);
//		child.setParentID(this.getId());
	}
	
	@Override
	public String toHtml() {
		// TODO Auto-generated method stub
		String result = TemplatePool.getInstance().getHtmlTemplate("topic:TopicElement");
		result = result.replace("####panel_title###", this.getName());
		StringBuffer sb = new StringBuffer();
		for(FormElement fe : childElement){
			sb.append(fe.toHtml());
		}
		result = result.replace("###topic_item###", sb.toString());
		return result;
	}
	
}
