<jsp:useBean id="user" scope="session" class="bean.user.User" />
<script type="text/ecmascript"
	src="<%=application.getContextPath()%>/custom/js/company.js"></script>
<script type="text/ecmascript"
	src="<%=application.getContextPath()%>/custom/js/module.js"></script>
<script type="text/ecmascript"
	src="<%=application.getContextPath()%>/custom/js/percent.js"></script>
<script src="<%=application.getContextPath()%>/custom/js/login.js"></script>
<script type="text/ecmascript"
	src="<%=application.getContextPath()%>/custom/js/menu_tree.js"></script>
<link href="<%=application.getContextPath()%>/custom/css/login.css"
	rel="stylesheet">
	<link href="<%=application.getContextPath()%>/custom/css/menu_tree.css"
	rel="stylesheet">
	
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">HAHAHA</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<%
					if (user.getUser_email() == null) {
				%>
				<li><a href="#" data-toggle="modal" data-target="#login-modal">Login</a></li>
				<%
					} else {
				%>
				<li><a href="#" class="dropdown-toggle" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="true">Profile</a>
					<ul class="dropdown-menu">
						<li><a href="javascript:void(0)" onclick="editcompany();">Company</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="javascript:void(0)" onclick="moduleShow();">Modules</a></li>
						<li><a href="#">Something else here</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="javascript:void(0)" onclick="logout();">Log
								out</a></li>
					</ul></li>
				<%
					}
				%>
				<li><a href="#">Help</a></li>

			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>
</nav>


<noscript>
	<div class="alert alert-block span10">
		<h4 class="alert-heading">Warning!</h4>
		<p>
			You need to have <a href="http://en.wikipedia.org/wiki/JavaScript"
				target="_blank">JavaScript</a> enabled to use this site.
		</p>
	</div>
</noscript>