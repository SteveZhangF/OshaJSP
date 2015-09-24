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
					<!-- head form name  -->
					<div class="form-group component">
						<div class="modal fade" id="" tabindex="-1" role="dialog"
							aria-labelledby="myModalLabel" aria-hidden="true"
							style="display: none;">
							<div class="modal-dialog modal-sm">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close"></button>
										<h4 class="modal-title">Set Form Name</h4>
									</div>
									<div class="modal-body">
										<input type="text">
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
										<button type="button" class="btn btn-primary">Save
											changes</button>
									</div>
								</div>
								<!-- /.modal-content -->
							</div>
						</div>
						<label class="control-label col-2" for="fqzpluginformname">Form
							Name:</label>
						<fqzplugin class="fqzplugin col-10" id="fqzpluginformname"
							value="Form Name" fqzpluginType="form_name">
						<h1 style="text-align: center;">Form Name</h1>
						</fqzplugin>
					</div>
					<!-- head form name  end -->
					<!-- input text -->
					<div class="form-group component">
						<div class="modal fade" id="formnamemodal" tabindex="-1"
							role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
							style="display: none;">
							<div class="modal-dialog modal-sm">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close"></button>
										<h4 class="modal-title">Set Field Name</h4>
									</div>
									<div class="modal-body">
										<input type="text">
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
										<button type="button" class="btn btn-primary">Save
											changes</button>
									</div>
								</div>
								<!-- /.modal-content -->
							</div>
						</div>
						<label class="control-label col-2" for="fqzplugintext">Text
							Field:</label>
						<fqzplugin class="fqzplugin col-10" id="fqzplugintext" name=""
							fqzpluginType="text"> <input type="text"></fqzplugin>
					</div>
					<!-- input text end-->
					
				</div>

			</div>
		</fieldset>
	</form>
</div>

<!--tab-content-->
<script src="<%=application.getContextPath()%>/custom/js/fqzplugin.js">
	
</script>

<script>
	$(function() {
		$(".component").draggable({
			helper : "clone",
		});

		$(".reporteditor").droppable({
			drop : function(event, ui) {
				var mousPos = {
					left : event.pageX,
					top : event.pageY
				};
				$plug = ui.draggable.find(".fqzplugin");
				var type = $plug.attr("fqzpluginType");
				FQZ.plugins[type]({
					ui : ui,
					mousePos : mousPos,
					towhom : $(this).find(".froala-element")
				});
			}
		});
	})
</script>


