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
    public void addListOrder(ListOrder listOrder) {

    }

    @Override
    public void update(int idOrder, double price, double grandTotal) {

    }

    @Override
    public ListOrder getListOrderById(int id) {
        return null;
    }
}
