package bean.form;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import bean.user.data.Company;

/**
 * 属于公司填写的表单
 * */
@Entity    
@DiscriminatorValue("CompanyForm")    
public class CompanyForm extends Form {
	public CompanyForm(){
		this.setForm_type(FormType.CompanyForm);
	}
}
