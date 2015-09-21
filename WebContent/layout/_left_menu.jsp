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
	src="<%=application.getContextPath()%>/custom/js/bootstrap-contextmenu.js"></script>
<div class="col-sm-3 col-md-2 sidebar ">
		


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
