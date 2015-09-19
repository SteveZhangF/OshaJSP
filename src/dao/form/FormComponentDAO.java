package dao.form;

import java.util.List;

import bean.form.component.FormComponent;

public interface FormComponentDAO {
	public void save(FormComponent fc);
	public void delete(FormComponent fc);
	public FormComponent findbyID(String uuid);
}
