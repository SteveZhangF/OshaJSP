package dao.form.record.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import bean.dao.BaseDao;
import bean.form.record.component.FormRecordComponent;
import dao.form.record.RecordComponentDAO;
import database.HibernateUtil;

public class FormRecordComponentHBDAOImpl extends BaseDao<FormRecordComponent> implements RecordComponentDAO{

	@Override
	public void add(FormRecordComponent fr) {
		// TODO Auto-generated method stub
		super.saveObject(fr);
	}

	@Override
	public FormRecordComponent getFormRecordComponentbyID(String id) {
		return super.getObject(FormRecordComponent.class, id);
	}
	@Override
	public void deletebyRecordID(String recordid){
//		Session session = getSession();
//		Transaction tx = beginTransaction(session);
//		try {
//			session.
//			tx.commit();
//		} catch (Exception e) {
//			tx.rollback();
//			e.printStackTrace();
////			log.error("保存对象失败");
//		} finally {
//			HibernateUtil.closeSession(session);
//		}
		
	}

}
