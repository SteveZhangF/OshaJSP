<jsp:useBean id="employee" scope="request"
	class="bean.user.data.Employee" />
<form id="contactForm" class="form-horizontal"
	action="<%=application.getContextPath()%>/employee">

	<input type="hidden" name="action" value="save" /> <input
		type="hidden" name="department_id"
		value="<%=request.getParameter("department_id")%>" /> <input
		type="hidden" name="employee_id"
		value='<jsp:getProperty property="uuid" name="employee"/>' />


	<div class="form-group">
		<label class="col-xs-3 control-label">Full name</label>
		<div class="col-xs-4">
			<input type="text" class="form-control" name="firstName"
				placeholder="First name"
				value="<%String fullname = employee.getEmployeename();
			if(fullname!=null && fullname.contains(":")){
			out.println(fullname.split(":")[0]);}%>" />
		</div>
		<div class="col-xs-4">
			<input type="text" class="form-control" name="lastName"
				placeholder="Last name"
				value="<%if(fullname!=null && fullname.contains(":"))out.println(fullname.split(":")[1]);%>" />
		</div>
	</div>

	<div class="form-group">
		<label class="col-xs-3 control-label">Phone number</label>
		<div class="col-xs-5">
			<input type="text" class="form-control" name="phoneNumber" value="<%=employee.getPhone()%>"/>
		</div>
	</div>

	<div class="form-group">
		<label class="col-xs-3 control-label">Email address</label>
		<div class="col-xs-5">
			<input type="text" class="form-control" name="email" value="<%=employee.getEmail()%>" />
		</div>
	</div>
</form>

<script>
	$(document)
			.ready(
					function() {
						// Generate a simple captcha
						function randomNumber(min, max) {
							return Math.floor(Math.random() * (max - min + 1)
									+ min);
						}

						function generateCaptcha() {
							$('#captchaOperation').html(
									[ randomNumber(1, 100), '+',
											randomNumber(1, 200), '=' ]
											.join(' '));
						}

						generateCaptcha();

						$('#contactForm')
								.formValidation(
										{
											framework : 'bootstrap',
											icon : {
												valid : 'glyphicon glyphicon-ok',
												invalid : 'glyphicon glyphicon-remove',
												validating : 'glyphicon glyphicon-refresh'
											},
											fields : {
												firstName : {
													row : '.col-xs-4',
													validators : {
														notEmpty : {
															message : 'The first name is required'
														}
													}
												},
												lastName : {
													row : '.col-xs-4',
													validators : {
														notEmpty : {
															message : 'The last name is required'
														}
													}
												},
												phoneNumber : {
													validators : {
														notEmpty : {
															message : 'The phone number is required'
														},
														regexp : {
															message : 'The phone number can only contain the digits, spaces, -, (, ), + and .',
															regexp : /^[0-9\s\-()+\.]+$/
														}
													}
												},
												email : {
													validators : {
														notEmpty : {
															message : 'The email address is required'
														},
														emailAddress : {
															message : 'The input is not a valid email address'
														}
													}
												},
											}
										}).on('err.form.fv', function(e) {
									// Regenerate the captcha
									generateCaptcha();
								});
					});
</script>