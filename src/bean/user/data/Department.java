package bean.user.data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import bean.dao.BaseDao;

@Entity
@Table(name = "department")
public class Department  extends OrganizationElement{

	public static void main(String[] ad) {
		Department d = new Department();
		d.setDepartment_name("parent");
		Department c = new Department();
		c.setDepartment_name("child");
		d.addSubDepartment(c);
		
//		new BaseDao<Department>() {
//		}.saveObject(d);
		
		
		Department ddddd = new BaseDao<Department>() {
		}.getObject(Department.class, "402880914fdfe10b014fdfe10d2c0000");
		ddddd.getSubDepartment().clear();
		for(Department sub:ddddd.getSubDepartment()){
			sub.setParentDepartment(null);
		}
		new BaseDao<Department>() {
		}.deleteObject(ddddd);
	}

	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String uuid;
	private String department_name;
	private int employee_count;
	private String department_telephone;
	private int children_count;
	private String department_address;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	private Company company;

	@OneToMany(mappedBy = "department") // --->
	@LazyCollection(LazyCollectionOption.EXTRA) // --->
	private Set<Employee> employees = new HashSet<Employee>();

	@OneToMany(mappedBy = "parentDepartment") // --->
	@Cascade({ CascadeType.SAVE_UPDATE})
	@LazyCollection(LazyCollectionOption.EXTRA) // --->
	private Set<Department> subDepartment = new HashSet<Department>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private Department parentDepartment;

	public void addSubDepartment(Department child) {
		this.subDepartment.add(child);
		child.setParentDepartment(this);
	}

	public void addEmployee(Employee e) {
		e.setDepartment(this);
		this.employees.add(e);
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public int getEmployee_count() {
		return employee_count;
	}

	public void setEmployee_count(int employee_count) {
		this.employee_count = employee_count;
	}

	public String getDepartment_telephone() {
		return department_telephone;
	}

	public void setDepartment_telephone(String department_telephone) {
		this.department_telephone = department_telephone;
	}

	public int getChildren_count() {
		return children_count;
	}

	public void setChildren_count(int children_count) {
		this.children_count = children_count;
	}

	public String getDepartment_address() {
		return department_address;
	}

	public void setDepartment_address(String department_address) {
		this.department_address = department_address;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Set<Department> getSubDepartment() {
		return subDepartment;
	}

	public void setSubDepartment(Set<Department> subDepartment) {
		this.subDepartment = subDepartment;
	}

	public Department getParentDepartment() {
		return parentDepartment;
	}

	public void setParentDepartment(Department parentDepartment) {
		this.parentDepartment = parentDepartment;
	}
}
