package form.bean.dao;

import java.util.List;

import form.bean.FormComponent;

public interface FormComponentDAO {
	public String save(FormComponent fc);
	public void delete(FormComponent fc);
	public void update(FormComponent fc);
	public FormComponent findbyID(String uuid);
	public FormComponent findbyName(String name);
	public List<FormComponent> findbyFormID(String form_id);
}
