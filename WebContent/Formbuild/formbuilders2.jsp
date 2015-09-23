

<div class="row">
	<div class="col-md-6">
		<div class="clearfix">
			<small>Select who will fill the form</small> <select id="whom"
				name="form_type"><option value="CompanyForm">Company</option>
				<option value="DepartmentForm">Department</option>
				<option value="EmployeeForm">Employee</option>
			</select>

<jsp:include page="/reporteditor/index.jsp" />


			<h2>My Form</h2>
			<hr>
			<div id="build">
				<form id="targs" class="form-horizontal">
					<fieldset>
					
					<textarea id="target"  name="content"></textarea>
					
					
					
						<div id="legend" class="component " rel="popover"
							title="Edit property" trigger="manual"
							data-content="
                <form class='form'>
                  <div class='controls'>
                    <label class='control-label'>Form Name</label> <input type='text' id='orgvalue' placeholder='Please type the form name'><hr/>
                    <button class='btn btn-info' type='button'>OK</button><button class='btn btn-danger' type='button'>Cancel</button>
                  </div>
                </form>">
							<input type="hidden" name="form_name" value=""
								class="leipiplugins" leipiplugins="form_name" />
							<legend class="leipiplugins-orgvalue">Click to edit the
								form name</legend>
						</div>
					</fieldset>
				</form>

				<div id="form_submit_button_group" class="container-fluid center">
					<button id="bt_submit" onclick="saveForm();"
						class="btn btn-primary">Save</button>
					<button id="bt_cancel" onclick="" class="btn btn-primary">Cancel</button>
				</div>
			</div>

		</div>
	</div>


	<div class="col-md-6">
		<jsp:include page="toobar.jsp" />
		<!---tabbable-->

	</div>
</div>

<script type="text/javascript"
	src="<%=application.getContextPath()%>/Formbuild/Public/js/formbuild/bootstrap/js/bootstrap.min.js?2024"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=application.getContextPath()%>/Formbuild/Public/js/formbuild/leipi.form.build.core.js?2024"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=application.getContextPath()%>/Formbuild/Public/js/formbuild/leipi.form.build.plugins.js?2024"></script>
<script type="text/javascript"
	src="<%=application.getContextPath()%>/Formbuild/Public/js/formbuild/parseForm.js">
		
	</script>

