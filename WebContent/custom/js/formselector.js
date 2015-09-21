function showEmployeeFormSelector(employeeid) {
	createSelect({
		action : "showEmployeeFormSelectJson",
		employee_id : employeeid
	});
}

function submitCustomizedForm(id){
	submitForm("./form_operation?action=submitform&id="+id,$("#form_container").find("form").serialize(),function(data){alert("success!")});
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
		
		$moduleOptionAll=$("<option value='All'>All</option>");
		
		$moduleSelect.append($moduleOptionAll);
		
		$formOptionAll = $("<optgroup label=\"sss\"></optgroup>");
		$.each(data, function(i, item) {
			$moduleOption = $("<option></option>");
			$moduleOption.attr("value", item.id);
			$moduleOption.text(item.name);
			$moduleSelect.append($moduleOption);
			$formOptions = $("<optgroup label=\""+item.name+"\"></optgroup>");
			$.each(item.forms,function(i,form){
				$formOption = $("<option></option>");
				$formOption.attr("value", form.id);
				$formOption.text(form.name);
				$formOptions.append($($formOption.prop("outerHTML")));
			});
			$formOptionAll.append($($formOptions.prop("outerHTML")));
			formselects.Set(item.id,$formOptions);
		});
		
		formselects.Set("All",$formOptionAll);
		$formSelect.append(formselects.Get("All").html());
		
		$moduleSelect.change(function() {
			$formSelect.html("");
			$formSelect.append(formselects.Get($(this).val()).html());
			
			$formSelect.change();
			
		});
		$formSelect.change(function(){
			
			
			submitForm("./form_operation",{action:"viewform",form_id:$(this).val()},function(data){
				$("#form_container").html(data);
			});
		});

		$(".form_selector").html("");
		$(".form_selector").append($moduleSelect);
		$(".form_selector").append($formSelect);
		
		$formSelect.change();

	});
}
