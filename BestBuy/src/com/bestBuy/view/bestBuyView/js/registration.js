$(document).ready(function() {

    $('form#registerForm').submit(function(e) {

        form = $(this);
        var data = form.serializeArray();

        data = $.map(data, function(element){
           return  element.name + '"' + ":" + '"' +  element.value;
        });

        $.ajax({
            type: form.attr('method'),
            url: form.attr('action'),
            data: JSON.stringify(data),
            success: function(result)
            {
                alert(result);
            },
            complete: function(result){
                if(result.responseText == "Registraion was successful"){
                  form[0].reset();
                   window.location.href="index.html"

                }

            }
        });

        e.preventDefault();

     });


});

