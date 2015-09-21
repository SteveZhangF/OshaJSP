package bean.form.record;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import bean.user.data.Employee;
@Entity    
@DiscriminatorValue("employeeFormRecord") 
public class EmployeeRecord extends FormRecord {
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	public EmployeeRecord(){
		super.setFormreocrd_type(FormRecordType.EmployeeRecord);
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
		employee.addRecord(this);
	}

}
