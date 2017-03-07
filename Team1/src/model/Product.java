package model;

/**
 * Created by v21k on 19.02.17.
 */
public class Product {
    private int id;
    private String name;
    private Coordinates coordinates;
    private String[] imagePaths;
    public Product() {
    }

    public Product(int id, String name, Coordinates coordinates, String[] image) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.imagePaths = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public String[] getImagePath() {
        return imagePaths;
    }

    public void setImagePath(String[] imagePath) {
        this.imagePaths = imagePath;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return id == product.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Name: %10s, id: %d\n", name, id);
    }
}
