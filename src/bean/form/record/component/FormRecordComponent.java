package bean.form.record.component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import bean.form.component.FormComponent;
import bean.form.record.FormRecord;

@Entity
@Table(name="tbl_form_record_component")
public class FormRecordComponent {
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy = "uuid")
	@Column(name = "id", nullable = false)
	private String id;
	@OneToOne(fetch = FetchType.LAZY)
	private FormComponent fComponent;
	private String value;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "form_record_id")
	private FormRecord formrecord;
	
	
	
	public FormComponent getfComponent() {
		return fComponent;
	}
	public void setfComponent(FormComponent fComponent) {
		this.fComponent = fComponent;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public FormRecord getFr() {
		return formrecord;
	}
	public void setFr(FormRecord fr) {
		this.formrecord = fr;
	}
	
}
