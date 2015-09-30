<h2>Drag the elements to left</h2>
<hr>
<script type="text/javascript"
	src="<%=application.getContextPath()%>/js/jquery-ui.min.js"></script>
<div class="tabbable">
	<ul class="nav nav-tabs" id="navtab">
		<li class="active"><a href="#1" data-toggle="tab">Elements</a></li>
	</ul>
	<form class="form-horizontal" id="components">
		<div class="tab-content">

			<div class="tab-pane active" id="1">
				<!-- head form name  -->
				<div class="component">
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
					<label>Form Name:</label>
					<h1 class='fqzplugin fqzplugin-form_name' fqzpluginType="form_name"
						style="text-align: center;">Form Name</h1>
				</div>
				<!-- head form name  end -->
				<!-- input text -->
				<!-- text input start -->
				<div class=" component">
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
					<label>Input text:</label> <input class="fqzplugin fqzplugin-text" fqzpluginType="text"
						 type="text" />
				</div>
				<!-- input text end-->
				<!-- table start -->


				<div class=" component field-box">
					<div class="modal fade" id="formnamemodal" tabindex="-1"
						role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
						style="display: none;">
						<div class="modal-dialog modal-sm">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-label="Close"></button>
									<h4 class="modal-title">Set Column Number</h4>
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
					<label>Log Table:</label>
					<table class="table table-bordered fqzplugin" fqzpluginType="table">
						<tbody>
							<tr>
								<td><br></td>

								<td><br></td>

								<td><br></td>
							</tr>
						</tbody>
					</table>
				</div>
				<!-- table end -->
			</div>

		</div>
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


