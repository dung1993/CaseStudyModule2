package src.Services;

import src.RawInfo.Order;
import src.Utils.CSVUtil;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderService implements SuperOrderService{
    public final static String Path = "D:\\CaseStudyModule2\\data\\Order.csv";
    private static OrderService instanceOrder;

    public OrderService(){}

    public static OrderService getInstanceOrder(){
        if (instanceOrder == null){
            instanceOrder = new OrderService();
        }
        return instanceOrder;
    }

    public List<Order> findAllOrder(){
        List<Order> orders = new ArrayList<>();
        List<String> records = CSVUtil.read(Path);
        for (String record : records){
            orders.add(Order.parseOrder(record));
        }
        return orders;
    }

    @Override
    public void  add(Order newOrder){
        List<Order> orders = findAllOrder();
        newOrder.setTimeCreateOrder(Instant.now());
        orders.add(newOrder);
        CSVUtil.write(Path,orders);

    }

    @Override
    public void editOrder(Order newOrder) {
        List<Order> orders = findAllOrder();
        for (Order oldOrder : orders){
            if (oldOrder.getIdOrder() == newOrder.getIdOrder()){
                String fullName = newOrder.getFullName();
                if (fullName!=null && !fullName.isEmpty()){
                    oldOrder.setFullName(fullName);
                }
                String mobile = newOrder.getMobile();
                if (mobile!=null && !mobile.isEmpty()){
                    oldOrder.setMobile(mobile);
                }
            }
        }
    }

    @Override
    public void editOrder() {
        List<Order> orders = findAllOrder();
        CSVUtil.write(Path,orders);
    }

    @Override
    public Order findOrderById(long idOrder) {
        List<Order> orders = findAllOrder();
        for (Order order: orders) {
            if (order.getIdOrder() == idOrder){
                return order;
            }
        }
        return null;
    }

    @Override
    public boolean exitsOrderById(long idOrder) {
        return findOrderById(idOrder) != null;
    }

    @Override
    public List<Order> findOrderByUserId(long idOrder) {
        List<Order> order = findAllOrder();
        for (Order orders: findAllOrder()) {
            if (orders.getIdOrder() == idOrder){
                order.add(orders);
            }
            return order;
        }
        return null;
    }





}
