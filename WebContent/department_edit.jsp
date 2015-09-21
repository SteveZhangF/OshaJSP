<jsp:useBean id="department" scope="request"
	class="bean.user.data.Department" />
<form class="form-horizontal"
	action="<%=application.getContextPath()%>/department?">
	<fieldset>
		<div id="legend" class="">
			<legend class="text-center">Department Information</legend>
		</div>
		<input type="hidden" name="action" value="save"/>
		<input type="hidden" name="superDepartmentID" value="<%=request.getParameter("superDepartmentID")%>"/>
		<input type="hidden" name="department_id"
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