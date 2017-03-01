
$(document).ready(function(){
    // the "href" attribute of .modal-trigger must specify the modal ID that wants to be triggered
    $('.modal').modal();
  });

function buy(){
  let reqStr = "http://localhost:8000/buy?" +
              "productId=" + $('#product_id').val() + "&" +
              "city=" + $('#city').val() + "&" +
              "street=" + $('#street').val() + "&" +
              "number=" + $('#home').val() + "&" +
              "bancCardNumber=" + $('#cardNumber').val() + "&" +
              "cvv2=" + $('#cvv2').val() + "&" +
              "cardDate=" + $('#cardDate').val();
  //alert(reqStr);

  $.ajax({
    type: "POST",
    url:reqStr,

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
