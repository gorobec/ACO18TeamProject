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
                alert(loginData)
            },
            complete: function(result){
                window.location.href="index.html"
            }
        });

        e.preventDefault();
        this.reset();

     });


});

