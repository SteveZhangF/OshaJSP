<script type="text/ecmascript"
	src="<%=application.getContextPath()%>/jqGrid/js/i18n/grid.locale-en.js"></script>
<!-- This is the Javascript file of jqGrid -->
<script type="text/ecmascript"
	src="<%=application.getContextPath()%>/jqGrid/js/jquery.jqGrid.min.js"></script>
<!-- This is the localization file of the grid controlling messages, labels, etc.
    <!-- The link to the CSS that the grid needs -->
<link rel="stylesheet" type="text/css" media="screen"
	href="<%=application.getContextPath()%>/jqGrid/css/ui.jqgrid-bootstrap.css" />
<div style="margin-left: 20px">
	<table id="jqGrid"></table>
	<div id="jqGridPager"></div>
</div>

<script>
	$.jgrid.defaults.width = 780;
	$.jgrid.defaults.responsive = true;
	$.jgrid.defaults.styleUI = 'Bootstrap';
</script>
<script type="text/javascript"
	src="<%=application.getContextPath()%>/custom/js/table.js">
</script>
