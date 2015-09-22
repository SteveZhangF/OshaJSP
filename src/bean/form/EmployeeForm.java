package bean.form;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import bean.form.Form.FormType;
/**
 * 属于员工填写的表单
 * */
@Entity    
@DiscriminatorValue("EmployeeForm")    
public class EmployeeForm  extends Form{
	public EmployeeForm(){
		this.setForm_type(FormType.EmployeeForm);
	}
}
