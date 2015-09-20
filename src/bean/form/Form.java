package bean.form;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import bean.form.component.FormComponent;
import bean.form.module.Module;
import bean.form.record.FormRecord;
import engine.htmlengine.TemplatePool;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "FormType", discriminatorType = DiscriminatorType.STRING, length = 30)
@DiscriminatorValue("Form")
@Table(name = "tbl_form")
public class Form {

	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String uuid;
	private String name;

	@OneToMany(mappedBy = "form", cascade = CascadeType.ALL) // --->
	@LazyCollection(LazyCollectionOption.EXTRA) // --->
	private List<FormComponent> children = new ArrayList<>();
	@Column(name="Form_TYPE")
	private String form_type;
	
	// belong to which module
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "module_id")
	
	private Module module;
	
	@OneToMany(mappedBy="form", cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.EXTRA) // 
	private List<FormRecord> formRecords = new ArrayList<>();

	public void addRecord(FormRecord fr) {
		this.formRecords.add(fr);
	}

	public Form() {
	}

	public Form(String formDataXML) {

	}

	public void add(FormComponent fc) {
		this.children.add(fc);
		fc.setForm(this);
	}

	public String toHtml() {
		String result = TemplatePool.getInstance().getHtmlTemplate("Form:Form_VIEW");

		result = result.replace("###Form_Name###", this.getName());
		result = result.replace("###Form_ID###", this.getUuid());
		StringBuffer sb = new StringBuffer();
		for (FormComponent fe : children) {
			sb.append(fe.toHtml());
		}
		result = result.replace("###Form_Components###", sb.toString());
		return result;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public List<FormRecord> getFormRecords() {
		return formRecords;
	}

	public void setFormRecords(List<FormRecord> formRecords) {
		this.formRecords = formRecords;
	}

	public String getForm_type() {
		return form_type;
	}

	public void setForm_type(String form_type) {
		this.form_type = form_type;
	}

	public List<FormComponent> getChildren() {
		return children;
	}

	public void setChildren(List<FormComponent> children) {
		this.children = children;
	}

}
