package form.bean;

public class FormComponent {
	private int uuid;
	private int form_id;
	private String component_name;
	private int component_type;
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	public int getForm_id() {
		return form_id;
	}
	public void setForm_id(int form_id) {
		this.form_id = form_id;
	}
	public String getComponent_name() {
		return component_name;
	}
	public void setComponent_name(String component_name) {
		this.component_name = component_name;
	}
	public int getComponent_type() {
		return component_type;
	}
	public void setComponent_type(int component_type) {
		this.component_type = component_type;
	}
}
