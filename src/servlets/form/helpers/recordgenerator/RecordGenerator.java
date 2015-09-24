package servlets.form.helpers.recordgenerator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import bean.form.component.FormComponent;
import bean.form.record.FormRecord;
import bean.form.record.component.FormRecordComponent;
import bean.user.data.Employee;
import bean.user.data.OrganizationElement;
import database.dao.factory.DAOFactoryImpl;
import javassist.tools.framedump;

public class RecordGenerator {
	public RecordGenerator(OrganizationElement oe,String recordid) {
		this.setOE(oe);
		this.setRecordid(recordid);
	}

	private OrganizationElement oe;
	private String recordid;

	private FormRecord fRecord;
	private List<FormRecordComponent> components = new ArrayList<>();

	public void setOE(OrganizationElement oe) {
		this.oe = oe;
	}

	public void addRecordComponent(String formComponent_id, String value) {
		FormComponent fcComponent = DAOFactoryImpl.getFormComponentDAO().findbyID(formComponent_id);
		FormRecordComponent formRecordComponent = new FormRecordComponent();
		formRecordComponent.setfComponent(fcComponent);
		formRecordComponent.setValue(value);

		components.add(formRecordComponent);
	}

	
	public void save() {
		
		if(this.getRecordid()!=null && !this.getRecordid().trim().equals("")){
			fRecord = DAOFactoryImpl.getFormRecordDAO().getRecordbyID(this.getRecordid());
			if(fRecord!=null)
				fRecord.getFrcList().clear();
			else
				fRecord = new FormRecord();
		}else{
			fRecord = new FormRecord();
		}
		fRecord.setOe(oe);
		for (FormRecordComponent frc : components) {
			fRecord.add(frc);
			fRecord.setForm(frc.getfComponent().getForm());
		}
		DAOFactoryImpl.getFormRecordDAO().save(fRecord);
		System.out.println(fRecord.getFrcList().size());
	}

	public String getRecordid() {
		return recordid;
	}

	public void setRecordid(String recordid) {
		this.recordid = recordid;
	}
}
