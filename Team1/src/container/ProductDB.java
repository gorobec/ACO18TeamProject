package container;

import container.IDB.IDataBase;
import model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Игорь on 19.02.2017.
 */
public class ProductDB implements IDataBase<Product> {
    private List<Product> products = new ArrayList<>();

    public ProductDB() {
    }

    public ProductDB(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean add(Product product) {
        products.add(product);
        return true;
    }

    @Override
    public Product remove(int id) {
        Product product = products.get(id);
        products.remove(product);
        return product;
    }

    @Override
    public Product get(int id) {
        return products
                .stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
