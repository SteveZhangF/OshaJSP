<link
	href="<%=application.getContextPath()%>/reporteditor/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="<%=application.getContextPath()%>/reporteditor/css/froala_editor.min.css"
	rel="stylesheet" type="text/css">



<!--[if lt IE 9]>
    <script src="../js/froala_editor_ie8.min.js"></script>
  <![endif]-->
<script
	src="<%=application.getContextPath()%>/reporteditor/js/froala_editor.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="<%=application.getContextPath()%>/reporteditor/js/plugins/tables.min.js"></script>
<script
	src="<%=application.getContextPath()%>/reporteditor/js/plugins/lists.min.js"></script>
<script
	src="<%=application.getContextPath()%>/reporteditor/js/plugins/colors.min.js"></script>
<script
	src="<%=application.getContextPath()%>/reporteditor/js/plugins/media_manager.min.js"></script>
<script
	src="<%=application.getContextPath()%>/reporteditor/js/plugins/font_family.min.js"></script>
<script
	src="<%=application.getContextPath()%>/reporteditor/js/plugins/font_size.min.js"></script>
<script
	src="<%=application.getContextPath()%>/reporteditor/js/plugins/block_styles.min.js"></script>
<script
	src="<%=application.getContextPath()%>/reporteditor/js/plugins/video.min.js"></script>
<script>
	$(function() {
		$('.reporteditor').on('editable.contentChanged editable.initialized',
				function(e, editor) {
					$all = $(editor.getHTML());
					$('pre#eg-previewer').html($all);
				}).editable({
			useFrTag : true,
			inlineMode : false,
			alwaysBlank : true,
			height : 300,
			toolbarFixed : false,
		})
	});
</script>