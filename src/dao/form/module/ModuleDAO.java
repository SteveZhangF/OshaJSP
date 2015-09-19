package dao.form.module;

import java.util.List;

import bean.form.module.Module;

public interface ModuleDAO  {
	
	public void save(Module module);
	public void delete(Module module);
	public void delete(String id);
	public List<Module> list();
	
	public Module getModuleById(String id);
}
