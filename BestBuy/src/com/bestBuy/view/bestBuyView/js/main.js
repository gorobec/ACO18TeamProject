
var server_path="http://localhost:8000";
$(document).ready(function() {
				$(".simpleCart_empty").click(function() {
					$.ajax({
						type: "GET",
						url: "http://localhost:8000/clearCart",
						success: function(result) {
						console.log(result);
						location.reload(); 
						}
					 });
				});
});
var addToCart = function(idProduct){
						$.ajax({
						type: "POST",
						url: "http://localhost:8000/addProductToCart",
						data: JSON.stringify({id : idProduct}),
						success: function(result) {
						console.log(result);
						$("#resultAddToCart").html(result);
						}
					 });
}

