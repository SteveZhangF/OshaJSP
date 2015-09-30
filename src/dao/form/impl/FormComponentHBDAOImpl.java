package dao.form.impl;

import bean.dao.BaseDao;
import bean.form.component.FormComponent;
import dao.form.FormComponentDAO;

public class FormComponentHBDAOImpl extends BaseDao<FormComponent> implements FormComponentDAO {

	@Override
	public void save(FormComponent fc) {
		// TODO Auto-generated method stub
		super.saveObject(fc);
	}

	@Override
	public void delete(FormComponent fc) {
		// TODO Auto-generated method stub
		fc.getForm().getChildren().remove(fc);
		super.deleteObject(fc);
	}


	@Override
	public FormComponent findbyID(String uuid) {
		FormComponent fc = super.getObject(FormComponent.class, uuid);
		return fc;
	}

}
