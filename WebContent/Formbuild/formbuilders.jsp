<pre id="eg-previewer" class="prettyprint">
</pre>
<div class="row" id="formbuilder">
	<div class="span6">
		<div class="clearfix">
			<small>Select who will fill the form</small> <select
				class="form-control" id="whom" name="form_type"><option
					value="CompanyForm">Company</option>
				<option value="DepartmentForm">Department</option>
				<option value="EmployeeForm">Employee</option>
			</select> <small>Is it a Log?</small> <select class="form-control" id="ifLog"
				name="ifLog"><option value="no">No</option>
				<option value="Monthly">Monthly</option>
				<option value="weekly">Weekly</option>
				<option value="daily">Daily</option>
			</select>

			<div id="build">
				<form>
					<div class="reporteditor" id='edit' style="margin-top: 30px;">
					</div>
				</form>
			</div>

		</div>
	</div>


	<div class="span6">
		<jsp:include page="/Formbuild/toobar.jsp" />
	</div>
</div>


<div id="form_submit_button_group" class="container-fluid center">
	<button id="bt_submit" onclick="saveForm();" class="btn btn-primary">Save</button>
	<button id="bt_cancel" onclick="" class="btn btn-primary">Cancel</button>
</div>
<jsp:include page="formbuilder_editor.jsp" />
<script src="<%=application.getContextPath()%>/custom/js/parseForm.js"></script>
<script src="<%=application.getContextPath()%>/custom/js/dashboard.js"></script>



