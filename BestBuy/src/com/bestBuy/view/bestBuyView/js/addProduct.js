$(document).ready(function() {
    var frm = $('#productForm');
    var reader = new FileReader();
    frm.submit(function(ev) {

        var img = [];

        $('#list').find('img').each(function(){
            img.push($(this).attr('src'));
        });

        $.ajax({
            type: frm.attr('method'),
        	url: "http://localhost:8000/addproduct",
            // data: frm.serialize(),
            data: JSON.stringify({name : $("#name").val(),
				price : $("#price").val(),
                imageUrl : img}),
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


function handleFileSelect(event) {
    var files = event.target.files; // FileList object

    // Loop through the FileList and render image files as thumbnails.
    for (var i = 0, f; f = files[i]; i++) {

        // Only process image files.
        if (!f.type.match('image.*')) {
            continue;
        }

        var reader = new FileReader();

        // Closure to capture the file information.
        reader.onload = (function(theFile) {
            return function(e) {
                // Render thumbnail.
                var span = document.createElement('span');
                span.innerHTML = ['<img class="thumb" src="', e.target.result,
                    '" title="', escape(theFile.name), '"/>'].join('');
                document.getElementById('list').insertBefore(span, null);
            };
        })(f);

        // Read in the image file as a data URL.
        reader.readAsDataURL(f);
        // reader.readAsBinaryString(f);
    }
}

