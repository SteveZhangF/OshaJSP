package servlets.form.helpers.formsgenerator;

import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import bean.form.Form;
import bean.form.Form.FormType;
import bean.form.module.Module;
import bean.form.record.FormRecord;
import bean.form.record.component.FormRecordComponent;
import bean.user.data.Company;
import bean.user.data.OrganizationElement;
import database.dao.factory.DAOFactoryImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class FormGenerator {
	private static ObjectMapper mapper = new ObjectMapper();

	@Test
	public void test() {
		System.out.println(FormGenerator.getModule("40288091500d383b01500d432dee0000"));
	}

	/**
	 * 查找form 和 与之对应的 oe(employee company department)填写的record 组成json
	 */
	public static String getOEForm(String form_id, String oe_id) {
		Form form = DAOFactoryImpl.getFormDAO().findFormbyID(form_id);

		OrganizationElement oe = DAOFactoryImpl.getOrganizationElementDAO().getOEbyID(oe_id);
		JSONObject jsoForm = new JSONObject();
		JSONArray jsoRecords = new JSONArray();

		List<FormRecord> records = oe.getRecords();
		for (FormRecord fr : records) {
			// if equal means the user has filled this form
			if (fr.getForm()!=null && fr.getForm().getUuid().equals(form_id)) {

				try {
					jsoRecords.add(mapper.writeValueAsString(fr));
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		jsoForm.put("form", form.toHtml());
		jsoForm.put("records", jsoRecords);
		jsoForm.put("report", form.toReport());

		return jsoForm.toString();
	}

	/**
	 * return the modules and it's forms in JSON format based on oe_id
	 */
	public static String getModule(String oe_id) {
		OrganizationElement oe = DAOFactoryImpl.getOrganizationElementDAO().getOEbyID(oe_id);
		if (oe == null)
			return "";
		Company company = oe.getCompany();

		JSONArray moJSON = new JSONArray();

		try {
			for (Module module : company.getModules()) {
				JSONArray jsonArray = new JSONArray();
				for (Form form : module.getFormbyType(oe.getFormType())) {
						String jso = mapper.writeValueAsString(form);
						jsonArray.add(jso);
				}
				// this module has the employee forms
				if (jsonArray.size() != 0) {
					JSONObject jsonModule = JSONObject.fromObject(mapper.writeValueAsString(module));
					jsonModule.put("forms", jsonArray);
					moJSON.add(jsonModule);
				}
			}
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moJSON.toString();
	}
}
