package bean.user.data;

import java.util.List;

import bean.form.module.Module;
import bean.form.record.FormRecord;

public class FormRecordShower<T extends OrganizationElement> {

	
	
	private OrganizationElement oe;
	
	public FormRecordShower(T oe){
		this.oe = oe;
	}
	
	public List<FormRecord> getFilledReord(){
		return this.oe.getRecords();
	}
	
	public List<Module> getAllModule(){
		Company c = oe.getCompany();
		return c.getModules();
		
	}
}
