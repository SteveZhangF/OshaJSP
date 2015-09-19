<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li><a role="button" data-toggle="collapse"
			href="#module_collapse" onclick="javascript:moduleOnClick();">
				Module</a>
			<ul id="module_collapse" class="collapse nav nav-sidebar-sub">
				
			</ul></li>

		<li><a role="button" data-toggle="collapse"
			href="#osha_collapse" onclick="javascript:submitForm('<%=application.getContextPath()%>/user',{action:'list'},function(data){$('#main_container').html(data)});">
				Users</a>
			<ul id="osha_collapse"  class="collapse nav nav-sidebar-sub">
											
			</ul></li>
			
			
		<li><a href="#">Hippa</a></li>
	</ul>
<script type="text/javascript"
	src="<%=application.getContextPath()%>/custom/js/dashboard.js">
	
</script>
</div>
