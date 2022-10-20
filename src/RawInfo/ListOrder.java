package src.RawInfo;

import java.util.List;

public class ListOrder  {
    private Long idListOrder;

    private Long idOrder;
    private double price;
    private int amount;
    private Long idProduct;
    private String nameProduct;
    private double total;
    private double grandTotal;


    public ListOrder() {
    }


    public ListOrder(Long idListOrder, double price, int amount, Long idProduct, String nameProduct, double total, double grandTotal, Long idOrder) {
        this.idListOrder = idListOrder;
        this.price = price;
        this.amount = amount;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.total = total;
        this.grandTotal = grandTotal;
        this.idOrder = idOrder;
    }

    public ListOrder(Long idOrder, double price, int amount, Long idProduct, String nameProduct, double total, double grandTotal) {
        this.idOrder = idOrder;
        this.price = price;
        this.amount = amount;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.total = total;
        this.grandTotal = grandTotal;
    }

    public Long getIdListOrder() {
        return idListOrder;
    }

    public void setIdListOrder(Long idListOrder) {
        this.idListOrder = idListOrder;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s",
                idListOrder,
                price,
                amount,
                idProduct,
                nameProduct,
                total,
                grandTotal,
                idOrder
               );
    }

    public static ListOrder parseListOrder(String myListOrder){
        ListOrder listOrder = new ListOrder();
        String[] array = myListOrder.split(",");
        //1666097202,7000000.0,2,1666086186,Screen Samsung sm1000,1.4E7,0.0,1666097156

        listOrder.setIdListOrder(Long.parseLong(array[0]));
        listOrder.setPrice(Double.parseDouble(array[1]));
        listOrder.setAmount(Integer.parseInt(array[2]));
        listOrder.setIdProduct(Long.parseLong(array[3]));

        listOrder.setNameProduct(array[4]);
        listOrder.setTotal(Double.parseDouble(array[5]));
        listOrder.setGrandTotal(Double.parseDouble(array[6]));
        listOrder.setIdOrder(Long.parseLong(array[7]));



        return listOrder;
    }
}

