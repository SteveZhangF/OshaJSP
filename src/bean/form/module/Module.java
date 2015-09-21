package bean.form.module;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import bean.form.Form;
import bean.user.data.Company;

@Entity
@Table(name = "tbl_Module")
public class Module implements Serializable,Cloneable{
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String id;
	private String name;

	@OneToMany(mappedBy = "module", cascade = CascadeType.ALL) // --->
	@LazyCollection(LazyCollectionOption.EXTRA) // --->
	private List<Form> forms = new ArrayList<Form>();

	// 子模块
	@OneToMany(mappedBy="superModule")
	@LazyCollection(LazyCollectionOption.EXTRA)
	private List<Module> subModules = new ArrayList<Module>();
	// 父模块
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_module_id")
	private Module superModule;

	// 该模块属于哪个公司 由company来维护关系 
	@ManyToMany(mappedBy="modules")
	private List<Company> companies = new ArrayList<Company>();

	public void addCompany(Company c){
		this.companies.add(c);
	}
	
	public void addForm(Form form) {
		this.forms.add(form);
		form.setModule(this);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Form> getForms() {
		return forms;
	}

	public void setForms(List<Form> forms) {
		this.forms = forms;
	}

	public List<Module> getSubModules() {
		return subModules;
	}

	public void setSubModules(List<Module> subModules) {
		this.subModules = subModules;
	}

	public Module getSuperModule() {
		return superModule;
	}

	public void setSuperModule(Module superModule) {
		this.superModule = superModule;
	}

	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}
}
