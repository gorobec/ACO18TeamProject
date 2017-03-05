$(document).ready(function() {
    var loginData;

    $('form#loginForm').submit(function(e) {

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
                loginData = result;
                console.log("login data " + loginData);
            },
            complete: function(result){
                console.log("result login data " + loginData);
            }
        });

        e.preventDefault();
        this.reset();
        alert("Login is successful")
     });


});

