
$(document).ready(function(){
    $('.modal').modal();
  });

function buy(){
  var reqStr = "http://localhost:8000/buy";

  $.ajax({
    type : "POST",
    url : reqStr,

    data : JSON.stringify({
      productId : $('#product_id').val(),
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
      }
    }
  });
}

// function getProductById(){
//   $.ajax(
//     url : "/get-product"
//   )
// }
