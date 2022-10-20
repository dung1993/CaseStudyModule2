package src.RawInfo;

import java.time.Instant;

public class Product {
    private Long idProduct;
    private String nameProduct;
    private double price;

    private int amount;


    public Product() {
    }

    public Product(Long idProduct, String nameProduct, double price, int amount) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.amount = amount;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public Long getIdProduct() {
        return idProduct;
    }


    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(){
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s",
                idProduct,
                nameProduct,
                price,
                amount
                );
    }

    public static Product parseProduct(String myProduct){
        String[] array = myProduct.split(",");
        Product product = new Product();
        product.setIdProduct(Long.parseLong(array[0]));
        product.setNameProduct(array[1]);
        product.setPrice(Double.parseDouble(array[2]));
        product.setAmount(Integer.parseInt(array[3]));
        return product;
    }
}
