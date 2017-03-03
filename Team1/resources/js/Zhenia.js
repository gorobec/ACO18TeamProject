
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

          $('#modalText').html(ticketStr);

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

        for(var key in productList){
          $('#row-box').html($('#row-box').html() + '<div class="col l4" class="product-box">' +
          '<p class="product-name">' +
          productList[key].name +
          '</p>' +
          '<button class="btn waves-effect waves-light send_btn product-btn" type="submit" onclick="buyWnd(' + key + ')" name="action">Buy</button>' +
          '</div>');
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
}

getProducts();

// function getProductById(){
//   $.ajax(
//     url : "/get-product"
//   )
// }
