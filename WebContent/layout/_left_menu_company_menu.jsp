<%@page import="bean.user.data.OrganizationElement"%>
<%@page import="bean.user.data.ShowEmployee"%>
<%@page import="bean.user.data.Employee"%>
<%@page import="bean.user.data.ShowDepartment"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="bean.user.data.Department"%>
<%@page import="bean.user.data.Company"%>
<%-- <script type="text/ecmascript"
	src="<%=application.getContextPath()%>/custom/js/menu_tree.js"></script> --%>

<%Company company =(Company) request.getAttribute("company");
	if(company == null){
		company = new Company();
	}
%>

<div class="tree">
	<ul class="companyul">
		<li><span class="tree-node company " data-toggle="context">
				<i class="glyphicon glyphicon-home"></i> <%=company.getName()%></span>
			<%
				if (company != null) {
					Set<OrganizationElement> departements = company.getDepartments();
					ShowDepartment sd = new ShowDepartment();
					for (OrganizationElement oe : departements) {
						if(!(oe instanceof Department)){
							continue;
						}
							Department dep = (Department)oe;
						if (dep.getParentDepartment() == null)
							out.println(sd.show(dep));
					}

					Set<OrganizationElement> employees = company.getEmployees();
					ShowEmployee showEmployee = new ShowEmployee();
					for (OrganizationElement dep : employees) {
						if(!(dep instanceof Employee)){
							continue;
						}
						Employee ee = (Employee)dep;
						if (ee.getDepartment() == null)
							out.println(showEmployee.show(ee));
					}
				}
			%></li>
	</ul>
</div>
<div id="context-menu-department">
	<ul class="dropdown-menu" role="menu">
		<li><a tabindex="-1" id="add_department">Add Department</a></li>
		<li><a tabindex="-1" id="add_employee">Add Employee</a></li>
		<li><a tabindex="-1" id="edit_department">Edit</a></li>
		<li class="divider"></li>
		<li><a tabindex="-1" id="delete">Delete</a></li>
	</ul>
</div>
<div id="context-menu-company">
	<ul class="dropdown-menu" role="menu">
		<li><a tabindex="-1" id="add_department">Add Department</a></li>
		<li><a tabindex="-1" id="add_employee">Add Employee</a></li>
	</ul>
</div>

<div id="context-menu-employee">
	<ul class="dropdown-menu" role="menu">
		<li><a tabindex="-1" id="edit_employee">Edit</a></li>
	</ul>
</div>

