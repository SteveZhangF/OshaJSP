function getUUID() {
	var id="0";
	return id;
}

function parseFormz() {
	var $form = $("<div>").html($(".reporteditor").find(".froala-element").html());
	var form_id = $form.attr("form_id");// 
	var form_name = $form.find(".fqzplugin[fqzpluginType='form_name']").attr("value");// 获取表单名称
	var inputs = $form.find(".fqzplugin");

	var $formXML = $("<form></form>");
	$formXML.attr("id", form_id);
	$formXML.attr("name", form_name);

	$.each(inputs, function(i, e) {
		switch ($(e).attr("fqzpluginType")) {
		case "text":
			$(e).attr("sequence_code",i);
			$($(e).parent()).attr("sequence_code",i);
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
	var content = $formXML.prop("outerHTML");// prop.("outerHTML") 可以输出包括自己在内的html内容
	console.log(content);
	console.log($form.html());
	var result={xml:content,html:$form.prop("outerHTML")};
	return result;
}

function parseText($e) {
	// alert($e.html());
	var $componentXML = $("<component></component>");
	var component_id = $e.attr("component_id");// 组件id
	var component_type = $e.attr("fqzpluginType");// 组件类型
	var component_name = $e.attr("name");
	var sequence_code = $e.attr("sequence_code");
	$componentXML.attr({
		"name" : component_name,
		"id" : component_id,
		"type" : component_type,
		"sequence_code":sequence_code
	});
	return $componentXML;
}

function parseSelect($e) {
	var $componentXML = $("<component></component>");
	var component_id = $e.attr("component_id");// 组件id
	alert(component_id);
	//var component_name = $(e).find(".control-label").first().val();// 组件名称
	var $select = $e.find(".controls").children().first();
	var component_type = $select.attr("leipiplugins");// 组件类型
	var component_name = $select.attr("title");
	$componentXML.attr({
		"name" : component_name,
		"id" : component_id,
		"type" : component_type
	});
	var options = $select.find("option");
	$.each(options, function(i, o) {
		var $optionXML = $("<option></option>");
		var option_title = $(o).val();
		//display name
		$optionXML.append(option_title);
		//value
		$optionXML.attr("value", option_title);
		$componentXML.append($optionXML);
	});
	return $componentXML;

}

function parseTextarea($e) {
	var $componentXML = $("<component></component>");
	var component_id = $e.attr("component_id");// 组件id
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

function parseCheckbox($e) {
	var $componentXML = $("<component></component>");
	var component_id = $e.attr("component_id");// 组件id
	//var component_name = $(e).find(".control-label").first().val();// 组件名称
	var $checkboxdiv = $e.find(".controls").first();
	var component_type = $checkboxdiv.attr("mtype");// 组件类型

	var component_name = $e.children().first().html();
	// alert($e.children().first().html());
	var options = $checkboxdiv.find("input[type='checkbox']");
	
	
	//<label>
    //<input type="checkbox" value="option_title" name="component_id">
    //option_title
    //</label>
	//<input type="checkbox" value="" name="###Form_Component_ID###">
	$.each(options, function(i, o) {
		var $optionXML = $("<label></label>");
		var option_title = $(o).val();
		
		var $optionInput=$("<input></input>");
		$optionInput.attr("type", "checkbox");
		$optionInput.attr("value", option_title);
		$optionInput.attr("name",component_id);
		
		$optionXML.append($optionInput);
		$optionXML.append(option_title);
		$componentXML.append($optionXML);
	});
	$componentXML.attr({
		"name" : component_name,
		"id" : component_id,
		"type" : component_type
	});
	return $componentXML;
}

function parseRadio($e) {
	var $componentXML = $("<component></component>");
	var component_id = $e.attr("component_id");// 组件id
	//var component_name = $(e).find(".control-label").first().val();// 组件名称
	var $radiodiv = $e.find(".controls").first();
	var component_type = $radiodiv.attr("mtype");// 组件类型

	var component_name = $e.children().first().html();
	// alert($e.children().first().html());
	var options = $radiodiv.find("input[type='radio']");
	$.each(options, function(i, o) {
		
		var $optionXML = $("<label></label>");
		var option_title = $(o).val();
		
		var $optionInput=$("<input></input>");
		$optionInput.attr("type", "radio");
		$optionInput.attr("value", option_title);
		$optionInput.attr("name",component_id);
		
		$optionXML.append($optionInput);
		$optionXML.append(option_title);
		$componentXML.append($optionXML);
		
		alert($optionXML.html());
		
	});
	$componentXML.attr({
		"name" : component_name,
		"id" : component_id,
		"type" : component_type
	});
	return $componentXML;
}
