

<link
	href="<%=application.getContextPath()%>/reporteditor/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="<%=application.getContextPath()%>/reporteditor/css/froala_editor.min.css"
	rel="stylesheet" type="text/css">
<script type="text/javascript"
	src="<%=application.getContextPath()%>/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="<%=application.getContextPath()%>/js/jquery-ui.min.js"></script>


<pre id="eg-previewer" class="prettyprint">
</pre>
<div class="row" id="formbuilder">
	<div class="col-md-6">
		<div class="clearfix">
			<small>Select who will fill the form</small> <select id="whom"
				name="form_type"><option value="CompanyForm">Company</option>
				<option value="DepartmentForm">Department</option>
				<option value="EmployeeForm">Employee</option>
			</select>

			<div id="build">
					<div class="reporteditor" id='edit' style="margin-top: 30px;">
					<form form_id=""></form>
					</div>
			</div>

		</div>
	</div>


	<div class="col-md-6">
		<jsp:include page="/Formbuild/toobar.jsp" />
	</div>
</div>


<div id="form_submit_button_group" class="container-fluid center">
	<button id="bt_submit" onclick="parseFormz();" class="btn btn-primary">Save</button>
	<button id="bt_cancel" onclick="" class="btn btn-primary">Cancel</button>
</div>
<jsp:include page="/reporteditor/index.jsp" />
<script src="<%=application.getContextPath()%>/custom/js/parseForm.js"></script>



