package dao.form.record.impl;

import bean.dao.BaseDao;
import bean.form.record.component.FormRecordComponent;
import dao.form.record.RecordComponentDAO;

public class FormRecordComponentHBDAOImpl extends BaseDao<FormRecordComponent> implements RecordComponentDAO{

	@Override
	public void add(FormRecordComponent fr) {
		// TODO Auto-generated method stub
		super.saveObject(fr);
	}

	@Override
	public FormRecordComponent getFormRecordComponentbyID(String id) {
		// TODO Auto-generated method stub
		return super.getObject(FormRecordComponent.class, id);
	}

}
