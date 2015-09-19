package dao.form.impl;

import java.util.List;

import bean.dao.BaseDao;
import bean.form.Form;
import dao.form.FormDAO;

public class FormHbDaoImpl extends BaseDao<Form> implements FormDAO {

	@Override
	public void save(Form f) {
		super.saveObject(f);
	}

	@Override
	public void delete(Form f) {
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

}
