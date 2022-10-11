package src.CaseModule2;

public class Order {
    private int idOrder;
    private String fullName;
    private String mobile;
    private double grandTotal;

    public Order() {
    }

    public Order(int idOrder, String fullName, String mobile, double grandeTotal) {
        this.idOrder = idOrder;
        this.fullName = fullName;
        this.mobile = mobile;
        this.grandTotal = grandeTotal;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s",idOrder,fullName,mobile,grandTotal);
    }

    public static Order parseinOrder(String myOrder){
        Order order =new Order();
        String[] array = myOrder.split(",");
        order.setIdOrder(Integer.parseInt(array[0]));
        order.setFullName(array[1]);
        order.setMobile(array[2]);
        order.setGrandTotal(Double.parseDouble(array[3]));
        return order;
    }
}
