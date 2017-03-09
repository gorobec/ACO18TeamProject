/**
 * Created by v21k on 09.03.17.
 */
$(document).ready(function () {
    $('.modal').modal();
})

function logout() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8000/logout",
        success: function (response) {
            $('#modalText').html(response);
            $('#modal').modal('open');
        }
    });
}