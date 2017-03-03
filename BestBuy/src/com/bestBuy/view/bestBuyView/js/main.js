$(document).ready(function() {
    var dataItems = [];
    var loginData;

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
     $('form#loginForm').submit(function(e) {

        form = $(this);
        var data = form.serializeArray();
        console.log(data);
//         data = $.map(data, function(element){
//           return  element.value;
//        });

            $.ajax({
                type: form.attr('method'),
                url: form.attr('action'),
                data: data,
                dataType: JSON,
                success: function(result)
                {
                   loginData = result;
                   console.log("login data" + loginData);
                },
                complete: function(result){
                    console.log("result login data" + loginData);

                }
         });
        e.preventDefault();

     });


});

