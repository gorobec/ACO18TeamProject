package com.bestBuy.model;


public class Product {

    private String name;
    private int id;
    private double price;
    private String[] imageUrl;
    private String[] imageSrc;
    private String description;
    private boolean isPopular;

    public Product() {};

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public boolean getIsPopular() {
        return isPopular;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setImageSource(String[] imageSource) {
        this.imageUrl = imageSource;
    }

    public void addImageSource(String imageSource) {
        String[] arrayImages = new String[imageUrl.length+1];
        arrayImages[arrayImages.length] = imageSource;
        this.imageUrl = arrayImages;
    }

    public String[] getImageSource() {
        return imageSrc;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (Double.compare(product.price, price) != 0) return false;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        result = 31 * result + id;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public void setImageUrl(String[] base64) {
        this.imageUrl = base64;
    }

}
