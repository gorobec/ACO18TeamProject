$(document).ready(function() {
    var dataItems = [];

    $(window).load(function() {
            $.ajax({
                url: "http://localhost:8000/allProducts",
                success: function(result) {
                    dataItems = result;
                    console.log(dataItems);
                     $('#productTmpl').tmpl(dataItems).appendTo('.product-one');

                }
            });

        });

});