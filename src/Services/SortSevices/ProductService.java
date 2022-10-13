package src.Services.SortSevices;

import src.RawInfo.Product;
import src.Utils.CSVUtil;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements SuperProductService{

    public final static String Path = "D:\\CaseStudyModule2\\data\\products.csv";
    private static ProductService instanceProduct;

    public static ProductService instanceProduct(){
        if (instanceProduct == null){
            instanceProduct = new ProductService();
        }
        return instanceProduct;
    }

    public ProductService(){}
    @Override
    public List<Product> findAllProducts() {
        List<Product> products = new ArrayList<>();
        List<String> records = CSVUtil.read(Path);
        for (String record : records){
            products.add(Product.parseProduct(record));
        }
        return products;
    }

    @Override
    public void addProduct(Product newProduct) {
        List<Product> products = new ArrayList<>();
        products.add(newProduct);
        CSVUtil.write(Path,products);
    }

    @Override
    public void editProduct(Product newProduct) {
        List<Product> products = findAllProducts();
        for (Product oldProduct: products) {
            if(oldProduct.getIdProduct() == newProduct.getIdProduct()){
                String name = newProduct.getNameProduct();
                if (name != null && !name.isEmpty()){
                    oldProduct.setNameProduct(newProduct.getNameProduct());
                }
                int amount = newProduct.getAmount();
                if (amount != 0){
                    oldProduct.setAmount(amount);
                }
                double price = newProduct.getAmount();
                if (price != 0){
                    oldProduct.setPrice(price);
                }
                CSVUtil.write(Path,products);
                break;
            }
        }
    }

    @Override
    public void removeProduct(long idProduct) {
        List<Product> products = findAllProducts();
        products.removeIf(id -> id.getIdProduct()== idProduct);
        CSVUtil.write(Path,products);
    }

    @Override
    public List<Product> findProductByNameProduct(String name) {
        List<Product> products = findAllProducts();
        List<Product> listFind = new ArrayList<>();
        if (name != null){
            for (Product oldProduct : products){
                if(oldProduct.getNameProduct().toLowerCase().contains(name)){
                    listFind.add(oldProduct);
                }
            }
        }
        return listFind;
    }

    @Override
    public boolean exitsById(long idProduct) {
        return checkId(idProduct) != null;
    }

    @Override
    public Product checkId(long idProduct) {
        List<Product> products = findAllProducts();
        for (Product product: products) {
            if (product.getIdProduct() == idProduct){
                return product;
            }
        }
        return null;
    }

    @Override
    public void updateAmount(long idProduct, int amount) {
        List<Product> products = findAllProducts();
        for (Product oldProduct: products) {
            if (oldProduct.getIdProduct() == idProduct){
                int oldAmount = oldProduct.getAmount();
                if (oldAmount >= amount){
                    oldProduct.setAmount(oldAmount - amount);
                    CSVUtil.write(Path,products);
                    break;
                }
            }
        }
    }
}
