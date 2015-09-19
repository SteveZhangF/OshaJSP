package dao.form;

import java.util.List;

import bean.form.Form;

public interface FormDAO {
	public void save(Form f);

	public void delete(Form f);
	
	public Form findFormbyID(String formid);

	public List<Form> findAll();

}
