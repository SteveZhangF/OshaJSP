

<script>
/* /* dragcomponent('.component');
var dropTargets = [];

function addDropTarget(dropTarget) {
	dropTargets.push(dropTarget);
}

addDropTarget($(".reporteditor"));
function getPosition(e) {
	var left = 0;
	var top = 0;

	while (e.offsetParent) {
		left += e.offsetLeft;
		top += e.offsetTop;
		e = e.offsetParent;
	}

	left += e.offsetLeft;
	top += e.offsetTop;

	return {
		x : left,
		y : top
	};
}
function dragcomponent(obj) {

	$(obj)
			.udraggable(
					{
						containment: $('.reporteditor'),
						
						distance : 15,
						start : function() {
							$temp = $($(this).clone());
							$($(this).parent()).append($temp);
							dragcomponent($temp);
						},
						 stop : function(e, ui) {
							var mousePos = {
								x : ui.position.left,
								y : ui.position.top
							};
							//for (var i = 0; i < dropTargets.length; i++) {
								$curTarget = $(".reporteditor");
								var targPos = {
										x : $curTarget.offset().left,
										y : $curTarget.offset().top
									};
								var targWidth = parseInt($curTarget.width());
								var targHeight = parseInt($curTarget.height());
								alert("mousepX="+mousePos.x+"mousepY="+mousePos.y+"targpX="+targPos.x+"targpY="+targPos.y+"w="+targWidth+"h="+targHeight);
								if ((mousePos.x > targPos.x)
										&&
										(mousePos.x < (targPos.x + targWidth))
										&& (mousePos.y > targPos.y)
										&& (mousePos.y < (targPos.y + targHeight))) {
									alert("in");
									// dragObject was dropped onto curTarget!
									$temp = $($(this).clone());
									curTarget.append($temp);
									alert(curTarget.html());
								}
							//}
							$(this).remove();

						}, 
						drag : function(e, ui) {
							var pos = ui.position
							$('#stat-x').text(pos.left);
							$('#stat-y').text(pos.top);
						}

					});
} */ */