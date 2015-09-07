package model;



public abstract class FormElement{
	private String id;
	private String parentID;
	private String description;
	private String sequenceCode;
	private String name;
	private String type;
	
	public abstract String toHtml();
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSequenceCode() {
		return sequenceCode;
	}
	public void setSequenceCode(String sequenceCode) {
		this.sequenceCode = sequenceCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getParentID() {
		return parentID;
	}

	public void setParentID(String parentID) {
		this.parentID = parentID;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
