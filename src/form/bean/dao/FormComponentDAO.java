package form.bean.dao;

import java.util.List;

import form.bean.FormComponent;

public interface FormComponentDAO {
	public int save(FormComponent fc);
	public void delete(FormComponent fc);
	public void update(FormComponent fc);
	public FormComponent findbyID(int id);
	public List<FormComponent> findbyFormID(int form_id);
}
