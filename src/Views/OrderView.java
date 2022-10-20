package src.Views;

import src.Menu.Menu;
import src.RawInfo.ListOrder;
import src.RawInfo.Order;
import src.RawInfo.Product;
import src.Services.ItemOrderService;
import src.Services.OrderService;
import src.Services.ProductService;
import src.Utils.AppUtil;
import src.Utils.DateUtil;
import src.Utils.InstantUtil;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderView {
    public List<Order> orders;
    private static OrderService orderService = new OrderService();
    private static ProductService productService = new ProductService();
    private static ItemOrderService itemOrderService = new ItemOrderService();

    private static ProductView productView = new ProductView();

    private static final Scanner scanner = new Scanner(System.in);

    public OrderView(){
        orderService =OrderService.getInstanceOrder();
        productService = ProductService.getInstanceProduct();
        itemOrderService = ItemOrderService.getInstanceListOrder();
    }

    public static void addOrder(){
        try {
            itemOrderService.findAllListOrder();
            long idOrder = System.currentTimeMillis()/1000;
            System.out.println("Enter the name of the person ordering: (EX: Petter)");
            System.out.print("==>  ");
            String fullName;
            while (!DateUtil.isNameInvalid(fullName = scanner.nextLine())){
                System.out.println("Name" + fullName + " Incorrect format please try again " + " (Names must be capitalized and not accented)");
                System.out.print("==>  ");
            }
            System.out.println("Enter your mobile phone: ");
            System.out.print("==>  ");
            String mobile = scanner.nextLine();
            while (!DateUtil.isPhoneInvalid(mobile)|| mobile.trim().isEmpty()){
                System.out.println("Mobile" + mobile + " Incorrect format please try again" );
                System.out.println(" Enter your mobile phone( 10 to 11 number and start at number 0)");
                System.out.print("==>  ");
                mobile = scanner.nextLine();
            }

            Order order = new Order(idOrder,fullName,mobile,Instant.now());
            List<ListOrder> listOrders = addItemOrder(idOrder);
            for (ListOrder listOrder : listOrders) {
                itemOrderService.addListOrder(listOrder);
            }

            orderService.add(order);
            confirmOrder(order);
        }catch (Exception e){
            System.out.println("Incorrect format please try again!");
        }
    }

    public static void confirmOrder(Order order){
        try {
            boolean flag = true;
            String choice;
            System.out.println();
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘                    ⤿Order⤾                   ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘                 1. Print Bill                ⥘⥘");
            System.out.println("⥘⥘                 2. Return                    ⥘⥘");
            System.out.println("⥘⥘                 0. Exit                      ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("Select your choice:");
            System.out.print("==>  ");
            do {
                choice = scanner.nextLine();
                switch (choice){
                    case "1":
                        showPayInfoAdmin(order);
                        break;
                    case "2":
                        Menu.menuManageOrder();
                        break;
                    case "3":
                        System.exit(5);
                        break;
                    default:
                        System.out.println("Is wrong choice! Please choice again:");
                        System.out.print("==>  ");
                        flag = false;
                }
            }while (!flag);
        }catch (Exception e){
            e.getStackTrace();
        }
    }
    public static List<ListOrder> addItemOrder(Long id){
        List<ListOrder> listOrders = new ArrayList<>();
        productView.showProductList();
        System.out.println(" Input amount of product you need buy:");
        System.out.print("==>  ");
        int choice = Integer.parseInt(scanner.nextLine());
        while (choice < 0 ){
            System.out.println("Amount is Wrong! Please input again(not less than 0)");
            System.out.print("==>  ");
            choice = Integer.parseInt(scanner.nextLine());
        }
        int count = 0;
        do {
            try {
                listOrders.add( addItemOrders(id));
                count++;

            }catch (Exception e){
                System.out.println("Incorrect, please try again!");
            }
        }while (count < choice);
        return listOrders;
    }

    public static ListOrder addItemOrders(Long idOrder){
        do {
            try {
                itemOrderService.findAllListOrder();
                productView.showProductList();
                long id = System.currentTimeMillis()/1000;
                System.out.println("Input id product you need by:");
                System.out.print("==>  ");
                long idProduct = Long.parseLong(scanner.nextLine());
                while (!productService.exitsById(idProduct)){
                    System.out.println("idProduct does not exist! Please input again");
                    System.out.print("==>  ");
                    idProduct = Long.parseLong(scanner.nextLine());
                }
                Product product = productService.checkId(idProduct);
                double price = product.getPrice();
                System.out.println("Input amount of product you need by:");
                System.out.print("==>  ");
                int amount = Integer.parseInt(scanner.nextLine());
                while (!checkAmountProduct(product, amount)){
                    System.out.println("Amount is Wrong! Please input again(not less than 0)");
                    System.out.print("==>  ");
                    amount = Integer.parseInt(scanner.nextLine());
                    if (product.getAmount() == 0){
                        System.out.println("Product is out of stock");
                        int choice;
                        do {
                            System.out.println(" Press 0 to return to product manager");
                            choice = AppUtil.retryParseInt();
                        }while (choice != 0);
                        Menu.menuManageOrder();
                    }
                }
                String nameProduct = product.getNameProduct();
                double total = amount * price;
                double grandTotal = 0.0;
                ListOrder listOrder = new ListOrder(idOrder,price,amount,idProduct,nameProduct,total,grandTotal);
                Long idListOrder = System.currentTimeMillis()/1000;
                listOrder.setIdListOrder(idListOrder);
                productService.updateAmount(idProduct, amount);
                return listOrder;
            }catch (Exception e){
                System.out.println("Incorrect, please try again!");
            }
        }while (true);
    }

    private static boolean checkAmountProduct(Product product, int amount) {
        if (amount <= product.getAmount()){
            return true;
        }
        return false;
    }

//    public static void main(String[] args) {
//        Order order = orderService.findOrderById(1666097625L);
//        OrderView.showPayInfo(order);
//
//    }
    public static void showPayInfo(Order order){
        try {
            System.out.println();
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘                                ⤿Bill⤾                                    ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.printf("⥘⥘%-20s \t%-30s %20s ⥘⥘\n","Name          | ",order.getFullName(),"");
            System.out.printf("⥘⥘%-20s \t%-30s %20s ⥘⥘\n","Mobile        | ",order.getMobile(),"");
            System.out.printf("⥘⥘%-20s \t%-30s %20s ⥘⥘\n","CreateTime    | ", InstantUtil.instantToString(order.getTimeCreateOrder()),"");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.printf("⥘⥘%-4s │\t%-25s │\t%-15s │\t%-15s ⥘⥘\n", "Id","Product Name","Price","Amount");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            List<ListOrder> listOrders = itemOrderService.findAllListOrder();
            double sum = 0;
            int count = 0;
            for (ListOrder listOrder1 : listOrders){
                if (listOrder1.getIdOrder().equals(order.getIdOrder())){
                    sum += listOrder1.getTotal();
                    count++;
                    listOrder1.setGrandTotal(sum);
                    itemOrderService.update(listOrder1.getIdOrder(), listOrder1.getPrice(), sum);
                    System.out.printf("⥘⥘%-4s │\t%-25s │\t%-15s │\t%-15s ⥘⥘ \n",
                            count,
                            listOrder1.getNameProduct(),
                            InstantUtil.doubleToVND(listOrder1.getPrice()),
                            InstantUtil.amountProduct(listOrder1.getAmount()));
                    System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
                }
            }
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.printf("⥘⥘                                        Total : %17s     ⥘⥘\n",InstantUtil.doubleToVND(sum));
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
        }catch (Exception e){
            System.out.println("Incorrect, please try again!");
        }
    }

    public static void showPayInfoAdmin(Order order){
        showPayInfo(order);
        int choice;
        do {
            System.out.println(" Press 0 to return to product manager");
            System.out.print("==>  ");
            choice = AppUtil.retryParseInt();
        }while (choice != 0 );
        Menu.menuManageOrder();
    }

    public static void showPayInfoUser(Order order) {
        showPayInfo(order);
        int choice;
        do {
            System.out.println("Press 0 to return to product manager");
            System.out.print("==>  ");
            choice = AppUtil.retryParseInt();
        } while (choice != 0);
        Menu.menuUser();
    }

    public static void showListOrder(){
        try {
            List<Order> orders = orderService.findAllOrder();
            List<ListOrder> listOrders = itemOrderService.findAllListOrder();
            int count = 0;
            double printTotal = 0;
            double total = 0;
            double sum = 0;
            double grandTotal = 0;
            System.out.println();
            System.out.println("\t⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚List⟚Bill⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            for (Order order: orders){
                System.out.println("\t⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
                System.out.printf("\t⥘⥘\t%-15s %-20s %-20s %-20s⥘⥘\n","Id            ",order.getIdOrder(),"Name ",order.getFullName());
                System.out.printf("\t⥘⥘\t%-20s %-47s ⥘⥘\n","PhoneNumber            ",order.getMobile());
                System.out.println("\t⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
                System.out.printf("\t⥘⥘\t%-2s │%-10s %-25s %-10s %-20s⥘⥘\n","Id","Product Name","Price","Amount","GrandTotal");
                System.out.println("\t⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
                for (ListOrder listOrder: listOrders){
                    if (listOrder.getIdOrder().equals(order.getIdOrder())){
                        count++;
                        total = listOrder.getPrice() * listOrder.getAmount();
                        System.out.printf("\t⥘⥘\t%-2s │%-10s %-25s %-10s %-20s⥘⥘\n",count,
                                listOrder.getIdOrder(),
                                InstantUtil.doubleToVND(listOrder.getPrice()),
                                InstantUtil.amountProduct(listOrder.getAmount()),
                                InstantUtil.doubleToVND(listOrder.getTotal()));
                        grandTotal += total;
                    }
                }
                printTotal += grandTotal;
                System.out.printf("\t⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚GrandTotal:%15s⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘\n\n\n",InstantUtil.doubleToVND(grandTotal));
                sum = 0;
                grandTotal = 0;
                count = 0;
            }
            System.out.println("\t\t\t\t\t\t\t⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.printf("\t\t\t\t\t\t\t⥘⥘             printTotal: %20s         ⥘⥘\n",InstantUtil.doubleToVND(printTotal));
            System.out.println("\t\t\t\t\t\t\t⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘\n");
            int choice;
            do {
                System.out.println(" Press 0 to return to product manager");
                System.out.print("==>  ");
                choice = AppUtil.retryParseInt();
            }while (choice != 0);
            Menu.menuManageOrder();
        }catch (Exception e){
            e.getStackTrace();
        }
    }

    public static void addOrderUser(){
        try {
            itemOrderService.findAllListOrder();
            Long idOrder = System.currentTimeMillis()/1000;
            System.out.println("Enter the name of the person ordering: (EX: Petter)");
            System.out.print("==>  ");
            String fullName;
            while (!DateUtil.isNameInvalid(fullName = scanner.nextLine())){
                System.out.println("Name" + fullName + " Incorrect format please try again " + " (Names must be capitalized and not accented)");
                System.out.print("==>  ");
            }
            System.out.println("Enter your mobile phone: ");
            System.out.print("==>  ");
            String mobile = scanner.nextLine();
            while (!DateUtil.isPhoneInvalid(mobile)|| mobile.trim().isEmpty()){
                System.out.println("Mobile" + mobile + " Incorrect format please try again" );
                System.out.println(" Enter your mobile phone( 10 to 11 number and start at number 0)");
                System.out.print("==>  ");
                mobile = scanner.nextLine();
            }

            Order order = new Order(idOrder,fullName,mobile,Instant.now());
            List<ListOrder> listOrders = addItemOrder(idOrder);
            for (ListOrder listOrder : listOrders) {
                itemOrderService.addListOrder(listOrder);
            }

            orderService.add(order);
            confirmOrder(order);
        }catch (Exception e){
            System.out.println("Incorrect format please try again!");
        }
    }

    public static void confirmOrderUser(Order order){
        try {
            boolean flag = true;
            String choice;
            System.out.println();
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘                    ⤿Order⤾                   ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘                 1. Print Bill                ⥘⥘");
            System.out.println("⥘⥘                 2. Return                    ⥘⥘");
            System.out.println("⥘⥘                 0. Exit                      ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("Select your choice:");
            System.out.print("==>  ");
            do {
                choice = scanner.nextLine();
                switch (choice){
                    case "1":
                        showPayInfoUser(order);
                        break;
                    case "2":
                        Menu.menuUser();
                        break;
                    case "3":
                        System.exit(5);
                        break;
                    default:
                        System.out.println("Is wrong choice! Please choice again:");
                        System.out.print("==>  ");
                        flag = false;
                }
            }while (!flag);
        }catch (Exception e){
            e.getStackTrace();
        }
    }
}
