$(document).ready(function () {
    $('.modal').modal();

    $holderFroLoginButtons = $('#buttons-login');
    $holderForRegisterPart = $('#registerPart');

    $('#goBack').click(function () {
        // $('#buttons-login').detach();
        // $('#container').append($holderForRegisterPart);
        // $holderForRegisterPart.show();

    });

    $('#backToLogin').click(function () {
        $('#registerPart').detach();
        $('#container').append($holderFroLoginButtons);
    });

    $('#search').click(function () {
        $.ajax({
            type: 'POST',
            url: "http://localhost:8000/getproductbyid",
            /*data: JSON.stringify({
                name: $('#username').val(),
                pass: $('#password').val()
            }),
            success: function (result) {
                if (result == 'OK') {
                    $('#modalText').html("Welcome to our store!");
                    $('#modal1').modal('open');
                    $('#container').hide();
                } else {
                    $('#modalText').html(result);
                    $('#modal1').modal('open');
                }
            }*/
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
                if (result == 'OK') {
                    $('#modalText').html("OK. Please, back to login page and sign in.");
                    $('#modal1').modal('open');
                } else {
                    $('#modalText').html(result);
                    $('#modal1').modal('open');
                }
            }
        });
    });
});



