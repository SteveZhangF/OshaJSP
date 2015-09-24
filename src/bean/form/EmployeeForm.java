package bean.form;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.hibernate.hql.internal.ast.tree.LiteralNode;

import bean.form.Form.FormType;
import bean.form.record.FormRecord;
import bean.user.data.OrganizationElement;
import database.dao.factory.DAOFactoryImpl;
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
