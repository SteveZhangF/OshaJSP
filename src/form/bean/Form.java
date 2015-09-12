package form.bean;


public class Form {
	private int uuid;
	private String name;
	private String template_xml;
	private int industry_id;//属于哪个行业（占位）
	
	public int getUuid() {
		return uuid;
	}
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTemplate_xml() {
		return template_xml;
	}
	public void setTemplate_xml(String template_xml) {
		this.template_xml = template_xml;
	}
	public int getIndustry_id() {
		return industry_id;
	}
	public void setIndustry_id(int industry_id) {
		this.industry_id = industry_id;
	}
	
}
