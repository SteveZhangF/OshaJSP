<%@page import="bean.user.User"%>
<%@page import="bean.user.data.OrganizationElement"%>
<%@page import="bean.user.data.Department"%>
<jsp:useBean id="employee" scope="request"
	class="bean.user.data.Employee" />
<jsp:useBean id="user" scope="session" class="bean.user.User" />
<!-- Nav tabs -->

<style>
.form_tab {
	padding-top: 30px;
	min-height: 20px;
}
</style>
<script type="text/javascript"
	src="<%=application.getContextPath()%>/custom/js/formselector.js">
	
</script>
<ul class="nav nav-tabs" role="tablist">
	<li role="presentation" class="active"><a
		href="#basic_information" aria-controls="basic_information" role="tab"
		data-toggle="tab">Basic Information</a></li>
	<li role="presentation"><a href="#forms" data-toggle="tab"
		onclick="showEmployeeFormSelector('<%=employee.getUuid()%>')">Forms</a></li>
</ul>
<div class="tab-content">

	<!-- show the employee basic information start -->
	<div role="tabpanel" class="tab-pane fade in active form_tab "
		id="basic_information">
		<form id="contactForm" class="form-horizontal"
			action="<%=application.getContextPath()%>/employee">
			<fieldset>
				<div id="legend" class="">
					<legend class="text-center">Employee Information</legend>
				</div>
				<input type="hidden" name="action" value="save" /> <input
					type="hidden" name="employee_id"
					value='<jsp:getProperty property="uuid" name="employee"/>' />


				<div class="form-group">
					<label class="col-xs-3 control-label">Full name</label>
					<div class="col-xs-4">
						<input type="text" class="form-control" name="firstName"
							placeholder="First name"
							value="<%String fullname = employee.getName();
			if (fullname != null && fullname.contains(":")) {
				out.println(fullname.split(":")[0]);
			}%>" />
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" name="lastName"
							placeholder="Last name"
							value="<%if (fullname != null && fullname.contains(":"))
				out.println(fullname.split(":")[1]);%>" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-xs-3 control-label">Phone number</label>
					<div class="col-xs-5">
						<input type="text" class="form-control" name="phoneNumber"
							value="<%=employee.getPhone()%>" />
					</div>
				</div>

				<div class="form-group">
					<label class="col-xs-3 control-label">Email address</label>
					<div class="col-xs-5">
						<input type="text" class="form-control" name="email"
							value="<%=employee.getEmail()%>" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-xs-3 control-label">Department</label>
					<div class="col-xs-5">
						<select name="department_id" class="form-control">
							<option value="">No Department</option>
							<%
								if (employee.getDepartment() != null) {
							%>
							<option value="<%=employee.getDepartment().getUuid()%>" selected><%=employee.getDepartment().getName()%></option>
							<%
								for (OrganizationElement oe : user.getCompany().getDepartments()) {
										if (oe instanceof Department && !oe.getUuid().equals(employee.getDepartment().getUuid())) {
							%>
							<option value="<%=oe.getUuid()%>"><%=oe.getName()%></option>
							<%
								}
									}

								} else {
									for (OrganizationElement oe : user.getCompany().getDepartments()) {
										if (oe instanceof Department) {
							%>
							<option value="<%=oe.getUuid()%>"><%=oe.getName()%></option>
							<%
								}
									}
								}
							%>
						</select>
					</div>
				</div>

			</fieldset>
		</form>
		<div id="form_submit_button_group" class="center">
			<button id="bt_submit" onclick="subOrganazation();"
				class="btn btn-primary center">Save</button>
			<button id="bt_cancel" onclick="" class="btn btn-primary">Cancel</button>
		</div>

	</div>
	<!-- show the employee basic information end-->

	<!-- show the forms start -->
	<div role="tabpanel" class="tab-pane fade form_tab" id="forms">
		<div class="form_selector row" id="employee_form_selector"></div>
		<hr>
		<div id="form_container"></div>
		<div class="modal" id="preview_container">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close"></button>
						<h4 class="modal-title">Preview</h4>
					</div>
					<div class="modal-body"></div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Print</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
		</div>

		<div id="form_submit_button_group" class="center">
			<button id="bt_submit"
				onclick="submitCustomizedForm('<%=employee.getUuid()%>');"
				class="btn btn-primary">Save</button>
			<button id="bt_preview" onclick="">Preview</button>
			<button id="bt_cancel" onclick="" class="btn btn-primary">Cancel</button>
		</div>
	</div>
	<!-- show the forms end -->
</div>
