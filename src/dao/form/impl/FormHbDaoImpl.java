package dao.form.impl;

import java.util.List;

import org.junit.Test;

import bean.dao.BaseDao;
import bean.form.Form;
import dao.form.FormDAO;
import database.dao.factory.DAOFactoryImpl;

public class FormHbDaoImpl extends BaseDao<Form> implements FormDAO {

	@Override
	public void save(Form f) {
		super.saveObject(f);
	}
	@Test
	public void test(){
		delete("40288091501b945201501b94552a0000");
	}
	
	@Override
	public void delete(Form f) {
		while(f.getFormRecords().size()!=0){
			DAOFactoryImpl.getFormRecordDAO().delete(f.getFormRecords().get(0));
		}
		
		while(f.getChildren().size()!=0){
			DAOFactoryImpl.getFormComponentDAO().delete(f.getChildren().get(0));
		}
		
		f.getModule().getForms().remove(f);
		f.setModule(null);
		
		super.deleteObject(f);
	}


	@Override
	public Form findFormbyID(String formid) {
		// TODO Auto-generated method stub
		Form form = super.getObject(Form.class, formid);
		return form;
	}

	@Override
	public List<Form> findAll() {
		// TODO Auto-generated method stub
		return super.getAll(Form.class);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		Form f = findFormbyID(id);
		delete(f);
	}

}
