package src.Utils;

import java.text.DecimalFormat;

public class InstantUtil {
    public static String doubleToVND(double value){
        String patternVND = "###";
        DecimalFormat decimalFormat = new DecimalFormat(patternVND);
        return decimalFormat.format(value);
    }

    public static String amountProduct(double value){
        String patternVND = "###";
        DecimalFormat decimalFormat = new DecimalFormat(patternVND);
        return decimalFormat.format(value);
    }
}
