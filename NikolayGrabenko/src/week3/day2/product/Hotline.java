package week3.day2.product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*Создать класс Hotline (с полем List<Product> products), и методом addProducts (Iterator iterator),
который будет добавлять продукты (которые входят в класс либо Rozetka либо Repka) в свой список продуктов.
*/

public class Hotline {

    private List<Product> products = new ArrayList<>();

    public boolean addProducts(Iterator iterator) {
        while (iterator.hasNext()) {
            products.add((Product) iterator.next());
        }
        return true;
    }

    public String showAllProducts (){
        StringBuilder sb = new StringBuilder();
        for (Product product: products){
            if (product != null){
               sb.append(product.asString()).append("\n");
            }
        }
    return sb.toString();
    }
}
