<%@page import="bean.user.data.ShowEmployee"%>
<%@page import="bean.user.data.Employee"%>
<%@page import="bean.user.data.ShowDepartment"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="bean.user.data.Department"%>
<jsp:useBean id="company" scope="request" class="bean.user.data.Company" />
<form class="form-horizontal"
	action="<%=application.getContextPath()%>/company">
	<fieldset>
		<div id="legend" class="">
			<legend class="text-center">Company Information</legend>
		</div>
		<input type="hidden" name="action"
			value='<%=request.getAttribute("action")%>' /> <input type="hidden"
			name="company_id"
			value='<jsp:getProperty property="uuid" name="company"/>' />

		<div class="form-group">

			<!-- Text input-->
			<label class="control-label col-sm-2" for="company_name">Company
				Name:</label>
			<div class="col-sm-10">
				<input type="text" placeholder="Company name"
					class="form-control input-xlarge" id="company_name"
					name="company_name"
					value='<jsp:getProperty property="company_name" name="company"/>'>
				<p class="help-block">please type the company name</p>
			</div>
		</div>

		<div class="form-group">
			<!-- Text input-->
			<label class="control-label col-sm-2" for="company_address">Address:</label>
			<div class="col-sm-10">
				<input type="text" placeholder="Address"
					class="input-xlarge form-control" id="company_address"
					name="company_address"
					value='<jsp:getProperty property="company_address" name="company"/>'>
				<p class="help-block">please type address</p>
			</div>
		</div>


		<div class="form-group">

			<!-- Text input-->
			<label class="control-label col-sm-2" for="company_phone">Phone
				Number:</label>
			<div class="col-sm-10">
				<input type="text" placeholder="Phone Number"
					class="form-control input-xlarge" id="company_phone"
					name="company_phone"
					value='<jsp:getProperty property="company_phone" name="company"/>'>
				<p class="help-block">please type the phone number</p>
			</div>
		</div>
	</fieldset>
</form>


<!-- show the department or employee edit dialog  start -->

<div class="modal fade" id="showeditModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">Modal title</h4>
			</div>
			<div class="modal-body">
				<p>One fine body&hellip;</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary"
					onclick="subOrganazation('0','0')">Save changes</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal-dialog -->
</div>
<!-- /.modal -->

<!--  show the department or employee edit dialog end -->


<link href="<%=application.getContextPath()%>/custom/css/menu_tree.css"
	rel="stylesheet">
<script type="text/ecmascript"
	src="<%=application.getContextPath()%>/custom/js/menu_tree.js"></script>
<script type="text/ecmascript"
	src="<%=application.getContextPath()%>/custom/js/company.js"></script>
<script type="text/ecmascript"
	src="<%=application.getContextPath()%>/custom/js/bootstrap-contextmenu.js"></script>
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
<div class="tree well">

	<ul>

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
	</ul>
</div>
