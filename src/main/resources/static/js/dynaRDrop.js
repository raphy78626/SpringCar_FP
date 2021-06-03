$(document).ready(function() {
	$("#make").change(function() {
		var selectedMake = $("#make").val()
		var selectedModel = selectedMake.split("=")[1].replace("[", "").replace("]", "").split(',');
		var optionList = "";
		var yearList = "";
		for (var i = 0; i < selectedModel.length; i++) {
			optionList += "<option value='" + selectedModel[i].trim() + "'>" + selectedModel[i].trim() + "</option>";
		}
		console.log(optionList)
		var d = new Date();
		var currentYear = d.getFullYear();
		for (var i = 2000; i <= currentYear; i++) {
			yearList += "<option value=" + i + ">" + i + "</option>";
		}
		$("#transmission").html("<option value='MANUAL'>MANUAL</option> <option value='AUTOMATIC'>AUTOMATIC</option>")
		$("#fuelType").html("<option value='PETROL'>PETROL</option> <option value='DIESEL'>DIESEL</option>")
		$("#makeYearId").html(yearList);
		$("#model").html(optionList);
	});
});
