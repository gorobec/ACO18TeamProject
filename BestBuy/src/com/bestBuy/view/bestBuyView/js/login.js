$(document).ready(function() {
    var loginData;

     $('form#loginForm').submit(function(e) {

        form = $(this);
        var data = form.serializeArray();
        console.log(data);
         data = $.map(data, function(element){
           return  element.value;
        });
           console.log(data);
            $.ajax({
                type: form.attr('method'),
                url: form.attr('action'),
                dataType: "json",
                data: JSON.stringify({ data: data }),
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

