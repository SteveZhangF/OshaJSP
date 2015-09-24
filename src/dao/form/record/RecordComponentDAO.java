package dao.form.record;

import bean.form.record.component.FormRecordComponent;

public interface RecordComponentDAO {
	public void add(FormRecordComponent fr);
	
	public FormRecordComponent getFormRecordComponentbyID(String id);
	
	public void deletebyRecordID(String recordid);
	
}
