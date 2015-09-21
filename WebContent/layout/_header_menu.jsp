<jsp:useBean id="user" scope="session" class="bean.user.User" />
<script type="text/ecmascript"
	src="<%=application.getContextPath()%>/custom/js/company.js"></script>
<link href="<%=application.getContextPath()%>/custom/css/login.css"
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
						<li><a href="#">Another action</a></li>
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


<!-- login modal start -->
<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true"
	style="display: none;">
	<div class="modal-dialog">
		<div class="loginmodal-container" id="modal_container">
			<form id="login_form" class="login">
				<h1>Login to Your Account</h1>
				<br> <input type="text" name="email" placeholder="Email">
				<input type="password" name="password" placeholder="Password">
			</form>
			<form id="register_form" class="hidden register">
				<h1>Create new Account</h1>
				<br> <input type="text" name="email" placeholder="Email"
					onfocus="checkEmail(this);"> <input type="password"
					name="password" placeholder="Password"> <input
					type="password" name="confrim password"
					placeholder="Confrim Password">
			</form>
			<div class="alert alert-success hidden" id="login_alert" role="alert">Success!</div>
			<button class="btn btn-default login" onclick="login(login_form);">Login</button>
			<button class="btn btn-default hidden register"
				onclick="register(register_form);">Register</button>
			<div class="login-help login">
				<a href="javascript:void(0)"
					onclick="showRegister(modal_container);">Register</a> - <a href="#">Forgot
					Password</a>
			</div>
		</div>
	</div>
</div>
<!-- login modal end -->
<script src="<%=application.getContextPath()%>/custom/js/login.js"></script>
<script src="<%=application.getContextPath()%>/custom/js/company.js"></script>
<noscript>
	<div class="alert alert-block span10">
		<h4 class="alert-heading">Warning!</h4>
		<p>
			You need to have <a href="http://en.wikipedia.org/wiki/JavaScript"
				target="_blank">JavaScript</a> enabled to use this site.
		</p>
	</div>
</noscript>