package bean.form.record;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
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

import bean.form.Form;
import bean.form.record.component.FormRecordComponent;
import bean.user.data.OrganizationElement;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "FormRecordType", discriminatorType = DiscriminatorType.STRING, length = 30)
@DiscriminatorValue("FormRecord")
@Table(name = "tbl_FormRecord")
public class FormRecord {
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String id;
	
//	private OrganizationElement oe;
	@ManyToOne
	@JoinColumn(name = "form_id")
	private Form form;
	
	@OneToMany(mappedBy = "formrecord", cascade = CascadeType.ALL) // --->
	@LazyCollection(LazyCollectionOption.EXTRA) // --->
	private List<FormRecordComponent> frcList = new ArrayList<>();

	/**
	 * 向一个表单纪录中添加一个控件纪录
	 * */
	public void add(FormRecordComponent frc){
		this.frcList.add(frc);
		frc.setFr(this);
	}
	
//	public OrganizationElement getOe() {
//		return oe;
//	}
//
//	public void setOe(OrganizationElement oe) {
//		this.oe = oe;
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
		form.addRecord(this);
	}

	public List<FormRecordComponent> getFrcList() {
		return frcList;
	}

	public void setFrcList(List<FormRecordComponent> frc) {
		this.frcList = frc;
	}
}
