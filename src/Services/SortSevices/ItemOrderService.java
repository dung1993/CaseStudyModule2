package src.Services.SortSevices;

import src.RawInfo.ListOrder;
import src.Utils.CSVUtil;

import java.util.ArrayList;
import java.util.List;

public class ItemOrderService implements SuperListOrderService{
    private final static String Path = "D:\\CaseStudyModule2\\data\\ListOrder.csv";


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
    public void update(int idOrder, double price, double grandTotal) {
        List<ListOrder> list = findAllListOrder();
        for (ListOrder listOrder : list){
            if (listOrder.getIdListOrder() == idOrder){
                if (listOrder.getPrice() == price){
                    listOrder.setGrandTotal(grandTotal);
                    CSVUtil.write(Path,list);
                    break;
                }
            }
        }
    }

    @Override
    public ListOrder getListOrderById(int id) {
        List<ListOrder> list = findAllListOrder();
        for (ListOrder listOrder : list){
            if (listOrder.getIdListOrder() == id){
                return listOrder;
            }
        }
        return null;
    }
}
