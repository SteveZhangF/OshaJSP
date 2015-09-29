<%@page import="bean.form.module.Module"%>
<%@page import="bean.user.data.OrganizationElement"%>
<%@page import="bean.user.data.ShowEmployee"%>
<%@page import="bean.user.data.Employee"%>
<%@page import="bean.user.data.ShowDepartment"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.List"%>
<%@page import="bean.user.data.Department"%>
<%@page import="bean.user.data.Company"%>
<style>
.avatar-box {
	border-right: 1px solid #edeff1;
	box-shadow: inset 3px 0px 4px -1px #fafafa;
}
</style>

<%
	Module modules = (Module) request.getAttribute("modules");
%>
<div class="span3 avatar-box">
	<div class="tree">
		<%
			out.println(modules.show());
		%>
	</div>
</div>
<div class="span7 module-edit form-edit"></div>

<div id="context-menu-module">
	<ul class="dropdown-menu" role="menu">
		<li><a tabindex="-1" id="add_module">Add Module</a></li>
		<li><a tabindex="-1" id="add_form">Add Form</a></li>
		<li><a tabindex="-1" id="edit_module">Edit</a></li>
		<li class="divider"></li>
		<li><a tabindex="-1" id="delete">Delete</a></li>
	</ul>
</div>

<div id="context-menu-form">
	<ul class="dropdown-menu" role="menu">
		<li><a tabindex="-1" id="edit_form">Edit</a></li>
		<li><a tabindex="-1" id="delete_form">Delete</a></li>
	</ul>
</div>

<link rel="stylesheet" type="text/css"
	href="<%=application.getContextPath()%>/custom/css/menu_tree.css" />
<script src="<%=application.getContextPath()%>/custom/js/menu_tree.js"></script>
<script type="text/javascript"
	src="<%=application.getContextPath()%>/libs/jquery-ui/jquery-ui.min.js"></script>
<script
	src="<%=application.getContextPath()%>/custom/js/bootstrap-contextmenu.js"></script>
<script src="<%=application.getContextPath()%>/dashboard/js/edit_module.js">
</script>