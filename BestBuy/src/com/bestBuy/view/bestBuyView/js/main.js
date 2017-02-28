$(document).ready(function() {
    <script id="productTmpl" type="text/x-jquery-tmpl">
            <div class="col-md-3 product-left">
                <div class="product-main simpleCart_shelfItem">
                    <a href="single.html" class="mask"><img class="img-responsive zoom-img" src="${imageUrl}" alt="" /></a>
                    <div class="product-bottom">
                        <h3>${name}</h3>
                        <p>Explore Now</p>
                        <h4><a class="item_add" href="#"><i></i></a> <span class="item_price">$ ${price}</span></h4>
                    </div>
                    <div class="srch">
                        <span>-50%</span>
                    </div>
                </div>
            </div>
    </script>
    function () {
                $('#movieTmpl').tmpl(dataItems).appendTo('#movieListBag');
            }

	});