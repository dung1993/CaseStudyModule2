package src.Services.SortSevices;

import src.RawInfo.Product;

import java.util.Comparator;

public class SortByNameASC implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getNameProduct().compareTo(o2.getNameProduct());
    }
}
