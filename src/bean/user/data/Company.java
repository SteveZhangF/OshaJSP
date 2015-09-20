package bean.user.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import bean.form.module.Module;

@Entity
@Table(name = "company")
public class Company extends OrganizationElement {

	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String uuid;
	private String company_address;
	private String company_phone;
	private String company_name;

	@OneToMany(mappedBy = "company") // --->
										// OneToMany指定了一对多的关系，mappedBy="room"指定了由多的那一方来维护关联关系，mappedBy指的是多的一方对1的这一方的依赖的属性，(注意：如果没有指定由谁来维护关联关系，则系统会给我们创建一张中间表)
	@LazyCollection(LazyCollectionOption.EXTRA) // --->
												// LazyCollection属性设置成EXTRA指定了当如果查询数据的个数时候，只会发出一条
												// count(*)的语句，提高性能
	private Set<Department> departments = new HashSet<Department>();

	@OneToMany(mappedBy="company")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private Set<Employee> employees = new HashSet<Employee>();
	// 公司当前拥有模块
	 
	 
	 
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

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getCompany_address() {
		return company_address;
	}

	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}

	public String getCompany_phone() {
		return company_phone;
	}

	public void setCompany_phone(String company_phone) {
		this.company_phone = company_phone;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
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


	public Set<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

}
