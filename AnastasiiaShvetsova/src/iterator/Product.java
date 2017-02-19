package iterator;

/**
 * Created by Nastia on 09.02.17.
 */
public class Product {
    private String name;
    private int price;

    public Product(String name, int price){
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString(){
        return String.format("Product name - %s, Product price - %d", name,price);
    }
}
