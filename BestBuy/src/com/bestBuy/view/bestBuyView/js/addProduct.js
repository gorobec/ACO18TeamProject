$(document).ready(function() {
    var frm = $('#productForm');

    frm.submit(function(ev) {
        $.ajax({
            type: frm.attr('method'),
        	url: "http://localhost:8000/addproduct",
            // data: frm.serialize(),
            data: JSON.stringify({name : $("#name").val(),
				price : $("#price").val(),
				imageUrl : $("#imageUrl").val()}),
        	success: function(result) {
				console.log(result);
				if (result == "true") {
                    $("#Result").html("Success");
				} else {
                    $("#Result").html("Fail");
				}
		}

    });
        ev.preventDefault();
});
});

