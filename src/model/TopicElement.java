package model;

import java.util.ArrayList;
import java.util.List;


public class TopicElement extends FormElement{
	
	protected List<FormElement> childElement = new ArrayList<FormElement>();
	
	public void addChild(FormElement child){
		this.childElement.add(child);
//		child.setParentID(this.getId());
	}
	
	@Override
	public String toHtml() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
