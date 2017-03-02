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
				$("#Result").html(result);
        	
		}

    });
        ev.preventDefault();
});
});

