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
//		alert(data.form);
		$("#form_container").html(data.form);
		parseRecord(data.records[0]);
	});
}
/**
 * parse the record and fill them to the form
 * @param recordjson: one record in json format
 * */
function parseRecord(recordjson){
	var recordid = recordjson.id;
	var frclist = recordjson.frcList;
	$.each(frclist,function(i,frc){
		var fcid=frc.fComponent.sequence_code;
		var value=frc.value;
		
		$component=$("u[sequence_code='"+fcid+"']").find(".fqzplugin");
		$component.val(value);
	});
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
