package src.Views;

import src.Menu.Menu;
import src.RawInfo.Product;
import src.Services.ProductService;
import src.Utils.AppUtil;
import src.Utils.CSVUtil;
import src.Utils.InstantUtil;

import java.time.Instant;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    public List<Product> product;

    private static ProductService productService = new ProductService();
    private static Scanner scanner = new Scanner(System.in);

    public void addProduct() {
        boolean flagProduct = true;
        do {
            System.out.println("ᴝᴝᴝᴝᴝᴝᴝᴝᴝᴝᴝᴝᴝᴝᴝᴝᴝᴝᴝᴝ|Input New Product|ᴝᴝᴝᴝᴝᴝᴝᴝᴝᴝᴝᴝᴝᴝᴝᴝᴝᴝᴝᴝ");
            long idProduct = System.currentTimeMillis() / 1000;
            String nameProduct = inputName(ChoiceStatus.ADD);
            double price = inputPrice(ChoiceStatus.ADD);
            int amount = inputAmount(ChoiceStatus.ADD);
            Product product = new Product(idProduct, nameProduct, price, amount);
            productService.addProduct(product);
            System.out.println("Input Success!");
            showProductListShow();
            Menu.menuManagerProduct();
        } while (!flagProduct);
    }

    public Long inputIdProduct(ChoiceStatus status) {
        Long idProduct;
        switch (status) {
            case EDIT:
            case REMOVE:
                System.out.println("Input id product you need delete:");
                break;
        }
        System.out.print("==>  ");
        boolean flagInputId = true;
        do {
            idProduct = AppUtil.retryParseLong();
            boolean exits = productService.exitsById(idProduct);
            switch (status) {
                case EDIT:
                case REMOVE:
                    System.out.println("Your id invalid! Please input id again: ");
                    System.out.print("==>  ");
            }
        } while (!flagInputId);
        return idProduct;
    }

    public static String inputName(ChoiceStatus status) {
        String name;
        switch (status) {
            case ADD:
                System.out.println("Input name product: ");
                break;
            case EDIT:
                System.out.println("Input name you need repair");
                break;
        }
        System.out.print("==>  ");
        boolean flagInputName = true;
        do {
            name = scanner.nextLine().trim();
            boolean exits = (!name.isEmpty());
            switch (status) {
                case ADD:
                case EDIT:
                    if (!exits) {
                        System.out.println("Input Invalid! Please again input name: ");
                        System.out.print("==>  ");
                    }
                    flagInputName = !exits;
                    break;
            }
        } while (flagInputName);
        return name;
    }

    public static double inputPrice(ChoiceStatus status) {
        double price;
        switch (status) {
            case ADD:
                System.out.println("Input price of product: ");
                break;
            case EDIT:
                System.out.println("Input price you need repair: ");
                break;
        }
        System.out.print("==>  ");
        boolean flagInputName = true;
        do {
            price = AppUtil.retryParseDouble();
            boolean exits = (price >= 1000);
            switch (status) {
                case ADD:
                case EDIT:
                case REMOVE:
                    if (!exits) {
                        System.out.println(" Your input invalid, Please again input price( greater than 1000): ");
                        System.out.print("==>  ");
                    }
                    flagInputName = !exits;
                    break;
            }
        } while (flagInputName);
        return price;
    }

    public static int inputAmount(ChoiceStatus status) {
        int amount;
        switch (status) {
            case ADD:
                System.out.println("Input amount of product: ");
                break;
            case EDIT:
                System.out.println("Input amount you need repair: ");
                break;
        }
        System.out.print("==>  ");
        boolean flagInputName = true;
        do {
            amount = AppUtil.retryParseInt();
            boolean exits = (amount > 0);
            switch (status) {
                case ADD:
                case EDIT:
                case REMOVE:
                    if (!exits) {
                        System.out.println(" Your input invalid, Please again input amount( greater than 1000): ");
                        System.out.print("==>  ");
                    }
                    flagInputName = !exits;
                    break;
            }
        } while (flagInputName);
        return amount;
    }

    public void editProduct() {
        try {
            showProductList();
            System.out.println("Id of product you need repair: ");
            System.out.print("==>  ");
            Long id = AppUtil.retryParseLong();
            if (productService.exitsById(id)) {
                boolean flagUpdate = true;
                System.out.println();
                System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
                System.out.println("⥘⥘              ⤿Edit Product⤾              ⥘⥘");
                System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
                System.out.println("⥘⥘             1. Edit Product Name         ⥘⥘");
                System.out.println("⥘⥘             2. Edit Product Price        ⥘⥘");
                System.out.println("⥘⥘             3. Edit Product Amount       ⥘⥘");
                System.out.println("⥘⥘             4. Return                    ⥘⥘");
                System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
                System.out.println("Select your choice:");
                System.out.print("==>  ");
                Product newProduct = new Product();
                newProduct.setIdProduct(id);
                do {
                    String choice = scanner.nextLine();
                    switch (choice) {
                        case "1":
                            editName(newProduct);
                            break;
                        case "2":
                            editPrice(newProduct);
                            break;
                        case "3":
                            editAmount(newProduct);
                            break;
                        default:
                            System.out.println("Wrong choice! Please select again:");
                            System.out.print("==>  ");
                            flagUpdate = false;
                    }
                } while (!flagUpdate);
            } else {
                System.out.println("Can not find id product!");
                ContinueOrExist();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void editAmount(Product newProduct) {
        int amount = inputAmount(ChoiceStatus.EDIT);
        newProduct.setAmount(amount);
        productService.editProduct(newProduct);
        System.out.println("Update success!");
        showProductList();
        ContinueOrExist();
    }

    private void editPrice(Product newProduct) {
        double price = inputPrice(ChoiceStatus.EDIT);
        newProduct.setPrice(price);
        productService.editProduct(newProduct);
        System.out.println("Update success!");
        showProductList();
        ContinueOrExist();
    }

    private void editName(Product newProduct) {
        String name = inputName(ChoiceStatus.EDIT);
        newProduct.setNameProduct(name);
        productService.editProduct(newProduct);
        System.out.println("Update success!");
        showProductList();
        ContinueOrExist();
    }

    public void removeProduct() {
        try {
            boolean flag = true;
            showProductList();
            Long id = inputIdProduct(ChoiceStatus.REMOVE);
            System.out.println();
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘              ⤿Delete Product⤾            ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘                    1. Yes                ⥘⥘");
            System.out.println("⥘⥘                    2. Return             ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("Select your choice:");
            System.out.print("==>  ");
            do {
                String choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        productService.removeProduct(id);
                        System.out.println("Detele product success!");
                        showProductList();
                        Menu.menuManagerProduct();
                        break;
                    case "2":
                        Menu.menuManagerProduct();
                    default:
                        System.out.println("Is wrong choice! Please choice again:");
                        System.out.print("==>  ");
                        flag = false;
                }
            } while (!flag);
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void showProductList() {
        System.out.println();
        System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚Product⟚List⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
        System.out.printf("⥘⥘%-20s %-25s %-20s %-20s⥘⥘\n", "IdProduct", "NameProduct", "Price", "Amount");
        System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
        for (Product product : productService.findAllProducts()) {
            System.out.printf("%-20s %-25s %-20s %-20s\n",
                    product.getIdProduct(),
                    product.getNameProduct(),
                    InstantUtil.doubleToVND(product.getPrice()),
                    InstantUtil.amountProduct(product.getAmount())
            );
        }
        System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
    }

    public void showProductListShow() {
        showProductList();
        int choice;
        do {
            System.out.println("Press 0 if you need return product manager");
            System.out.print("==>  ");
            choice = AppUtil.retryParseInt();
        } while (choice != 0);
    }

    public void showProductListShowOutMenu() {
        showProductListShow();
        Menu.menuManagerProduct();
    }

    public void showProductListShowUser() {
        showProductListShow();
        Menu.menuUser();
    }

    public void findProduct() {
        try {
            boolean flag = true;
            String choice;
            System.out.println();
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘                 ⤿Find Product⤾           ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("⥘⥘           1. Find by name product        ⥘⥘");
            System.out.println("⥘⥘           2. Find by id product          ⥘⥘");
            System.out.println("⥘⥘           0. Return                      ⥘⥘");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.println("Select your choice:");
            System.out.print("==>  ");
            do {
                choice = scanner.nextLine();
                switch (choice) {
                    case "1":
                        findByName();
                        break;
                    case "2":
                        findById();
                        break;
                    case "0":
                        Menu.menuManagerProduct();
                        break;
                    default:
                        System.out.println("Is wrong choice! Please choice again:");
                        System.out.print("==>  ");
                        flag = false;
                }
            } while (!flag);
            findProduct();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    public void findByName() {
        System.out.println("Input name product you need find:");
        System.out.print("==>  ");
        String name = scanner.nextLine().trim();
        name.toLowerCase();
        List<Product> products = productService.findProductByNameProduct(name);
        if (products.size() != 0) {
            System.out.println();
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚Name⟚Product⟚You⟚Need⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.printf("%-25s %-20s %-20s %-20s\n", "IdProduct", "NameProduct", "Price", "Amount");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            for (Product product : products) {
                System.out.printf("%-25s %-20s %-20s %-20s\n",
                        product.getIdProduct(),
                        product.getNameProduct(),
                        InstantUtil.doubleToVND(product.getPrice()),
                        InstantUtil.amountProduct(product.getAmount()));
            }
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            int choice;
            do {
                System.out.println("Press 0 if you need return productManager");
                System.out.print("==>  ");
                choice = AppUtil.retryParseInt();
            } while (choice != 0);
        } else {
            System.out.println();
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚Name⟚Product⟚You⟚Need⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.printf("%-25s %-20s %-20s %-20s\n", "IdProduct", "NameProduct", "Price", "Amount");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.printf("%60s", "Product not found!!!\n");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            int choice;
            do {
                System.out.println("Press 0 if you need return productManager");
                System.out.print("==>  ");
                choice = AppUtil.retryParseInt();
            } while (choice != 0);
        }
        findProduct();
    }

    public void findById() {
        System.out.println("Input id you need find:");
        System.out.print("==>  ");
        Long id = AppUtil.retryParseLong();
        Product product = productService.checkId(id);
        if (product != null) {
            System.out.println();
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚Name⟚Product⟚You⟚Need⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.printf("%-25s %-20s %-20s %-20s\n", "IdProduct", "NameProduct", "Price", "Amount");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.printf("%-25s %-20s %-20s %-20s\n",
                    product.getIdProduct(),
                    product.getNameProduct(),
                    InstantUtil.doubleToVND(product.getPrice()),
                    InstantUtil.amountProduct(product.getAmount()));
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            int choice;
            do {
                System.out.println("Press 0 if you need return productManager");
                System.out.print("==>  ");
                choice = AppUtil.retryParseInt();
            } while (choice != 0);
        } else {
            System.out.println();
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚Name⟚Product⟚You⟚Need⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.printf("%-25s %-20s %-20s %-20s\n", "IdProduct", "NameProduct", "Price", "Amount");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            System.out.printf("%60s", "Product not found!!!\n");
            System.out.println("⥘⥘⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⟚⥘⥘");
            int choice;
            do {
                System.out.println("Press 0 if you need return productManager");
                System.out.print("==>  ");
                choice = AppUtil.retryParseInt();
            } while (choice != 0);
        }
        findProduct();
    }

    public void ContinueOrExist() {
        boolean is = true;
        do {
            System.out.println("Press 1 to continues \t|\t '2' to return");
            System.out.print("=> ");
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    editProduct();
                    break;
                case "2":
                    Menu.menuManagerProduct();
                    break;
                default:
                    System.out.println("Is wrong choice! Please choice again:");
                    System.out.print("==>  ");
                    is = false;
            }
        }while (!is);
    }
}

