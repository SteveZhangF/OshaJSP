package form.bean.dao;

import java.util.List;

import form.bean.Form;

public interface FormDAO {
	public String save(Form f);

	public void delete(Form f);

	public void update(Form f);

	public List<Form> findAll();

	public List<Form> findbyIndustry(int industry_id);
}
