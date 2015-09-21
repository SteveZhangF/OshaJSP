package dao.form.record.impl;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import bean.dao.BaseDao;
import bean.form.record.FormRecord;
import dao.form.record.RecordDAO;

public class FormRecordHBDAOImpl extends BaseDao<FormRecord> implements RecordDAO{

	@Override
	public FormRecord getRecordbyID(String id) {
		// TODO Auto-generated method stub
		return super.getObject(FormRecord.class, id);
	}

	@Test
	public void Test(){
		String employee_id = "402880914fe96e2f014fe96fb4190002";
//		Employee employee=  DAOFactoryImpl.getEmployeeDAO().getEmployeebyID("402880914fe96e2f014fe96fb4190002");
//		employee.getRecords();
		FormRecordHBDAOImpl dr = new FormRecordHBDAOImpl();
		List<FormRecord> list = dr.getRecordsbyOE_ID(employee_id);
		System.out.println(list.size());
		System.out.println(list.get(0).getClass().getName());
		System.out.println(list.get(2).getForm().toHtml());
		//		FormRecord fr = new BaseDao<FormRecord>(){}.getObject(FormRecord.class, "402880914fea0e92014fea0e955b0000");
//		EmployeeRecord er = (EmployeeRecord)fr;
//		System.out.println(er.getEmployee().getEmail());
//		for(FormRecordComponent frcwww: fr.getFrcList()){
//			System.out.println(frcwww.getValue());
//			System.out.println(frcwww.getfComponent().getComponent_name());
//		}
	}

	@Override
	public void save(FormRecord obj) {
		// TODO Auto-generated method stub
		super.saveObject(obj);
	}

	@Override
	public void delete(FormRecord obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FormRecord> getRecordsbyOE_ID(String uuid) {
		Session session = getSession();
		List<FormRecord> list = session.createQuery("from FormRecord where organization_id='"+uuid+"'").list();
		return list;
	}

}
