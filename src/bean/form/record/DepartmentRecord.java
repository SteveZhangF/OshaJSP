package bean.form.record;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import bean.user.data.Department;
@Entity    
@DiscriminatorValue("DepartmentFormRecord") 
public class DepartmentRecord extends FormRecord {
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "department_id")
	private Department department;

	public DepartmentRecord(){
		super.setFormreocrd_type(FormRecordType.DepartmentRecord);
	}
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
		department.addRecord(this);
	}
}
