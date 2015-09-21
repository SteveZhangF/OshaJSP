package bean.user.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import bean.form.record.FormRecord;
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) 
@Table(name="organizationelement")
public abstract class OrganizationElement {
	
	private List<FormRecord> records = new ArrayList<>();

	private Company company;
	
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

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}
}
