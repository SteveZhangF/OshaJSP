package form.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import engine.htmlengine.TemplatePool;

@Entity
@Table(name = "tbl_form")
public class Form {

	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String uuid;
	private String name;
	private String template_xml;
	private int industry_id;// 属于哪个行业（占位）

	@OneToMany(mappedBy = "form",cascade=CascadeType.ALL) // --->
	// OneToMany指定了一对多的关系，mappedBy="room"指定了由多的那一方来维护关联关系，mappedBy指的是多的一方对1的这一方的依赖的属性，(注意：如果没有指定由谁来维护关联关系，则系统会给我们创建一张中间表)
	@LazyCollection(LazyCollectionOption.EXTRA) // --->
	// LazyCollection属性设置成EXTRA指定了当如果查询数据的个数时候，只会发出一条
	// count(*)的语句，提高性能
	private List<FormComponent> children = new ArrayList<>();

	public Form() {
	}

	public Form(String formDataXML) {


	}
	
	public void add(FormComponent fc){
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

	public String getTemplate_xml() {
		return template_xml;
	}

	public void setTemplate_xml(String template_xml) {
		this.template_xml = template_xml;
	}

	public int getIndustry_id() {
		return industry_id;
	}

	public void setIndustry_id(int industry_id) {
		this.industry_id = industry_id;
	}

}
