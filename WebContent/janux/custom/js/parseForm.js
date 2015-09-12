function parseForm(form) {
	alert(form);
	form = $("#"+form);
	var form_id = form.attr("id");// 获取表单id
	var form_name = form.find("legend").val();// 获取表单名称
	var inputs = $(form).find(".control-group");

	var xml = $("<xml></xml");
	var formXML = $("<form></form>");
	alert(formXML.html());
	formXML.attr("id", form_id);
	formXML.attr("name", form_name);
	formXML.appendTo(xml);
	$.each(inputs, function(i, e) {
		var componentXML = $("<component></component>");

		var component_id = $(e).attr("id");// 组件id
		var component_name = $(e).find(".control-label").val();// 组件名称
		var input = $(e).find(".controls").children().first();
		var component_type = $input.attr("type");// 组件类型

		componentXML.attr({
			"name" : component_name,
			"id" : component_id,
			"type" : component_type
		});
		
		var options = input.children();
		// 有子元素
		if (options.length > 0) {
			$.each(options, function(i, e) {
				var option_type = e.tagName;
				var option_displayName = e.val();
				var option_value = e.attr("value");
				
				var optionXML = $("<"+option_type+">"+"</"+option_type+">");
				optionXML.attr("value",option_value);
				optionXML.val(option_displayName);
				optionXML.appendTo(componentXML);
			});
		}
	});
	
	alert(xml.html());

}
function s(xmldata) {
	// 新建列表项
	var ou = $("<ul></ul>").appendTo(odiv);
	// *//获取factory节点
	var f = $(xmldata).find("Factory:first");
	var lfactory = $("<li></li>").appendTo(ou);
	var dfactory = $("<div></div>").appendTo(lfactory);
	var ifactory = $("<img src=''/>").appendTo(dfactory);
	var ifactory2 = $("<img src=''/>").appendTo(dfactory);
	var sfactory = $("<span></span>").appendTo(dfactory);
	// 设置节点属性
	$(sfactory).attr("id", $(f).attr("id"));
	$(sfactory).text($(f).attr("name"));
	$(dfactory).width($(sfactory).text().length * 15 + 35);// 根据数据长度计算div宽度
	$(sfactory).bind("click", function() {
		//绑定点击事件
	});
}