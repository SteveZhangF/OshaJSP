<%@page import="model.TopicElement"%>
<%@page import="java.util.List"%>
<%@page import="database.dao.factory.DAOFactoryImpl"%>

<!DOCTYPE html>
<html lang="en">


<head>
<!-- start: Meta -->
<meta charset="utf-8">
<title>Bootstrap Metro Dashboard by Dennis Ji for ARM demo</title>
<meta name="description" content="Bootstrap Metro Dashboard">
<meta name="author" content="Dennis Ji">
<meta name="keyword"
	content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<!-- end: Meta -->

<!-- start: Mobile Specific -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- end: Mobile Specific -->

<!-- start: CSS -->
<link id="bootstrap-style" href="<%=application.getContextPath()%>/janux/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=application.getContextPath()%>/janux/css/bootstrap-responsive.min.css" rel="stylesheet">
<link id="base-style" href="<%=application.getContextPath()%>/janux/css/style.css" rel="stylesheet">
<link id="base-style-responsive" href="<%=application.getContextPath()%>/janux/css/style-responsive.css"
	rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext'
	rel='stylesheet' type='text/css'>
<!-- end: CSS -->


<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	  	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<link id="ie-style" href="<%=application.getContextPath()%>/janux/css/ie.css" rel="stylesheet">
	<![endif]-->

<!--[if IE 9]>
		<link id="ie9style" href="<%=application.getContextPath()%>/janux/css/ie9.css" rel="stylesheet">
	<![endif]-->

<!-- start: Favicon -->
<link rel="shortcut icon" href="./img/favicon.ico">
<!-- end: Favicon -->
</head>
<body>
	<!-- start: Header Menu -->
	<jsp:include page="_header_menu.jsp" />
	<!-- end: Header Menu -->
			<noscript>
			<div class="alert alert-block span10">
				<h4 class="alert-heading">Warning!</h4>
				<p>
					You need to have <a href="http://en.wikipedia.org/wiki/JavaScript"
						target="_blank">JavaScript</a> enabled to use this site.
				</p>
			</div>
		</noscript>
		
		<div class="container-fluid-full">
	<div class="row-fluid">
		<!-- start: Main Menu -->
		<jsp:include page="_main_menu.jsp" />
		<!-- end: Main Menu -->