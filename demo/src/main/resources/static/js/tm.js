$(document).ready(function(){
	
$("#tmtext").hide();
$("#tmfile").hide();
$(document).on("change","input[name='tmtype']",function () {
	if ($(this).val()==="word" ) {
		
		$("#tmtext").show(1000);
		$("#tmfile").hide(1000);
	}else {
		$("#tmtext").hide(1000);
		$("#tmfile").show(1000);
	}
});

var j;
$("#addtm").click( function (){
	console.log( "add"+$("#tmdetailtype2").length );
	if (($("#tmdetailtype3").length)==1){return;} //is there gonna be more than 2?
	else if (($("#tmdetailtype2").length)==1){return;/*j=3;is there gonna be more than 2?*/}
	else {j=2;}
	var tm_copy = $("#tmdetailtype").clone(true);
	tm_copy.attr("id","tmdetailtype"+j);
	tm_copy.find("*[id]").each(
			function() { $(this).attr("id", function(i,id){ return id+j; } ); } );
	tm_copy.find("*[name]").each(
			function() {$(this).attr("name",function(i,name){ return "radio"+j; });});	
	$("#tm").append(tm_copy);
	$("#tmdetailtype"+j).append("<button class='deletetm' type='button'>delete</button>");
});

var i="2"; //if there gonna be more than 2 then should make a cycle. on top on change function is another way of handling using name.
$(document).on("click", "#tmword"+i, function(){
	
	$("#tmtext"+i).show(1000);
	$("#tmfile"+i).hide(1000);
});
$(document).on("click","#tmfig"+i+", #tmsound"+i,function(){
	$("#tmtext"+i).hide(1000);
	$("#tmfile"+i).show(1000);
});
//should make a delete button also for 3rd tm
$(document).on("click", ".deletetm", function(){
	$("#tmdetailtype"+i).remove();
});

});

