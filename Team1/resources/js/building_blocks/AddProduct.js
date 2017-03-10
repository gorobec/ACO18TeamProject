$(document).ready(function () {
    $('.modal').modal();

    $("#buttonId").click(function () {

        // get file from input
        let file = $('#file')[0].files;

        let images = [];

        // walk through files array and add base64 strings to images array
        for (i = 0; i < file.length; i++) {
            let reader = new FileReader();

            reader.onloadend = function () {
                images.push(reader.result.split(',')[1]);

            }
            reader.readAsDataURL(file[i]);
        }

        // send response with timeout because of asynchrony
        setTimeout(function () {
            console.log(images);
            $.ajax({
                type: "POST",
                url: "http://localhost:8000/html",
                data: JSON.stringify({
                    name: $('#prodName').val(),
                    location: lat + ',' + lng,
                    image: images.join(',')
                }),
                success: function (data) {
                    $('#modalText').html("DONE!");
                    $('#modal1').modal('open');
                }
            });
        }, 250);
    });


    let lat, lng, myLatLng;

    function mapPopertiesForAddProduct() {
        let mapProp = {
            center: new google.maps.LatLng(50.427994, 30.484166),
            zoom: 8,
        };

        let map = new google.maps.Map(document.getElementById("googleMapAddProduct"), mapProp);
        myLatLng;
        //listener for click
        google.maps.event.addListener(map, "rightclick", function (event) {
            lat = event.latLng.lat();
            lng = event.latLng.lng();
            myLatLng = new google.maps.LatLng(lat, lng);

            console.log(myLatLng);
            $('#mapLocation').val(lat + ', ' + lng);

            //todo place marker
        });
    }

    mapPopertiesForAddProduct();
});
