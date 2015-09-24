(function($) {
	var FQZ = window.FQZ = window.FQZ || {
		plugins : []
	}

	FQZ.plugins["form_name"] = function(options) {
		$towhom = $(options.towhom);
		var ui = options.ui;
		$me = $(ui.draggable.find(".fqzplugin"));

		$modal = $($me.siblings(".modal"));
		$modal.find(".modal-footer .btn-primary").click(
				function(event) {
					var value = $modal.find("input").val();
					$me.attr("value", value);
					$me.find("h1").text(value);
					$towhom.find("h1").remove();
					$towhom.prepend($(ui.draggable.find("fqzplugin").prop(
							"outerHTML")));
					$modal.modal("hide");

				});
		$modal.modal("show");
	}
	FQZ.plugins["text"] = function(options) {
		var ui = options.ui;
		var mousPos = options.mousePos;
		$towhom = $(options.towhom);
		$me = $(ui.draggable.find(".fqzplugin"));
		$allU = $towhom.find("u");
		for (var i = 0; i < $allU.length; i++) {
			$u = $($allU[i]);
			var uPos = $u.offset();
			if (mousPos.left > uPos.left && mousPos.top > uPos.top
					&& mousPos.left < uPos.left + $u.width()
					&& mousPos.top < uPos.top + $u.height()) {

				$modal = $($me.siblings(".modal"));
				$modal.find(".modal-footer .btn-primary").click(
						function(event) {
							var value = $modal.find("input").val();
							$me.attr("name", value);
							$u.html("				");
							$u.append($(ui.draggable.find("fqzplugin").prop(
									"outerHTML")));
							$modal.modal("hide");

						});
				$modal.modal("show");
			}
		}
	}
})(jQuery);
