package src.CaseModule2;

public class ListOrder {
    private int idListOrder;
    private double price;
    private int amount;
    private int idProduct;
    private String nameProduct;
    private double total;
    private double grandTotal;
    private int idOrder;

    public ListOrder() {
    }

    public ListOrder(int idListOrder, double price, int amount, int idProduct, String nameProduct, double total, double grandTotal, int idOrder) {
        this.idListOrder = idListOrder;
        this.price = price;
        this.amount = amount;
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.total = total;
        this.grandTotal = grandTotal;
        this.idOrder = idOrder;
    }

    public int getIdListOrder() {
        return idListOrder;
    }

    public void setIdListOrder(int idListOrder) {
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

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
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

        listOrder.setIdListOrder(Integer.parseInt(array[0]));
        listOrder.setPrice(Double.parseDouble(array[1]));
        listOrder.setAmount(Integer.parseInt(array[2]));
        listOrder.setIdProduct(Integer.parseInt(array[3]));
        listOrder.setNameProduct(array[4]);
        listOrder.setTotal(Double.parseDouble(array[5]));
        listOrder.setGrandTotal(Double.parseDouble(array[6]));
        listOrder.setIdOrder(Integer.parseInt(array[7]));

        return listOrder;
    }
}

