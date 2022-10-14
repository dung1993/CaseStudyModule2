package src.Services;

import src.RawInfo.ListOrder;
import src.RawInfo.Order;

import java.util.List;

public interface SuperOrderService {
    List<Order> findAllOrder();



    void add(Order newOrder);

    void editOrder(Order newOrder);

    void editOrder();

    Order findOrderById(long idOrder);

    boolean exitsOrderById(long idOrder);

    List<Order> findOrderByUserId(long idOrder);
}
