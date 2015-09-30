package dao.form.module.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import bean.dao.BaseDao;
import bean.form.Form;
import bean.form.module.Module;
import bean.user.data.Company;
import dao.form.module.ModuleDAO;
import database.dao.factory.DAOFactoryImpl;
import test.test;

public class ModuleHBDAOImpl extends BaseDao<Module>implements ModuleDAO {

	@Override
	public void save(Module module) {
		super.saveObject(module);
	}

	@Test
	public void test(){
		delete("402880915007009b0150070e2f810000");
	}
	
	@Override
	public void delete(Module module) {

		for(Form form:module.getForms()){
			form.setModule(module.getSuperModule());
			DAOFactoryImpl.getFormDAO().save(form);
		}
		
		for(Module subM : module.getSubModules()){
			subM.setSuperModule(module.getSuperModule());
			save(subM);
		}
		
		for(Company company : module.getCompanies()){
			company.getModules().remove(module);
			DAOFactoryImpl.getCompanyDAO().save(company);
		}
		
		module.getCompanies().clear();
		module.getSubModules().clear();
		module.getForms().clear();
		save(module);
		
		super.deleteObject(module);
	}

	@Override
	public void delete(String id) {
		delete(getModuleById(id));
	}

	@Override
	public List<Module> list() {
		return super.getAll(Module.class);
	}
	@Override
	public Module getModuleById(String id) {
		Session session = getSession();
		session.clear();
		Module obj = (Module) session.get(Module.class, id);
		session.close();
		return obj;
	}

}
