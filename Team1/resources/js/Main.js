
$(document).ready(function(){
    $('.modal').modal();
  });

var productList;

function buy(id){
  $('#input-box').show();

  var reqStr = "http://localhost:8000/buy";

  $.ajax({
    type : "POST",
    url : reqStr,

    data : JSON.stringify({
      productId : id,
      adress:{
        city : $('#city').val(),
        street : $('#street').val(),
        number : $('#home').val()
      },
      bankCard: {
        number : $('#cardNumber').val(),
        cvv2 : $('#cvv2').val(),
        valid : $('#cardDate').val()
      }
    }),

    success: function(result) {
      if(result === "NULL") confirm("Incorrect data");
      else{
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

function getProducts(){
  $.ajax({
    url : "http://localhost:8000/map",
    type : "GET",

    success : function(result){
      if(result !== "NULL" && result !== ""){
        productList = JSON.parse(result);

        var map = myMap("googleMap", 8);

        for(var key in productList){

          $('#row-box').html($('#row-box').html() + '<div class="col l4">' +
          '<div class=" product-box">' +
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

function buyWnd(index){
  $('#productList').hide();
  $('#input_box').show();
  $('#productName').html(productList[index].name);

  $('#buyBtnBox').html(
    '<button class="btn waves-effect waves-light send_btn" type="submit" onclick="buy(' + productList[index].id + ')" name="action">Submit' +
      '<i class="material-icons right">send</i>' +
    '</button>'
  );

  addMarkerToMap(myMap("googleMapForBuy", 12), productList[index]);
}

function myMap(mapId, mapZoom){
  var mapProp = {
    center: new google.maps.LatLng(50.427994, 30.484166),
    zoom: mapZoom,
  };

  return new google.maps.Map(document.getElementById(mapId), mapProp);
}

function addMarkerToMap(map, product){
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
  $('#loginContainer').show();
  $('#buttons-login').hide();
  $('#productList').hide();
  $('#input_box').hide();
  $('#registerPart').show();
}

function toLogin(){
  $('#loginContainer').show();
  $('#buttons-login').show();
  $('#registerPart').hide();
  $('#productList').hide();
  $('#input_box').hide();
}

function login() {
    $.ajax({
        type: 'POST',
        url: "http://localhost:8000/login",
        data: JSON.stringify({
            name: $('#username').val(),
            pass: $('#password').val()
        }),
        success: function (result) {
            if (result != "FAILED") {
                $('#modalText').html(result + ", welcome to our store!");
                $('#signBtns').hide();
                $('#usernameTop').html(result);
                $('#modal2').modal('open');
                $('#loginContainer').hide();
                $('#productList').show();
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
        url: "http://localhost:8000/register",
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

getProducts();
