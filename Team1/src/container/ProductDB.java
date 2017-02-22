package container;

import model.Product;
import model.Ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Игорь on 19.02.2017.
 */
public class ProductDB implements IDataBase<Product> {
    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ProductDB() {}

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
        Product product = products.get(findProuctById(id));
        products.remove(product);
        return product;
    }


    @Override
    public Product get(int id) {
        return products.get(findProuctById(id));
    }




    @Override
    public List<Product> getAll() {
        return products;
    }


    private int findProuctById(int id){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) return i;
        }
        return -1;
    }
}
