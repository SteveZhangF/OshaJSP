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