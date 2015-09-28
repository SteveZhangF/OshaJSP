package dao.form.module.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import bean.dao.BaseDao;
import bean.form.module.Module;
import dao.form.module.ModuleDAO;

public class ModuleHBDAOImpl extends BaseDao<Module>implements ModuleDAO {

	@Override
	public void save(Module module) {
		super.saveObject(module);
	}

	@Override
	public void delete(Module module) {
		super.deleteObject(module);
	}

	@Override
	public void delete(String id) {
		super.deleteObject(getModuleById(id));
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
