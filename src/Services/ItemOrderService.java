package src.Services;

import src.RawInfo.ListOrder;
import src.Utils.CSVUtil;

import java.util.ArrayList;
import java.util.List;

public class ItemOrderService implements SuperListOrderService{
    private final static String Path = "data\\ListOrder.csv";
    private static ItemOrderService instanceListOrder;

    public ItemOrderService(){}

    public static ItemOrderService getInstanceListOrder(){
        if (instanceListOrder == null){
            instanceListOrder = new ItemOrderService();
        }
        return instanceListOrder;
    }



    @Override
    public List<ListOrder> findAllListOrder() {
        List<ListOrder> list = new ArrayList<>();
        List<String> records = CSVUtil.read(Path);
        for (String record: records) {
          list.add(ListOrder.parseListOrder(record));
        }
        return list;
    }

    @Override
    public void addListOrder(ListOrder newListOrder) {
        List<ListOrder> list = findAllListOrder();
        list.add(newListOrder);
        CSVUtil.write(Path,list);
    }



    @Override
    public void update(Long idOrder, double price, double grandTotal) {
        List<ListOrder> list = findAllListOrder();
        for (ListOrder listOrder : list){
            if (listOrder.getIdListOrder().equals(idOrder)){
                if (listOrder.getPrice() == price){
                    listOrder.setGrandTotal(grandTotal);
                    CSVUtil.write(Path,list);
                    break;
                }
            }
        }
    }

    @Override
    public ListOrder getListOrderById(long id) {
        List<ListOrder> list = findAllListOrder();
        for (ListOrder listOrder : list){
            if (listOrder.getIdListOrder().equals(id)){
                return listOrder;
            }
        }
        return null;
    }
}
