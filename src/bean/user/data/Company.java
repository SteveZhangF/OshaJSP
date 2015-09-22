package bean.user.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import bean.form.Form.FormType;
import bean.form.module.Module;
import bean.user.User;

@Entity
public class Company extends OrganizationElement {


	public Company() {
		this.setFormType(FormType.CompanyForm);
	}
	
	@OneToMany(mappedBy = "company")
	@LazyCollection(LazyCollectionOption.FALSE) 
	private Set<OrganizationElement> departments = new HashSet<OrganizationElement>();

	@OneToMany(mappedBy="company")
	@LazyCollection(LazyCollectionOption.FALSE)
	private Set<OrganizationElement> employees = new HashSet<OrganizationElement>();
	// 公司当前拥有模块
	 
	@OneToOne
	@JoinColumn(name="user_id")
	private User user; 
	 
	@ManyToMany//　　　--->　ManyToMany指定多对多的关联关系
	@JoinTable(name="tbl_company_module", joinColumns={ @JoinColumn(name="company_id")},    inverseJoinColumns={ @JoinColumn(name = "module_id") })//　--->　　因为多对多之间会通过一张中间表来维护两表直接的关系，所以通过 JoinTable 这个注解来声明，name就是指定了中间表的名字，JoinColumns是一个 @JoinColumn类型的数组，表示的是我这方在对方中的外键名称，我方是Course，所以在对方外键的名称就是 rid，inverseJoinColumns也是一个 @JoinColumn类型的数组，表示的是对方在我这放中的外键名称，对方是Teacher，所以在我方外键的名称就是 tid
	private List<Module> modules = new ArrayList<Module>();

	public void addModule(Module m){
		this.modules.add(m);
		m.addCompany(this);
	}
	
	
	public void addDepartment(Department department) {
		department.setCompany(this);
		this.departments.add(department);
	}


	public Set<OrganizationElement> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<OrganizationElement> departments) {
		this.departments = departments;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}


	@Override
	public String show(OrganizationElement oe) {
		// TODO Auto-generated method stub
		return null;
	}


	public Set<OrganizationElement> getEmployees() {
		return employees;
	}


	public void setEmployees(Set<OrganizationElement> employees) {
		this.employees = employees;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public Company getCompany() {
		return this;
	}

}
