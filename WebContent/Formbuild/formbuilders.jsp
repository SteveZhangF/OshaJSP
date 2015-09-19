
<div class="row">
	<div class="col-md-6">
		<div class="clearfix">
			<h2>My Form</h2>
			<small>Select who will fill the form</small>
			<select id="whom" name="form_type"><option value="CompanyForm">Company</option>
				<option value="DepartmentForm">Department</option>
				<option value="EmployeeForm">Employee</option> 
				</select>
			<hr>
			<div id="build">
				<form id="target" class="form-horizontal">
					<fieldset>
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
		<h2>Drag the elements to left</h2>
		<hr>

		<div class="tabbable">
			<ul class="nav nav-tabs" id="navtab">
				<li class="active"><a href="#1" data-toggle="tab">Elements</a></li>
			</ul>
			<form class="form-horizontal" id="components">
				<fieldset>
					<div class="tab-content">

						<div class="tab-pane active" id="1">


							<!-- Text start -->
							<div class="control-group component" rel="popover"
								title="Text Component" trigger="manual"
								data-content="
  <form class='form'>
    <div class='controls'>
      <label class='control-label'>Name</label> <input type='text' id='orgname' placeholder='name'>
      <label class='control-label'>Default</label> <input type='text' id='orgvalue' placeholder='default'>
      <hr/>
      <button class='btn btn-info' type='button'>OK</button><button class='btn btn-danger' type='button'>Cancel</button>
    </div>
  </form>">
								<!-- Text -->
								<label class="control-label leipiplugins-orgname">Text</label>
								<div class="controls" mtype="text">
									<input name="leipiNewField" type="text" placeholder="Default"
										title="Text" value="" class="leipiplugins" leipiplugins="text" />
								</div>

							</div>
							<!-- Text end -->


							<!-- Textarea start -->
							<div class="control-group component" rel="popover"
								title="Textarea" trigger="manual"
								data-content="
  <form class='form'>
    <div class='controls'>
      <label class='control-label'>Name</label> <input type='text' id='orgname' placeholder=''>
      <label class='control-label'>Default</label> <input type='text' id='orgvalue' placeholder='default'>
      <hr/>
      <button class='btn btn-info' type='button'>OK</button><button class='btn btn-danger' type='button'>Cancel</button>
    </div>
  </form>">
								<!-- Textarea -->
								<label class="control-label leipiplugins-orgname">Textarea</label>
								<div class="controls" mtype="textarea">
									<div class="textarea">
										<textarea title="Textarea" name="leipiNewField"
											class="leipiplugins" leipiplugins="textarea" />
										</textarea>
									</div>
								</div>
							</div>
							<!-- Textarea end -->

							<!-- Select start -->
							<div class="control-group component" rel="popover" title="Select"
								trigger="manual"
								data-content="
  <form class='form'>
    <div class='controls'>
      <label class='control-label'>Name</label> <input type='text' id='orgname' placeholder='name'>
      <label class='control-label'>Options</label>
      <textarea style='min-height: 200px' id='orgvalue'></textarea>
      <p class='help-block'></p>
      <hr/>
      <button class='btn btn-info' type='button'>OK</button><button class='btn btn-danger' type='button'>Cancel</button>
    </div>
  </form>">
								<!-- Select -->
								<label class="control-label leipiplugins-orgname">Select</label>
								<div class="controls" mtype="select">
									<select name="leipiNewField" title="Select"
										class="leipiplugins" leipiplugins="select">
										<option>option1</option>
										<option>option2</option>
										<option>option3</option>
									</select>
								</div>

							</div>
							<!-- Select end -->





							<!-- Multiple Checkboxes start -->


							<div class="control-group component" rel="popover"
								title="Checkbox" trigger="manual"
								data-content="
  <form class='form'>
    <div class='controls'>
      <label class='control-label'>Name</label> <input type='text' id='orgname' placeholder='name'>
      <label class='control-label'>Checkbox</label>
      <textarea style='min-height: 200px' id='orgvalue'></textarea>

      <hr/>
      <button class='btn btn-info' type='button'>OK</button><button class='btn btn-danger' type='button'>Cancel</button>
    </div>
  </form>">
								<label class="control-label leipiplugins-orgname">Checkbox</label>
								<div class="controls leipiplugins-orgvalue" mtype="checkbox">
									<!-- Multiple Checkboxes -->
									<label class="checkbox"> <input type="checkbox"
										name="leipiNewField" title="Checkbox" value="option1"
										class="leipiplugins" leipiplugins="checkbox"> option1
									</label> <label class="checkbox"> <input type="checkbox"
										name="leipiNewField" title="Checkbox" value="option2"
										class="leipiplugins" leipiplugins="checkbox"> option2
									</label>
								</div>
							</div>
							<!-- Multiple Checkboxes end -->

							<!-- Multiple radios start -->


							<div class="control-group component" rel="popover" title="Radio"
								trigger="manual"
								data-content="
  <form class='form'>
    <div class='controls'>
      <label class='control-label'>Name</label> <input type='text' id='orgname' placeholder='name'>
      <label class='control-label'>Radio</label>
      <textarea style='min-height: 200px' id='orgvalue'></textarea>

      <hr/>
      <button class='btn btn-info' type='button'>OK</button><button class='btn btn-danger' type='button'>Cancel</button>
    </div>
  </form>">
								<label class="control-label leipiplugins-orgname">Radio</label>
								<div class="controls leipiplugins-orgvalue" mtype="radio">
									<!-- Multiple Checkboxes -->
									<label class="radio"> <input type="radio"
										name="leipiNewField" title="Radio" value="option1"
										class="leipiplugins" leipiplugins="radio"> option1
									</label> <label class="radio"> <input type="radio"
										name="leipiNewField" title="Radio" value="option2"
										class="leipiplugins" leipiplugins="radio"> option2
									</label>
								</div>
							</div>
							<!-- Multiple radios end -->


						</div>
						<div class="tab-pane" id="5">
							<textarea id="source" class="span6"></textarea>
						</div>
				</fieldset>
			</form>
		</div>
		<!--tab-content-->
	</div>
	<!---tabbable-->

</div>

<script type="text/javascript" charset="utf-8"
	src="<%=application.getContextPath()%>/Formbuild/Public/js/jquery-1.7.2.min.js?2024"></script>
<script type="text/javascript"
	src="<%=application.getContextPath()%>/Formbuild/Public/js/formbuild/bootstrap/js/bootstrap.min.js?2024"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=application.getContextPath()%>/Formbuild/Public/js/formbuild/leipi.form.build.core.js?2024"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=application.getContextPath()%>/Formbuild/Public/js/formbuild/leipi.form.build.plugins.js?2024"></script>
<script type="text/javascript"
	src="<%=application.getContextPath()%>/Formbuild/Public/js/formbuild/parseForm.js">
	
</script>
