package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static final int waterIndex = 0;
    static final int milkIndex = 1;
    static final int beanIndex = 2;
    static final int cupIndex = 3;
    static final int moneyIndex = 4;

    public static void main(String[] args) {
        int[] inventory = initialInventory();
        menu(inventory);
    }

    public static int[] initialInventory() {
        final int inventorySize = 5;
        final int initialWater = 400;
        final int initialMilk = 540;
        final int initialBeans = 120;
        final int initialCups = 9;
        final int initialMoney = 550;
        int[] inventory = new int[inventorySize];
        inventory[waterIndex] = initialWater;
        inventory[milkIndex] = initialMilk;
        inventory[beanIndex] = initialBeans;
        inventory[cupIndex] = initialCups;
        inventory[moneyIndex] = initialMoney;
        return inventory;
    }

    public static void printInventory(int[] inventory) {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water\n", inventory[waterIndex]);
        System.out.printf("%d ml of milk\n", inventory[milkIndex]);
        System.out.printf("%d g of coffee beans\n", inventory[beanIndex]);
        System.out.printf("%d disposable cups\n", inventory[cupIndex]);
        System.out.printf("$%d of money\n", inventory[moneyIndex]);
        System.out.println();
    }

    public static void menu(int[] inventory) {
        boolean exit = false;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();
            switch (action) {
                case "buy":
                    buy(inventory);
                    break;
                case "fill":
                    fill(inventory);
                    break;
                case "take":
                    take(inventory);
                    break;
                case "remaining":
                    printInventory(inventory);
                    break;
                default:
                    exit = true;
            }
        } while (!exit);
    }

    public static void buy(int[] inventory) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String order = scanner.nextLine();
        switch (order) {
            case "1":
                buyEspresso(inventory);
                break;
            case "2":
                buyLatte(inventory);
                break;
            case "3":
                buyCappuccino(inventory);
                break;
            case "back":
                return;
            default:
        }
    }

    public static int[] buyEspresso(int[] inventory) {
        final int waterForEspresso = 250;
        final int beansForEspresso = 16;
        final int priceForEspresso = 4;
        if (inventory[waterIndex] < waterForEspresso) {
            System.out.println("Sorry, not enough water!");
        } else if (inventory[beanIndex] < beansForEspresso) {
            System.out.println("Sorry, not enough coffee beans");
        } else {
            System.out.println("I have enough resources, making you a coffee");
            inventory[waterIndex] -= waterForEspresso;
            inventory[beanIndex] -= beansForEspresso;
            inventory[cupIndex] -= 1;
            inventory[moneyIndex] += priceForEspresso;
            return inventory;
        }
        return inventory;
    }

    public static int[] buyLatte(int[] inventory) {
        final int waterForLatte = 350;
        final int milkForLatte = 75;
        final int beansForLatte = 20;
        final int priceForLatte = 7;
        if (inventory[waterIndex] < waterForLatte) {
            System.out.println("Sorry, not enough water!");
        } else if (inventory[milkIndex] < milkForLatte) {
            System.out.println("Sorry, not enough milk");
        } else if (inventory[beanIndex] < beansForLatte) {
            System.out.println("Sorry, not enough coffee beans");
        } else {
            System.out.println("I have enough resources, making you a coffee");
            inventory[waterIndex] -= waterForLatte;
            inventory[beanIndex] -= beansForLatte;
            inventory[milkIndex] -= milkForLatte;
            inventory[cupIndex] -= 1;
            inventory[moneyIndex] += priceForLatte;
            return inventory;
        }
        return inventory;
    }

    public static int[] buyCappuccino(int[] inventory) {
        final int waterForCappuccino = 200;
        final int milkForCappuccino = 100;
        final int beansForCappuccino = 12;
        final int priceForCappuccino = 6;
        if (inventory[waterIndex] < waterForCappuccino) {
            System.out.println("Sorry, not enough water!");
        } else if (inventory[milkIndex] < milkForCappuccino) {
            System.out.println("Sorry, not enough milk");
        } else if (inventory[beanIndex] < beansForCappuccino) {
            System.out.println("Sorry, not enough coffee beans");
        } else {
            System.out.println("I have enough resources, making you a coffee");
            inventory[waterIndex] -= waterForCappuccino;
            inventory[milkIndex] -= milkForCappuccino;
            inventory[beanIndex] -= beansForCappuccino;
            inventory[cupIndex] -= 1;
            inventory[moneyIndex] += priceForCappuccino;
            return inventory;
        }
        return inventory;
    }

    public static void fill(int[] inventory) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        int addWater = scanner.nextInt();
        inventory[waterIndex] += addWater;
        System.out.println("Write how many ml of milk you want to add:");
        int addMilk = scanner.nextInt();
        inventory[milkIndex] += addMilk;
        System.out.println("Write how many grams of coffee beans you want to add:");
        int addBeans = scanner.nextInt();
        inventory[beanIndex] += addBeans;
        System.out.println("Write how many disposable cups of coffee you want to add:");
        int addCups = scanner.nextInt();
        inventory[cupIndex] += addCups;
    }

    public static void take(int[] inventory) {
        System.out.printf("I gave you $%d\n", inventory[moneyIndex]);
        inventory[moneyIndex] = 0;
    }
}
