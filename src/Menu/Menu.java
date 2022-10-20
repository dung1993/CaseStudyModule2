package src.Menu;

import src.RawInfo.User;
import src.Utils.AppUtil;
import src.Views.OrderView;
import src.Views.ProductView;
import src.Views.SortView;
import src.Views.UserView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);
    static ProductView productView = new ProductView();

    public static void gearStore() {
        try {
            boolean flagLogin = true;
            String choice;
            System.out.println();
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘              ⤿Gear Store⤾         ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘               1. Login            ⥘⥘");
            System.out.println("⥘⥘               2. Sign In          ⥘⥘");
            System.out.println("⥘⥘               0. Exit             ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("Select your choice:");
            System.out.print("==>  ");
            do {
                choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        UserView.login();
                        break;
                    case "2":
                        UserView.signIn();
                        break;
                    case "3":
                        AppUtil.exit();
                        break;
                    default:
                        System.out.println("Wrong choice! Please select again:");
                        System.out.print("==>  ");
                        flagLogin = false;

                }
            } while (!flagLogin);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void menuAdmin() {
        try {
            boolean flag = true;
            String choice;
            System.out.println();
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘              ⤿Menu Admin⤾            ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘             1. Product Manager       ⥘⥘");
            System.out.println("⥘⥘             2. Order Manager         ⥘⥘");
            System.out.println("⥘⥘             3. User Manager          ⥘⥘");
            System.out.println("⥘⥘             0. Return                ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("Select your choice:");
            System.out.print("==>  ");
            do {
                choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        menuManagerProduct();
                        break;
                    case "2":
                        menuManageOrder();
                        break;
                    case "3":
                        menuManageUsers();
                        break;
                    case "0":
                        gearStore();
                        break;
                    default:
                        System.out.println("Wrong choice! Please select again:");
                        System.out.print("==>  ");
                        flag = false;
                }
            } while (!flag);
        } catch (InputMismatchException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            ex.getStackTrace();
        }
    }

    public static void menuUser(){
        try {
            boolean flag = true;
            String choice;
            System.out.println();
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘                   ⤿Menu⤾                 ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘           1. List Product                ⥘⥘");
            System.out.println("⥘⥘           2. Order                       ⥘⥘");
            System.out.println("⥘⥘           3. Return Login Screen         ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("Select your choice:");
            System.out.print("==>  ");
            do {
                choice = scanner.nextLine();
                switch (choice){
                    case "1":
                        productView.showProductList();
                        break;
                    case "2":
                        OrderView.addOrderUser();
                        break;
                    case "3":
                        gearStore();
                        break;
                    default:
                        System.out.println("Is wrong choice! Please choice again:");
                        System.out.print("==>  ");
                        flag = false;
                }
            }while (!flag);
            Menu.menuUser();

        }catch (InputMismatchException e){
            e.printStackTrace();
        }catch (Exception ex){
            ex.getStackTrace();
        }
    }

//    public void ContinueOrExist() {
//        boolean is = true;
//        do {
//            System.out.println("Press 1 to continues \t|\t '2' to return");
//            System.out.print("=> ");
//            String choice = scanner.nextLine();
//            switch (choice){
//                case "1":
//                    Menu.menuUser();
//                    break;
//                case "2":
//                    Menu.menuManagerProduct();
//                    break;
//                default:
//                    System.out.println("Is wrong choice! Please choice again:");
//                    System.out.print("==>  ");
//                    is = false;
//            }
//        }while (!is);
//    }
    public static void menuManagerProduct() {
        try {
            boolean flag = true;
            String choice;
            System.out.println();
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘                ⤿Product Manager⤾             ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘           1. Add Product                     ⥘⥘");
            System.out.println("⥘⥘           2. Edit Product Information        ⥘⥘");
            System.out.println("⥘⥘           3. Delete Product                  ⥘⥘");
            System.out.println("⥘⥘           4. Show List Product               ⥘⥘");
            System.out.println("⥘⥘           5. Find Product                    ⥘⥘");
            System.out.println("⥘⥘           6. Sort Product                    ⥘⥘");
            System.out.println("⥘⥘           0. Return Menu Admin               ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("Select your choice:");
            System.out.print("==>  ");
            do {
                choice = scanner.nextLine();
                switch (choice){
                    case "1":
                        productView.addProduct();
                        break;
                    case "2":
                        productView.editProduct();
                        break;
                    case "3":
                        productView.removeProduct();
                        break;
                    case "4":
                        productView.showProductListShow();
                        break;
                    case "5":
                        productView.findProduct();
                        break;
                    case "6":
                        SortView.menuSort();
                        break;
                    case "0":
                        menuAdmin();
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

    public static void menuManageOrder(){
        try {
            boolean flag = true;
            String choice;
            System.out.println();
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘                ⤿Order Manager⤾               ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘           1. Order Create                    ⥘⥘");
            System.out.println("⥘⥘           2. Show List Order                 ⥘⥘");
            System.out.println("⥘⥘           0. Return Menu Admin               ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("Select your choice:");
            System.out.print("==>  ");
            do {
                choice = scanner.nextLine();
                switch (choice){
                    case "1":
                        OrderView.addOrder();
                        break;
                    case "2":
                        OrderView.showListOrder();
                        break;
                    case "0":
                        Menu.menuAdmin();
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

    public static void menuManageUsers(){
        try {
            boolean flag = true;
            String choice;
            System.out.println();
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘                ⤿User Manager⤾               ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘           1. Show List User                  ⥘⥘");
            System.out.println("⥘⥘           2. Delete User                     ⥘⥘");
            System.out.println("⥘⥘           3. Set Role User                   ⥘⥘");
            System.out.println("⥘⥘           0. Return Menu Admin               ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("Select your choice:");
            System.out.print("==>  ");
            do {
                choice = scanner.nextLine();
                switch (choice){
                    case "1":
                        UserView.showUserListChoice();
                        break;
                    case "2":
                        UserView.removeUser();
                        break;
                    case "3":
                        UserView.setRoleUser();
                        break;
                    case "0":
                        Menu.menuAdmin();
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