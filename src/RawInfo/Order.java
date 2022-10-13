package src.RawInfo;

import java.time.Instant;

public class Order {
    private long idOrder;
    private String fullName;
    private String mobile;
    private double grandTotal;

    private Instant timeCreateOrder;

    public Order() {
    }

    public Order(long idOrder, String fullName, String mobile, double grandTotal, Instant timeCreateOrder) {
        this.idOrder = idOrder;
        this.fullName = fullName;
        this.mobile = mobile;
        this.grandTotal = grandTotal;
        this.timeCreateOrder = timeCreateOrder;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
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

    public Instant getTimeCreateOrder() {
        return timeCreateOrder;
    }

    public void setTimeCreateOrder(Instant timeCreateOrder) {
        this.timeCreateOrder = timeCreateOrder;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s",idOrder,fullName,mobile,grandTotal,timeCreateOrder);
    }

    public static Order parseOrder(String myOrder){
        Order order =new Order();
        String[] array = myOrder.split(",");
        order.setIdOrder(Long.parseLong(array[0]));
        order.setFullName(array[1]);
        order.setMobile(array[2]);
        order.setGrandTotal(Double.parseDouble(array[3]));
        order.setTimeCreateOrder(Instant.parse(array[4]));
        return order;
    }
}
