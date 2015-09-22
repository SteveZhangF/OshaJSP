package bean.user.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import bean.form.Form.FormType;
import bean.form.record.FormRecord;
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS) 
@Table(name="organizationelement")
public abstract class OrganizationElement {
	
	@OneToMany(mappedBy="oe")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<FormRecord> records = new ArrayList<FormRecord>();
	
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String uuid;
	private String address;
	private String phone;
	private String name;
	private FormType formType;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	protected Company company;
	
	
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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public FormType getFormType() {
		return formType;
	}



	public void setFormType(FormType formType) {
		this.formType = formType;
	}
}
