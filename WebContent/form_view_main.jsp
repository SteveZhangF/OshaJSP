<%@page import="java.util.List"%>
<%@page import="bean.form.record.FormRecord"%>
<%@page import="bean.form.Form.FormType"%>
<%@page import="bean.user.User"%>
<%@page import="database.dao.factory.DAOFactoryImpl"%>
<%@page import="bean.form.Form"%>
<%
String form_id = request.getParameter("form_id");
Form form = DAOFactoryImpl.getFormDAO().findFormbyID(form_id);
User user = (User)session.getAttribute("user");
Form.FormType formType = form.getForm_type();
switch(formType){
case CompanyForm:
	int fillPercent = form.fillPercent(user.getCompany().getUuid());
	break;
case EmployeeForm:
	break;
case DepartmentForm:
	break;
}

%>