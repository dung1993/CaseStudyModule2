package src.RawInfo;

import java.time.Instant;

public class Product {
    private long idProduct;
    private String nameProduct;
    private double price;

    private int amount;

    private Instant createAt;

    private Instant updateAt;

    public Product() {
    }

    public Product(long idProduct, String nameProduct, double price, int amount, Instant createAt, Instant updateAt) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.amount = amount;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Instant getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Instant createAt) {
        this.createAt = createAt;
    }

    public Instant getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Instant updateAt) {
        this.updateAt = updateAt;
    }

    public long getIdProduct() {
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
        return String.format("%s,%s,5s,%s,%s,%s",
                idProduct,
                nameProduct,
                price,
                amount,
                createAt,
                updateAt);
    }

    public static Product parseProduct(String myProduct){
        String[] array = myProduct.split(",");
        Product product = new Product();
        product.setIdProduct(Long.parseLong(array[0]));
        product.setNameProduct(array[1]);
        product.setPrice(Double.parseDouble(array[2]));
        product.setAmount(Integer.parseInt(array[3]));
        product.setCreateAt(Instant.parse(array[4]));
        product.setUpdateAt(Instant.parse(array[5]));
        return product;
    }
}
