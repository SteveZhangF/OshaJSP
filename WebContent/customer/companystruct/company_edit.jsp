<jsp:useBean id="company" scope="request" class="bean.user.data.Company" />
<form class="form-horizontal" id="contactForm"
	action="<%=application.getContextPath()%>/company?action=save">
	<fieldset>
		<div id="legend" class="">
			<legend class="text-center">Company Information</legend>
		</div>
		<input type="hidden" name="company_id"
			value='<jsp:getProperty property="uuid" name="company"/>' />

		<div class="form-group">

			<!-- Text input-->
			<label class="control-label col-sm-2" for="company_name">Company
				Name:</label>
			<div class="col-sm-10">
				<input type="text" placeholder="Company name"
					class="form-control input-xlarge" id="company_name"
					name="company_name"
					value='<jsp:getProperty property="name" name="company"/>'>
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
					value='<jsp:getProperty property="address" name="company"/>'>
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
					value='<jsp:getProperty property="phone" name="company"/>'>
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
