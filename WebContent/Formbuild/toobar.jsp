<h2>Drag the elements to left</h2>
<hr>
<script type="text/javascript"
	src="<%=application.getContextPath()%>/js/jquery-ui.min.js"></script>
<div class="tabbable">
	<ul class="nav nav-tabs" id="navtab">
		<li class="active"><a href="#1" data-toggle="tab">Elements</a></li>
	</ul>
	<form class="form-horizontal" id="components">
		<fieldset>
			<div class="tab-content">

				<div class="tab-pane active" id="1">
					<!-- input text -->
					<div class="form-group component">
						<label class="control-label col-sm-2" for="form_name">Text Field:</label>
						<fqzplugin class="fqzplugin" name="" fqzpluginType="text"><input type="text" ></fqzplugin>
					</div>
					<!-- input text end-->
				</div>

			</div>
		</fieldset>
	</form>
</div>

<!--tab-content-->
<script>
	/* $temp = $("<form class='form-horizontal span6' id='temp'></form>").append(
	 $this.clone()); */
</script>

<script>
	$(function() {
		$(".component").draggable({
			helper : "clone",
		});

		$(".reporteditor").droppable(
				{
					//&& objPos.left<uPos.left+$u.width() && objPos.top>uPos.top-$u.height()
					drop : function(event, ui) {
						var mousPos = {
							left : event.pageX,
							top : event.pageY
						};

						$allU = $(this).find(".froala-element").find("u");
						for (var i = 0; i < $allU.length; i++) {
							$u = $($allU[i]);
							var uPos = $u.offset();
							if (mousPos.left > uPos.left
									&& mousPos.top > uPos.top
									&& mousPos.left < uPos.left + $u.width()
									&& mousPos.top < uPos.top + $u.height()) {
								$u.html("				");
								console.log(ui.draggable.find("fqzplugin").prop("outerHTML"));
								$u.append($(ui.draggable.find("fqzplugin").prop("outerHTML")));
							}
						}
						
						console.log($(this).find(".froala-element").html());
						/* $.each($allU,function(i,u){
							
						}); */

					}
				});
	})
	/* $(function() {
	 $(".reporteditor").droppable({
	 drop:function(event,ui){
	 alert($(this).html());
	 $(this).html($("<p style='position:absolute;left:"+
	ui.offset.left+";top:"+ui.offset.top+"'>clone</p>"));
	 }
	 });
	 }) */
</script>


