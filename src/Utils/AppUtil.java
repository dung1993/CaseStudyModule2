package src.Utils;

import java.text.DecimalFormat;
import java.util.Scanner;

public class AppUtil {
    static Scanner scanner = new Scanner(System.in);

    public static int reChose(int min, int max){
        int option;
        do{
            try{
                option = Integer.parseInt(scanner.nextLine());
                if(option > max || option < min){
                    System.out.println(" Util invalid! retry your chose");
                    System.out.print("->  ");
                    continue;
                }
                break;
            }catch (Exception e){
                System.out.println("Syntax Error!, Retry Input");
                System.out.print("->  ");
            }

        }while (true);
        return option;
    }
    public static int retryParseInt(){
        int result;
        do{
            try {
                result = Integer.parseInt((scanner.nextLine()));
                return result;
            }catch (Exception e){
                System.out.println("Syntax Error!, Retry Input");
                System.out.print("->  ");
            }
        }while (true);
    }
    public static long retryParseLong(){
        long result;
        do{
            try{
                result = Long.parseLong( scanner.nextLine());
                return result;
            }catch (Exception e){
                System.out.println("Syntax Error!, Retry Input");
                System.out.print("->  ");
            }
        }while (true);
    }
    public static String retryString(String fieldName){
        String result;
        System.out.println("->  ");
        while ((result = scanner.nextLine()).isEmpty()){
            System.out.printf("%s,Please not empty\n",fieldName);
            System.out.print("->  ");
        }
        return result;
    }

    public static double retryParseDouble(){
        double result;
        do {
            try {
                result = Double.parseDouble(scanner.nextLine());
                return result;
            }catch (Exception e){
                System.out.println("Syntax Error!, Retry Input, Please trust only number");
                System.out.print("->  ");
            }
        }while (true);
    }

    public static String doubleToVND(double value){
        String patternVND = ",###đ";
        DecimalFormat decimalFormat = new DecimalFormat(patternVND);
        return decimalFormat.format(value);
    }

    public static void exit(){
        System.out.println("Good bye! See you late");
        System.exit(5);
    }
}
