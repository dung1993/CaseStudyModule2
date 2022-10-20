package src.Services;

import src.RawInfo.Product;

import java.util.List;

public interface SuperProductService {
    List<Product> findAllProducts();

    void addProduct(Product newProduct);

    void editProduct(Product newProduct);

    void removeProduct(Long idProduct);

    List<Product> findProductByNameProduct(String name);

    boolean exitsById(Long idProduct);

    Product checkId(Long idProduct);

    void updateAmount(Long idProduct, int amount);
}
