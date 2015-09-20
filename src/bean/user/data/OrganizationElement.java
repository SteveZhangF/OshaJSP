package bean.user.data;

import java.util.ArrayList;
import java.util.List;

import bean.form.record.FormRecord;

public abstract class OrganizationElement {
	
	private List<FormRecord> records = new ArrayList<>();

	public void addRecord(FormRecord fr){
		this.records.add(fr);
	}
	
	public List<FormRecord> getRecords() {
		
		return records;
	}

	public void setRecords(List<FormRecord> records) {
		this.records = records;
	}
	
	public abstract String show(OrganizationElement oe);
}
