package src.Services.SortSevices;

import src.RawInfo.Product;

import java.util.Comparator;

public class SoftByNameDESC implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getNameProduct().compareTo(o1.getNameProduct());
    }
}
