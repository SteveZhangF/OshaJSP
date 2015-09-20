<%@page import="bean.user.data.ShowEmployee"%>
<%@page import="bean.user.data.Employee"%>
<%@page import="bean.user.data.ShowDepartment"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="bean.user.data.Department"%>
<%@page import="bean.user.data.Company"%>



<<jsp:useBean id="company" scope="request" type="bean.user.data.Company"></jsp:useBean>
<li><span class="tree-node company " data-toggle="context">
		<i class="glyphicon glyphicon-home"></i> <%=company.getCompany_name()%></span>
	<%
		Set<Department> departements = company.getDepartments();
		ShowDepartment sd = new ShowDepartment();
		for (Department dep : departements) {
			if (dep.getParentDepartment() == null)
				out.println(sd.show(dep));
		}

		Set<Employee> employees = company.getEmployees();
		ShowEmployee showEmployee = new ShowEmployee();
		for (Employee dep : employees) {
			if (dep.getDepartment() == null)
				out.println(showEmployee.show(dep));
		}
	%></li>