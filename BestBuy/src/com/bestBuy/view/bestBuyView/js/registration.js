$(document).ready(function() {
    var registerData;

    $('form#registerForm').submit(function(e) {

        form = $(this);
        var data = form.serializeArray();

        data = $.map(data, function(element){
           return  element.name + '"' + ":" + '"' +  element.value;
        });

        console.log(data);

        $.ajax({
            type: form.attr('method'),
            url: form.attr('action'),
            data: JSON.stringify(data),
            success: function(result)
            {
                registerData = result;
                console.log("login data " + registerData);
            },
            complete: function(result){
                console.log("result login data " + registerData);
            }
        });

        e.preventDefault();
        this.reset();
         alert("Registration is successful")
     });


});

