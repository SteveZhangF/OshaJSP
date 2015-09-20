<%@page import="bean.user.data.ShowEmployee"%>
<%@page import="bean.user.data.Employee"%>
<%@page import="bean.user.data.ShowDepartment"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="bean.user.data.Department"%>
<%@page import="bean.user.data.Company"%>
<jsp:useBean id="user" scope="session" class="bean.user.User" />
<link href="<%=application.getContextPath()%>/custom/css/menu_tree.css"
	rel="stylesheet">
<script type="text/ecmascript"
	src="<%=application.getContextPath()%>/custom/js/menu_tree.js"></script>
<script type="text/ecmascript"
	src="<%=application.getContextPath()%>/custom/js/company.js"></script>
<script type="text/ecmascript"
	src="<%=application.getContextPath()%>/custom/js/bootstrap-contextmenu.js"></script>
<div class="col-sm-3 col-md-2 sidebar ">
	<%
		Company company = user.getCompany();
	%>
	<div class="tree">
		<ul class="companyul">

		</ul>
	</div>



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
