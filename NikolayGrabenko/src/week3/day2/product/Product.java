package week3.day2.product;

/*Создать класс Product с полями: имя, цена. */

public class Product{

    private String name;
    private double price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String asString (){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Product name - %10s, product price - %6.2f ", name, price));
    return stringBuilder.toString();
    }
}
