import product.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class InteractionLoop {

    Scanner scanner;
    VendingMachine vendingMachine;
    Queue<Product> inventory;

    public void interactionLoop() throws IllegalAccessException {

        scanner = new Scanner(System. in);

        Soda fanta = new Soda(10, "fanta", 10);
        Snack snickers = new Snack(7, "snickers", true);
        Food cheeseBurger = new Food(15, "Cheese burger", Size.small);

        vendingMachine = new VendingMachine(fanta, snickers, cheeseBurger);
        inventory = new LinkedList<>();

        while (true) {
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("Deposit: " + vendingMachine.getDepositAmount());
            System.out.println("Inventory: ");
            for (Product product: inventory) {
                System.out.println(product.name);
            }
            System.out.println();

            System.out.println("Enter 1 to deposit money");
            System.out.println("Enter 2 to list products");
            System.out.println("Enter 3 to buy product");
            System.out.println("Enter 4 to eat something");
            System.out.println("Enter 0 to cash out");

            try {
                switch (Integer.valueOf(scanner.nextLine())){

                    case 1:
                        depositMoney();
                        break;
                    case 2:
                        listProducts();
                        break;
                    case 3:
                        buyProduct();
                        break;
                    case 4:
                        eatFromInventory();
                        break;
                    case 0:
                        vendingMachine.cashOut();
                        break;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void depositMoney(){
        System.out.println("You can deposit either 1, 2, 5, 10, 20, 50, 100, 200, 500 or 1000 SEK");
        System.out.println("How much do you want to deposit?");

        switch (Integer.valueOf(scanner.nextLine())){

            case 1:
                vendingMachine.depositMoney(1);
                break;
            case 2:
                vendingMachine.depositMoney(2);
                break;
            case 5:
                vendingMachine.depositMoney(5);
                break;
            case 10:
                vendingMachine.depositMoney(10);
                break;
            case 20:
                vendingMachine.depositMoney(20);
                break;
            case 50:
                vendingMachine.depositMoney(50);
                break;
            case 100:
                vendingMachine.depositMoney(100);
                break;
            case 200:
                vendingMachine.depositMoney(200);
                break;
            case 500:
                vendingMachine.depositMoney(500);
                break;
            case 1000:
                vendingMachine.depositMoney(1000);
                break;

            default:
                System.out.println("Amount given does not match enforced values");
                break;
        }
    }
    public void listProducts()
    {
        System.out.println("-------------------------------------------------------------------------------------");
        for(int i = 0; i < vendingMachine.numOfProducts(); i++){
            System.out.println(vendingMachine.listProduct(i));
        }
    }
    public void buyProduct(){
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("Specify which product to buy");

        try{
            inventory.add(vendingMachine.buyProduct(Integer.valueOf(scanner.nextLine())));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void eatFromInventory(){
        if(inventory.size() == 0)
            System.out.println("Your inventory is empty");
        else
            System.out.println(inventory.poll().eat());
    }
}
