To start server - run main() in OurHttpServer class.
Then you can access it using this address: localhost:8000/<YOUR_REQUEST_HERE>

Methods:
1. Register
Request form: /register&username=<name>&password=<pass>&email=<email>
Returns "OK" if everything is okay and exception message otherwise.

2. Login
Request form: /register&username=<name>&password=<pass>
Returns "OK" if everything is okay and exception message otherwise.

3. Buy
Request form: /buy?productId=<id>&city=<city>&street=<street>&house=<house>
                    &bankCardNumber=<number>&bankCardCvv2=<cvv2>&bankCardDate=<year + month in format XXXX-XX>"
Returns ticket id if OK, else "NULL"

4. GetAllProducts
Request form: /getallproducts
Returns list of products in DB