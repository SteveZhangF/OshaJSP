package dao.form.record.impl;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import bean.dao.BaseDao;
import bean.form.record.FormRecord;
import bean.form.record.component.FormRecordComponent;
import dao.form.record.RecordDAO;

public class FormRecordHBDAOImpl extends BaseDao<FormRecord> implements RecordDAO{

	@Override
	public FormRecord getRecordbyID(String id) {
		// TODO Auto-generated method stub
		return super.getObject(FormRecord.class, id);
	}

	@Test
	public void Test(){
		delete("40288091501c75b401501c79f7c10000");
	}

	@Override
	public void save(FormRecord obj) {
		// TODO Auto-generated method stub
		super.saveObject(obj);
	}

	@Override
	public void delete(String id) {
		FormRecord obj = getRecordbyID(id);
		delete(obj);
	}
	
	@Override
	public void delete(FormRecord obj) {
		// TODO Auto-generated method stub
		obj.getForm().getFormRecords().remove(obj);
		obj.getOe().getRecords().remove(obj);
		
		for(FormRecordComponent frc : obj.getFrcList()){
			frc.setfComponent(null);
		}
		
		super.deleteObject(obj);
	}

	@Override
	public List<FormRecord> getRecordsbyOE_ID(String uuid) {
		Session session = getSession();
		List<FormRecord> list = session.createQuery("from FormRecord where organization_id='"+uuid+"'").list();
		return list;
	}

}
