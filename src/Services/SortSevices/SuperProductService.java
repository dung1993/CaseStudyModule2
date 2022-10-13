package src.Services.SortSevices;

import src.RawInfo.Product;

import java.util.List;

public interface SuperProductService {
    List<Product> findAllProducts();

    void addProduct(Product newProduct);

    void editProduct(Product newProduct);

    void removeProduct(long idProduct);

    List<Product> findProductByNameProduct(String name);

    boolean exitsById(long idProduct);

    Product checkId(long idProduct);

    void updateAmount(long idProduct, int amount);
}
