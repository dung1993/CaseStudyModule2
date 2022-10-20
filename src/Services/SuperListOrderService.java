package src.Services;

import src.RawInfo.ListOrder;

import java.util.List;

public interface SuperListOrderService {
    List<ListOrder> findAllListOrder();
    void addListOrder(ListOrder listOrder);
    void update(Long idOrder, double price, double grandTotal);
    ListOrder getListOrderById(long id);
}
