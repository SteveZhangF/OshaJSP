function parseForm(form) {
	// alert($("#source").val());
	var $form  = $("<div>").html($("#source").val()); 
	$form = $form.find("form");

	var form_id = $form.attr("id");// 获取表单id

	var form_name = $form.find(".leipiplugins[leipiplugins='form_name']").first().attr("value");// 获取表单名称
	var inputs = $form.find(".control-group");
	
	var $formXML = $("<form></form>");
	$formXML.attr("id", form_id);
	$formXML.attr("name", form_name);

	$.each(inputs, function(i, e) {
		alert($(e).find(".controls").attr("mtype"));
		switch($(e).find(".controls").attr("mtype")){
			case "text":
			parseText($(e)).appendTo($formXML);
			break;
			case "select":
			parseSelect($(e)).appendTo($formXML);
			break;
			case "textarea":
			parseTextarea($(e)).appendTo($formXML);
			break;
			case "checkbox":
			parseCheckbox($(e)).appendTo($formXML);
			break;
			case "radio":
			parseRadio($(e)).appendTo($formXML);
			break;
		}
	});
	
	return $formXML;
}

function parseText($e){
	// alert($e.html());
	var $componentXML = $("<component></component>");
	var component_id = $e.attr("id");// 组件id
		//var component_name = $(e).find(".control-label").first().val();// 组件名称
		var $input = $e.find(".controls").children().first();
		var component_type = $input.attr("leipiplugins");// 组件类型
		var component_name = $input.attr("title");
		$componentXML.attr({
			"name" : component_name,
			"id" : component_id,
			"type" : component_type
		});
		return $componentXML;
}
//提交数据
function submitForm(vurl, vdata, vaction) {
	$.ajax({
		cache : true,
		type : "POST",
		url : vurl,
		data : vdata+ "&action=" + vaction,
		async : false,
		error : function(request) {
		},
		success : function(data) {
			//$("#option_table").html(data);
			alert("success");
		}
	});
}


function parseSelect($e){
		var $componentXML = $("<component></component>");
		var component_id = $e.attr("id");// 组件id
		//var component_name = $(e).find(".control-label").first().val();// 组件名称
		var $select = $e.find(".controls").children().first();
		var component_type = $select.attr("leipiplugins");// 组件类型
		var component_name = $select.attr("title");
		var options = $select.find("option");
		$.each(options, function(i, o){
			var $optionXML = $("<option></option>");
			var option_title=$(o).val();
			$optionXML.attr("display_name",option_title);
			$optionXML.attr("value",option_title);
			$componentXML.append($optionXML);
		});
		return $componentXML;

}

function parseTextarea($e){
	var $componentXML = $("<component></component>");
	var component_id = $e.attr("id");// 组件id
	var $textarea = $e.find("textarea").first();
	var component_type = $textarea.attr("leipiplugins");// 组件类型
	var component_name = $textarea.attr("title");
	$componentXML.attr({
			"name" : component_name,
			"id" : component_id,
			"type" : component_type
		});

	return $componentXML;
}

function parseCheckbox($e){
	var $componentXML = $("<component></component>");
		var component_id = $e.attr("id");// 组件id
		//var component_name = $(e).find(".control-label").first().val();// 组件名称
		var $checkboxdiv = $e.find(".controls").first();
		var component_type = $checkboxdiv.attr("mtype");// 组件类型

		var component_name = $e.children().first().html();
		// alert($e.children().first().html());
		var options = $checkboxdiv.find("input[type='checkbox']");
		$.each(options, function(i, o){
			var $optionXML = $("<option></option>");
			var option_title=$(o).val();
			$optionXML.attr("display_name",option_title);
			$optionXML.attr("value",option_title);
			$componentXML.append($optionXML);
		});
		$componentXML.attr({
			"name" : component_name,
			"id" : component_id,
			"type" : component_type
		});
		return $componentXML;
}

function parseRadio($e){
		var $componentXML = $("<component></component>");
		var component_id = $e.attr("id");// 组件id
		//var component_name = $(e).find(".control-label").first().val();// 组件名称
		var $radiodiv = $e.find(".controls").first();
		var component_type = $radiodiv.attr("mtype");// 组件类型

		var component_name = $e.children().first().html();
		// alert($e.children().first().html());
		var options = $radiodiv.find("input[type='radio']");
		$.each(options, function(i, o){
			var $optionXML = $("<option></option>");
			var option_title=$(o).val();
			$optionXML.attr("display_name",option_title);
			$optionXML.attr("value",option_title);
			$componentXML.append($optionXML);
		});
		$componentXML.attr({
			"name" : component_name,
			"id" : component_id,
			"type" : component_type
		});
		return $componentXML;
}
