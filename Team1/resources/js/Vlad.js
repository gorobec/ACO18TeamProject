$(document).ready(function () {

    $holderFroLoginButtons = $('#buttons-login');
    $holderForRegisterPart = $('#registerPart');

    $('#goToRegister').click(function () {
        $('#buttons-login').detach();
        $('#container').append($holderForRegisterPart);
        $holderForRegisterPart.show();

    });

    $('#backToLogin').click(function () {
        $('#registerPart').detach();
        $('#container').append($holderFroLoginButtons);
    });

    $('#submitLogin').click(function () {
        $.ajax({
            type: 'POST',
            url: "http://localhost:8000/login",
            data: JSON.stringify({
                name: $('#username').val(),
                pass: $('#password').val()
            }),
            success: function (result) {
                if(result=='OK') {
                    alert('OK!');
                    $('#container').hide();
                } else{
                    alert(result);
                }
            }
        });
    });

    $('#submitRegister').click(function () {
        $.ajax({
            type: 'POST',
            url: "http://localhost:8000/register",
            data: JSON.stringify({
                name: $('#username').val(),
                pass: $('#password').val(),
                email: $('#email').val()
            }),
            success: function (result) {
                if(result=='OK') {
                    alert('OK! Please, back to login page and sign in.');
                } else{
                    alert(result);
                }
            }
        });
    });
});



