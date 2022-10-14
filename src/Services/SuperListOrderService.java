package src.Services;

import src.RawInfo.ListOrder;

import java.util.List;

public interface SuperListOrderService {
    List<ListOrder> findAllListOrder();
    void addListOrder(ListOrder listOrder);
    void update(int idOrder, double price, double grandTotal);
    ListOrder getListOrderById(int id);
}
