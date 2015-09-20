<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li><a role="button" data-toggle="collapse"
			href="#department_collapse" onclick="javascript:editcompany();">
				Company</a>
			<ul id="department_collapse" class="collapse nav nav-sidebar-sub">
				<li><a role="button" href="#"
					onclick="getForm('./department','list');"><i
						class="icon-file-alt"></i><span class="hidden-tablet">
							Departments</span></a></li>
				<li><a role="button" href="#"
					onclick="getForm('./employee','list');"><i
						class="icon-file-alt"></i><span class="hidden-tablet">
							Employee</span></a></li>
			</ul></li>

		<li><a role="button" data-toggle="collapse" href="#osha_collapse"
			onclick="javascript:submitForm('<%=application.getContextPath()%>/form_operation',{action:'list'},function(data){$('#osha_collapse').html(data)});">
				Osha</a>
			<ul id="osha_collapse" class="collapse nav nav-sidebar-sub">

				<li><a role="button" href="#"
					onclick="getForm('./department','list');"><i
						class="icon-file-alt"></i><span class="hidden-tablet">
							Departments</span></a></li>
				<li><a role="button" href="#"
					onclick="getForm('./employee','list');"><i
						class="icon-file-alt"></i><span class="hidden-tablet">
							Employee</span></a></li>

			</ul></li>


		<li><a href="#">Hippa</a></li>
	</ul>
</div>
