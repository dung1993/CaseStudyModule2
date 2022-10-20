package src.Views;

import src.Menu.Menu;
import src.RawInfo.Product;
import src.Services.ProductService;
import src.Services.SortSevices.*;
import src.Utils.AppUtil;
import src.Utils.InstantUtil;

import java.util.List;
import java.util.Scanner;

public class SortView {
    public static ProductService productService = new ProductService();
    static Scanner scanner = new Scanner(System.in);

    public static void menuSort() {
        try {
            boolean flag = true;
            String choice;
            System.out.println();
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘                    ► Product Sort ◄                   ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘       1.     Soft By Id Product                       ⥘⥘");
            System.out.println("⥘⥘       2.     Soft By Name Product                     ⥘⥘");
            System.out.println("⥘⥘       3.     Soft By Price Product                    ⥘⥘");
            System.out.println("⥘⥘       0.     Return Product Manager                   ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("Select your choice:");
            System.out.print("==> ");
            do {
                choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        sortIdProduct();
                        break;
                    case "2":
                        sortName();
                        break;
                    case "3":
                        sortPrice();
                        break;
                    case "0":
                        Menu.menuManagerProduct();
                        break;
                    default:
                        System.out.println("Is wrong choice! Please choice again");
                        System.out.print("==>  ");
                        flag = false;
                }
            } while (!flag);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }



    private static void sortIdProduct() {
        try {
            boolean flag = true;
            String choice;
            System.out.println();
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘                 ► Sort By Id Product ◄                ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘       1.     Id Product Ascending                     ⥘⥘");
            System.out.println("⥘⥘       2.     Id Product Decrease                      ⥘⥘");
            System.out.println("⥘⥘       0.     Return Product Sort                      ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("Select your choice:");
            System.out.print("==> ");
            do {
                choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        sortIdASC();
                        break;
                    case "2":
                        sortIdDESC();
                        break;
                    case "0":
                        menuSort();
                        break;
                    default:
                        System.out.println("Is wrong choice! Please choice again");
                        System.out.print("==>  ");
                        flag = false;
                }
            }while (!flag);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sortIdASC() {
        List<Product> products = productService.findAllProducts();
        SortByIdProductASC sortByIdProductASC = new SortByIdProductASC();
        products.sort(sortByIdProductASC);
        showSortList(products);
        sortIdProduct();
    }

    private static void sortIdDESC() {
        List<Product> products = productService.findAllProducts();
        SortByIdProductDESC sortByIdProductDESC = new SortByIdProductDESC();
        products.sort(sortByIdProductDESC);
        showSortList(products);
        sortIdProduct();

    }

    private static void sortName() {
        try {
            boolean flag = true;
            String choice;
            System.out.println();
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘               ► Sort By Name Product ◄                ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘       1.     Name Product A-Z                         ⥘⥘");
            System.out.println("⥘⥘       2.     Name Product Z-A                         ⥘⥘");
            System.out.println("⥘⥘       0.     Return Product Sort                      ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("Select your choice:");
            System.out.print("==> ");
            do {
                choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        sortNameASC();
                        break;
                    case "2":
                        sortNameDESC();
                        break;
                    case "0":
                        menuSort();
                        break;
                    default:
                        System.out.println("Is wrong choice! Please choice again");
                        System.out.print("==>  ");
                        flag = false;
                }
            }while (!flag);
        } catch (Exception e) {
            e.getStackTrace();

        }
    }

    private static void sortNameASC() {
        List<Product> products = productService.findAllProducts();
        SortByNameASC sortByNameASC = new SortByNameASC();
        products.sort(sortByNameASC);
        showSortList(products);
        sortName();
    }

    private static void sortNameDESC() {
        List<Product> products = productService.findAllProducts();
        SortByNameDESC sortByNameDESC = new SortByNameDESC();
        products.sort(sortByNameDESC);
        showSortList(products);
        sortName();
    }

    private static void sortPrice() {
        try {
            boolean flag = true;
            String choice;
            System.out.println();
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘              ► Sort By Price Product ◄            ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘       1.     Price Product Ascending              ⥘⥘");
            System.out.println("⥘⥘       2.     Price Product Decrease               ⥘⥘");
            System.out.println("⥘⥘       0.     Return Product Sort                  ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("Select your choice:");
            System.out.print("==> ");
            do {
                choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        sortPriceASC();
                        break;
                    case "2":
                        sortPriceDESC();
                        break;
                    case "0":
                        menuSort();
                        break;
                    default:
                        System.out.println("Is wrong choice! Please choice again");
                        System.out.print("==>  ");
                        flag = false;
                }
            }while (!flag);
        } catch (Exception e) {
            e.getStackTrace();

        }
    }

    private static void sortPriceASC() {
        List<Product> products = productService.findAllProducts();
        SortByPriceASC sortByPriceASC = new SortByPriceASC();
        products.sort(sortByPriceASC);
        showSortList(products);
        sortPrice();
    }

    private static void sortPriceDESC() {
        List<Product> products = productService.findAllProducts();
        SortByPriceDESC sortByPriceDESC = new SortByPriceDESC();
        products.sort(sortByPriceDESC);
        showSortList(products);
        sortPrice();
    }

    private static void showSortList(List<Product> products) {
        System.out.println();
        System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚Product⟚List⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
        System.out.printf("%-25s %-20s %-20s %-20s\n", "IdProduct", "NameProduct", "Price", "Amount");
        System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
        for (Product product : productService.findAllProducts()) {
            System.out.printf("%-25s %-20s %-20s %-20s\n",
                    product.getIdProduct(),
                    product.getNameProduct(),
                    InstantUtil.doubleToVND(product.getPrice()),
                    InstantUtil.amountProduct(product.getAmount())
            );
        }
        System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
        int choice;
        do {
            System.out.println(" Press 0 to return to product manager");
            System.out.print("==>  ");
            choice = AppUtil.retryParseInt();
        }while (choice != 0);
    }
}


