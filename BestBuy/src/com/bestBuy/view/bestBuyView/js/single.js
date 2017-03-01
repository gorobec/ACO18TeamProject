$(document).ready(function() {
    var dataItems = [];

    $(window).load(function() {
		
		    $.ajax({
            type: "POST",
            url: "http://localhost:8000/productByID",
            data: JSON.stringify({id : location.search.split("id=")[1]}),
            success: function(result) {
        	dataItems = result;
        	console.log(JSON.parse(dataItems));
        	},
        	complete: function(result){
        	$('#singleTmpl').tmpl(JSON.parse(dataItems)).appendTo('#product-one');
        	}
        	});   

});

    $("#BUY").click(function() {
        $.ajax({
        	url: "http://localhost:8000/buy",
        	success: function(result) {
				console.log(result);
				$("#resultBuy").html(result);
        	
		}        

    });

});
});

