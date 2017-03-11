$(document).ready(function () {
    $('.modal').modal();

    toMain();

    document.getElementById('userImage').onmouseover = function () {
        $('#changeUserPicForm').show();
    }

    document.getElementById('userImage').onmouseout = function () {
        $('#changeUserPicForm').hide();
    }
});

function addProduct() {

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
            url: "/html",
            data: JSON.stringify({
                name: $('#prodName').val(),
                location: lat + ',' + lng,
                image: images.join(',')
            }),
            success: function (data) {
                $('#modalText').html("DONE!");
                $('#modal1').modal('open');
                $('#row-box').html("");
                getProducts();
            }
        });
    }, 250);
};

var productList;

function buy(id) {
    $('#input-box').show();

    var reqStr = "/buy";

    $.ajax({
        type: "POST",
        url: reqStr,

        data: JSON.stringify({
            productId: id,
            adress: {
                city: $('#city').val(),
                street: $('#street').val(),
                number: $('#home').val()
            },
            bankCard: {
                number: $('#cardNumber').val(),
                cvv2: $('#cvv2').val(),
                valid: $('#cardDate').val()
            }
        }),

        success: function (result) {
            if (result === "NULL") confirm("Incorrect data");
            else {
                $('#input_box').hide();

                var resultObj = JSON.parse(result);

                var ticketStr = 'Your ticket is: ' + resultObj['id'] + '<br>' + 'Product(id = ' +
                    resultObj['productID'] + ') will be delivered to ' + resultObj.address.city +
                    ', ' + resultObj.address.street + ' ' + resultObj.address.number +
                    '<br>Have nice day!';

                $('#modalText1').html(ticketStr);

                $('#modal1').modal('open');

                $('#input_box').hide();
                $('#productList').show();
            }
        }
    });
}

function toAddProduct(){
  $('#productList').hide();
  $('#addProduct').show();
}

function getProducts(){
  $.ajax({
    url : "/map",
    type : "GET",

        success: function (result) {
            if (result !== "NULL" && result !== "") {
                productList = JSON.parse(result);

                var map = myMap("googleMap", 8);

        $('#row-box').html("");

        for(var key in productList){

          var arr = productList[key].imagePaths[0].split("/");
          arr.splice(0, 2);
          var imageLink = arr.join("/");

          $('#row-box').html($('#row-box').html() + '<div class="col l4">' +
          '<div class=" product-box" style="background-image: url(' + '/static/' + imageLink + ');">' +
          '<h5 class="product-name">' +
          productList[key].name +
          '</h5>' +
          '<button class="btn waves-effect waves-light send_btn product-btn" type="submit" onclick="buyWnd(' + key + ')" name="action">Buy</button>' +
          '</div>' +
          '</div>');

                    addMarkerToMap(map, productList[key]);
                }
            }
        }
    });
}

function buyWnd(index) {
    $('#productList').hide();
    $('#input_box').show();
    $('#productName').html(productList[index].name);

  var arr = productList[index].imagePaths[0].split("/");
  arr.splice(0, 2);
  var imageLink = arr.join("/");

  $('#productImg').html(
    '<div class="productImg" style="background-image: url(' + '/static/' + imageLink + ');"></div>'
  );

  $('#buyBtnBox').html(
    '<button class="btn waves-effect waves-light send_btn" type="submit" onclick="buy(' + productList[index].id + ')" name="action">Submit' +
      '<i class="material-icons right">send</i>' +
    '</button>'
  );

    addMarkerToMap(myMap("googleMapForBuy", 12), productList[index]);
}

function myMap(mapId, mapZoom) {
    var mapProp = {
        center: new google.maps.LatLng(50.427994, 30.484166),
        zoom: mapZoom,
    };

    return new google.maps.Map(document.getElementById(mapId), mapProp);
}

function addMarkerToMap(map, product) {
    var myLatlng = new google.maps.LatLng(parseFloat((product.coordinates.lat).toFixed(6)), parseFloat((product.coordinates.lng).toFixed(6)));

    // create a marker
    var marker = new google.maps.Marker({
        position: myLatlng,
        title: product.name
    });

    // place a marker
    marker.setMap(map);

    // create info window above the marker
    var infowindow = new google.maps.InfoWindow({
        content: product.name
    });

    // place window
    infowindow.open(map, marker);
}

function goToRegister(){
  $('#addProduct').hide();
  $('#loginContainer').show();
  $('#buttons-login').hide();
  $('#productList').hide();
  $('#input_box').hide();
  $('#registerPart').show();
}

function toLogin(){
  $('#addProduct').hide();
  $('#loginContainer').show();
  $('#buttons-login').show();
  $('#registerPart').hide();
  $('#productList').hide();
  $('#input_box').hide();
}

function login() {
    $.ajax({
        type: 'POST',
        url: "/login",
        data: JSON.stringify({
            name: $('#username').val(),
            pass: $('#password').val()
        }),
        success: function (result) {
            if (result != "FAILED") {
                result = JSON.parse(result);
                $('#modalText').html(result.name + ", welcome to our store!");
                $('#signBtns').hide();
                $('#usernameTop').html(result.name).show();
                $('#modal2').modal('open');
                $('#loginContainer').hide();
                $('#userButtons').show();
                $('#productList').show();
                $('#userBoxName').html('Username: ' + result.name);
                $('#userBoxMail').html('Email: ' + result.email);
            } else {
                $('#modalText').html("Invalid login or pass");
                $('#modal2').modal('open');
            }
        }
    });
}

function register() {
    console.log($('#username').val());
    $.ajax({
        type: 'POST',
        url: "/register",
        data: JSON.stringify({
            name: $('#username').val(),
            pass: $('#password').val(),
            email: $('#email').val()
        }),
        success: function (result) {
            if (result == 'OK') {
                $('#modalText').html("OK. Please, back to login page and sign in.");
                $('#modal2').modal('open');
            } else {
                $('#modalText').html(result);
                $('#modal2').modal('open');
            }
        }
    });
}

function logout() {
    $.ajax({
        type: "GET",
        url: "/logout",
        success: function () {
            $('#modalText').html("Bye!");
            $('#modal2').modal('open');
            toMain();
            $('#usernameTop').hide();
            $('#signBtns').show();
            $('#userButtons').hide();

        }
    });
}

function toUserBox() {
    $('#userBox').show();
    $('#loginContainer').hide();
    $('#registerPart').hide();
    $('#productList').hide();
    $('#input_box').hide();
    $.ajax({
        type: 'GET',
        url: "/tickets",
        success: function (result) {
            if (result !== "FAILED") {
                var ticketsArr = JSON.parse(result);

                $('#ticketList').html('');

                for (var key in ticketsArr) {
                    $('#ticketList').html($('#ticketList').html() +
                        '<hr>' +
                        '<h5>Id: ' + ticketsArr[key].id + '</h5>' +
                        '<h5>Id: ' + ticketsArr[key].product + '</h5>'
                    );
                }
            } else {
                $('#ticketList').html('<p>No tickets yet</p>');
            }
        }
    });
}

function toMain() {
    $('#userBox').hide();
    $('#loginContainer').hide();
    $('#registerPart').hide();
    $('#productList').show();
    $('#input_box').hide();
    $('#addProduct').hide();
    $('#addProductContainer').hide();
}

let lat, lng, myLatLng;
function addProductWindow() {
    $('#userBox').hide();
    $('#loginContainer').hide();
    $('#registerPart').hide();
    $('#productList').hide();
    $('#input_box').hide();
    $('#addProductContainer').show();

    // add map with listener
    let map = myMap("googleMapForAddProduct", 8);
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

getProducts();
