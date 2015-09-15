
$(document).ready(ontableLoading());

function ontableLoading() {
	var template = "<div style='margin-left:15px;'><div> Customer ID <sup>*</sup>:</div><div> {CustomerID} </div>";
	template += "<div> Company Name: </div><div>{CompanyName} </div>";
	template += "<div> Phone: </div><div>{Phone} </div>";
	template += "<div> Postal Code: </div><div>{PostalCode} </div>";
	template += "<div> City:</div><div> {City} </div>";
	template += "<hr style='width:100%;'/>";
	template += "<div> {sData} {cData}  </div></div>";
	$("#jqGrid")
			.jqGrid(
					{
						url : 'http://trirand.com/blog/phpjqgrid/examples/jsonp/getjsonp.php?callback=?&qwery=longorders',
						// we set the changes to be made at
						// client side using predefined word
						// clientArray
						editurl : 'clientArray',
						datatype : "json",
						colModel : [ {
							label : 'Customer ID',
							name : 'CustomerID',
							width : 75,
							key : true,
							editable : true,
							editrules : {
								required : true
							}
						}, {
							label : 'Company Name',
							name : 'CompanyName',
							width : 140,
							editable : true
						// must set editable to true if you
						// want to make the field editable
						}, {
							label : 'Phone',
							name : 'Phone',
							width : 100,
							editable : true
						}, {
							label : 'Postal Code',
							name : 'PostalCode',
							width : 80,
							editable : true
						}, {
							label : 'City',
							name : 'City',
							width : 140,
							editable : true
						} ],
						sortname : 'CustomerID',
						sortorder : 'asc',
						loadonce : true,
						viewrecords : true,
						width : 780,
						height : 200,
						rowNum : 10,
						pager : "#jqGridPager"
					});

	$('#jqGrid').navGrid('#jqGridPager',
	// the buttons to appear on the toolbar of the grid
	{
		edit : true,
		add : true,
		del : true,
		search : false,
		refresh : false,
		view : false,
		position : "left",
		cloneToTop : false
	},
	// options for the Edit Dialog
	{
		editCaption : "The Edit Dialog",
		template : template,
		errorTextFormat : function(data) {
			return 'Error: ' + data.responseText
		}
	},
	// options for the Add Dialog
	{
		template : template,
		errorTextFormat : function(data) {
			return 'Error: ' + data.responseText
		}
	},
	// options for the Delete Dailog
	{
		errorTextFormat : function(data) {
			return 'Error: ' + data.responseText
		}
	});
}