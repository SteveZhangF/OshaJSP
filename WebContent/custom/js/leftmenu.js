/**
 * create the left menu and content based on json
 * 
 * [{"id":"402880914ffe493e014ffe4b36a80003","name":"Osha"}] <ul class="nav"
 * <li class="active"><a href="#" data-toggle="tab"><i class=\"glyphicon
 * glyphicon-user\"></i><span>Moduls</span></a> </li>
 * </ul>
 * 
 * <div class="col-md-2 side"> <div class="tab-pane" id="b">
 * <h3>What's your Favorite?</h3>
 * </div> </div>
 * 
 */

(function($) {
	var methods = {
		init : function(options) {
			var options = $.extend(defaults, options);
			$this = $(this);
			if ($this.find(".leftmenu").length == 0
					|| $this.find(".leftmenu .side").length == 0
					|| $this.find(".leftmenu .tab-content").length == 0) {
				$divrow = $("<div class='row leftmenu'></div>");
				$divleft = $("<div></div>");
				$divleft.addClass("col-md-2").addClass("side");
				$ul = $("<ul></ul>")
				$ul.addClass("nav");
				$divleft.append($ul);
				$divcontent = $("<div class='tab-content col-md-10'></div>");
				$divrow.append($divleft);
				$divrow.append($divcontent);
				$this.html("");
				$this.append($divrow);
			}
			return $(this);
		},
		createli : function(options) {
			$this = $(this);
			var options = $.extend(defaults, options);
			var li_toggle = defaults.li_toggle;
			$ul =$( $this.children(".leftmenu").children(".side").children(".nav"));
			var e = options.data;
			var id = e.id;
			var name = e.name;
			$li = $("<li></li>");
			$a = $("<a></a>");
			$a.attr("href", "#" + li_toggle);
			$i = $("<i></i>");
			$span = $("<span></span>")
			$span.text(name);
			$i.addClass(defaults.icon);
			$a.attr("data-toggle","tab");
			$a.append($i);
			$a.append($span);
			$li.append($a);
			$ul.append($li);
			return $(this);
		},
		createcontent : function(options) {
			var options = $.extend(defaults, options);
			$this = $(this);
			$tab = $("<div class=\"tab-pane\"></div>");
			$tab.attr("id",options.id);
			$tab.append(defaults.data);
			$divcontent = $($this.children(".leftmenu").children("div.tab-content"));
			$divcontent.append($tab);
			return $(this);
		},
		hide : function() {
			// good
		},
		update : function(content) {
			// !!!
		}
	};

	var defaults = {
		icon : "glyphicon  glyphicon-user",
		onclick : "",
		content : "",
		data : "",
		data_url : "",
		content_url : "",
		li_toggle : ""// 触发谁
	};
	/**
	 * @param vurl:
	 *            表单action地址
	 * @param vdata:
	 *            表单数据
	 * @param callback:
	 *            提交成功后回调函数
	 */
	function getData(vurl, vdata, callback) {
		$.ajax({
			cache : true,
			type : "POST",
			url : vurl,
			data : vdata,
			async : false,
			error : function(request) {

			},
			success : function(data) {
				callback(data);
			}
		});
	}


	$.fn.createleftmenu = function(method) {
		// 方法调用
		if (methods[method]) {
			methods.init.apply(this, arguments);
			return methods[method].apply(this, Array.prototype.slice.call(
					arguments, 1));
		} else if (typeof method === 'object' || !method) {
			return methods.init.apply(this, arguments);
		} else {
			$.error('Method' + method + 'does not exist on jQuery.tooltip');
		}

	};
})(jQuery);