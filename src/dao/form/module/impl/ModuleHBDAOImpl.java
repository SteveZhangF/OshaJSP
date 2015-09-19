package dao.form.module.impl;

import java.util.List;

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
		Module module = super.getObject(Module.class, id);
		return module;
	}

}
