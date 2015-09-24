function showEmployeeFormSelector(employeeid) {
	createSelect({
		action : "showEmployeeFormSelectJson",
		employee_id : employeeid
	});
}

function showForm(formid, voe_id) {
	submitForm("./userform", {
		action : "viewform",
		form_id : formid,
		oe_id : voe_id
	}, function(data) {
		$("#form_container").html(data.form);
		$("#preview_container .modal-body").html(data.report);
		parseRecord(data.records);
		parsePreview(data.records);
	});
}

function parsePreview(recordjson){
	
	if($(".modal").find(".fqzplugin[fqzplugintype='table']")){
		console.log("atable");
		$table = $($(".modal").find("table"));
		$tr = $($table.find("tr").last().clone(true));
		var tds=$tr.find("td");
		$.each(tds,function(i,td){
			$(td).html("");
		});
		$.each(recordjson,function(i,re){
			
			var recordid = re.id;
			var frclist = re.frcList;
			
			$row = $('table tr:eq('+i+1+')');
			$.each(frclist,function(nn,frc){
				var fcid=frc.fComponent.sequence_code;
				var value=frc.value;
				$component=$($row.find("td[sequence_code='"+fcid+"']"));
				$component.html("&nbsp; &nbsp; &nbsp; &nbsp;"+value+"&nbsp; &nbsp; &nbsp; &nbsp; ");
			});
			$($table.find("tbody")).append($($tr.prop("outerHTML")));
			console.log($table.html());
			
		});
		$("#bt_preview").click(function(){
			$("#preview_container").modal("show");
		});
	}else{
		var recordjson = recordjson[0];
		var recordid = recordjson.id;
		var frclist = recordjson.frcList;
		$.each(frclist,function(i,frc){
			var fcid=frc.fComponent.sequence_code;
			var value=frc.value;
			$component=$(".modal u[sequence_code='"+fcid+"']");
			$component.html("&nbsp; &nbsp; &nbsp; &nbsp;"+value+"&nbsp; &nbsp; &nbsp; &nbsp; ");
		});
		
		$("#bt_preview").click(function(){
			$("#preview_container").modal("show");
		});
	}
}
/**
 * parse the record and fill them to the form
 * @param recordjson: one record in json format
 * */
function parseRecord(recordjson){
	var recordjson = recordjson[0];
	$("#form_container").find("form").append("<input type='hidden' name='record_id' value='"+recordjson.id+"'>");
	var recordid = recordjson.id;
	var frclist = recordjson.frcList;
	$.each(frclist,function(i,frc){
		var fcid=frc.fComponent.uuid;
		var value=frc.value;
		$component=$("#"+fcid);
		$component.val(value);
	});
//	var recordid = recordjson.id;
//	var frclist = recordjson.frcList;
//	$.each(frclist,function(i,frc){
//		var fcid=frc.fComponent.sequence_code;
//		var value=frc.value;
//		
//		$component=$("u[sequence_code='"+fcid+"']").find(".fqzplugin");
//		$component.val(value);
//	});
}
function viewReport(){
	
}

/**
 * @param id:OE
 *            id (Company employee department id)
 */
function submitCustomizedForm(id) {
	submitForm("./userform?action=submitform&id=" + id, $("#form_container")
			.find("form").serialize(), function(data) {
		alert("success!")
	});
}

function createSelect(vdata) {
	$.getJSON("./userform", vdata, function(data) {
		var $moduleSelect = $("<select class='form-control'></select>");
		var $formSelect = $("<select class='form-control'></select>");

		var formselects = {
			Set : function(key, value) {
				this[key] = value
			},
			Get : function(key) {
				return this[key]
			},
			Contains : function(key) {
				return this.Get(key) == null ? false : true
			},
			Remove : function(key) {
				delete this[key]
			}
		}

		$moduleOptionAll = $("<option value='All'>All</option>");

		$moduleSelect.append($moduleOptionAll);

		$formOptionAll = $("<optgroup label=\"sss\"></optgroup>");
		$.each(data, function(i, item) {
			$moduleOption = $("<option></option>");
			$moduleOption.attr("value", item.id);
			$moduleOption.text(item.name);
			$moduleSelect.append($moduleOption);
			$formOptions = $("<optgroup label=\"" + item.name
					+ "\"></optgroup>");
			$.each(item.forms, function(i, form) {
				$formOption = $("<option></option>");
				$formOption.attr("value", form.uuid);
				$formOption.text(form.name);
				$formOptions.append($($formOption.prop("outerHTML")));
			});
			$formOptionAll.append($($formOptions.prop("outerHTML")));
			formselects.Set(item.id, $formOptions);
		});

		formselects.Set("All", $formOptionAll);
		$formSelect.append(formselects.Get("All").html());

		$moduleSelect.change(function() {
			$formSelect.html("");
			$formSelect.append(formselects.Get($(this).val()).html());

			$formSelect.change();

		});
		$formSelect.change(function() {
			showForm($(this).val(), vdata.employee_id);
		});

		$(".form_selector").html("");
		$(".form_selector").append($moduleSelect);
		$(".form_selector").append($formSelect);

		$formSelect.change();

	});
}
