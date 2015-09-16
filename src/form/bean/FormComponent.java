package form.bean;

import database.dao.factory.DAOFactoryImpl;
import form.bean.dao.FormComponentDAO;
import form.bean.dao.FormDAO;

public class FormComponent {
	private String uuid;
	private String form_id;
	private String component_name;
	private String component_type;
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getForm_id() {
		return form_id;
	}
	public void setForm_id(String form_id) {
		this.form_id = form_id;
	}
	public String getComponent_name() {
		return component_name;
	}
	public void setComponent_name(String component_name) {
		this.component_name = component_name;
	}
	public String getComponent_type() {
		return component_type;
	}
	public void setComponent_type(String component_type) {
		this.component_type = component_type;
	}
	
	public void save(){
		FormComponentDAO dao = DAOFactoryImpl.getFormComponentDAO();
		//new component
		if (uuid == null || uuid.trim().equals("") || dao.findbyID(uuid) == null) {
			uuid=dao.save(this);
		} else {
			// update old form
			dao.update(this);
		}
	}
}
