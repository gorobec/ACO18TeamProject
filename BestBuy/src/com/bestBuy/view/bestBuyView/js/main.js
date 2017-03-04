$(document).ready(function() {
    var dataItems = [];

    $(window).load(function() {

        $.ajax({
        	url: "http://localhost:8000/allProducts",
        	success: function(result) {
        	    dataItems = result;
        	    console.log(JSON.parse(dataItems));
        	},
        	complete: function(result){
                $('#productTmpl').tmpl(JSON.parse(dataItems)).appendTo('#product-one');
                $('#productTmpl2').tmpl(JSON.parse(dataItems)).appendTo('#about-top');
        	}


        });


    });



});

