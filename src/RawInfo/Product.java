package src.RawInfo;

public class Product {
    private int idProduct;
    private String nameProduct;
    private double price;

    private int amount;

    public Product() {
    }

    public Product(int idProduct, String nameProduct, double price, int amount) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.amount = amount;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
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
        return String.format("%s,%s,5s,%s",idProduct,nameProduct,price,amount);
    }
}
