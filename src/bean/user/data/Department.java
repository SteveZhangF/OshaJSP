package bean.user.data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Department  extends OrganizationElement{



	@OneToMany(mappedBy = "department") // --->
	@LazyCollection(LazyCollectionOption.EXTRA) // --->
	private Set<Employee> employees = new HashSet<Employee>();

	@OneToMany(mappedBy = "parentDepartment") // --->
	@Cascade({ CascadeType.ALL})
	@LazyCollection(LazyCollectionOption.EXTRA) // --->
	private Set<Department> subDepartment = new HashSet<Department>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	private Department parentDepartment;

	public void addSubDepartment(Department child) {
		this.subDepartment.add(child);
		child.setParentDepartment(this);
		child.setCompany(this.getCompany());
	}

	public void addEmployee(Employee e) {
		e.setDepartment(this);
		e.setCompany(this.getCompany());
		this.employees.add(e);
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

	@Override
	public String show(OrganizationElement oe) {
		return "";
	}
	
	
}
