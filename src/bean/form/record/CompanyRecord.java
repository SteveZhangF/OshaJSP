package bean.form.record;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import bean.user.data.Company;

@Entity    
@DiscriminatorValue("CompanyFormRecord") 
public class CompanyRecord extends FormRecord{
	
	
	public CompanyRecord() {
		super.setFormreocrd_type(FormRecordType.CompanyRecord);
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	private Company company;
	

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
		company.addRecord(this);
	}
	
}
