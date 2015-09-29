<jsp:useBean id="department" scope="request"
	class="bean.user.data.Department" />


<style>
.form_tab {
	padding-top: 30px;
	min-height: 20px;
}
</style>

<ul class="nav nav-tabs" role="tablist">
	<li role="presentation" class="active"><a
		href="#basic_information" aria-controls="basic_information" role="tab"
		data-toggle="tab">Basic Information</a></li>
	<li role="presentation"><a href="#forms" data-toggle="tab"
		onclick="showEmployeeFormSelector('<%=department.getUuid()%>')">Forms</a></li>
</ul>
<div class="tab-content">

	<!-- show the  basic information start -->
	<div role="tabpanel" class="tab-pane fade in active form_tab "
		id="basic_information">

		<form id="contactForm"class="form-horizontal"
			action="<%=application.getContextPath()%>/department?">
			<fieldset>
				<div id="legend" class="">
					<legend class="text-center">Department Information</legend>
				</div>
				<input type="hidden" name="action" value="save" /> <input
					type="hidden" name="superDepartmentID"
					value="<%=request.getParameter("superDepartmentID")%>" /> <input
					type="hidden" name="department_id"
					value='<jsp:getProperty property="uuid" name="department"/>' />

				<div class="form-group">

					<!-- Text input-->
					<label class="control-label col-sm-2" for="department_name">Department
						Name:</label>
					<div class="col-sm-10">
						<input type="text" placeholder="Department name"
							class="form-control input-xlarge" id="department_name"
							name="department_name"
							value='<jsp:getProperty property="name" name="department"/>'>
						<p class="help-block">please type the department name</p>
					</div>
				</div>

				<div class="form-group">
					<!-- Text input-->
					<label class="control-label col-sm-2" for="department_address">Address:</label>
					<div class="col-sm-10">
						<input type="text" placeholder="Address"
							class="input-xlarge form-control" id="department_address"
							name="department_address"
							value='<jsp:getProperty property="address" name="department"/>'>
						<p class="help-block">please type address</p>
					</div>
				</div>


				<div class="form-group">

					<!-- Text input-->
					<label class="control-label col-sm-2" for="department_phone">Phone
						Number:</label>
					<div class="col-sm-10">
						<input type="text" placeholder="Phone Number"
							class="form-control input-xlarge" id="department_phone"
							name="department_phone"
							value='<jsp:getProperty property="phone" name="department"/>'>
						<p class="help-block">please type the phone number</p>
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
				onclick="submitCustomizedForm('<%=department.getUuid()%>');"
				class="btn btn-primary">Save</button>
			<button id="bt_preview" onclick="">Preview</button>
			<button id="bt_cancel" onclick="" class="btn btn-primary">Cancel</button>
		</div>
	</div>

</div>