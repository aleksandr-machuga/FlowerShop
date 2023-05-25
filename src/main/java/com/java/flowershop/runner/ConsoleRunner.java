package com.java.flowershop.runner;

import com.java.flowershop.entity.Bouquet;
import com.java.flowershop.enums.BouquetItem;
import com.java.flowershop.service.Manager;


import java.util.*;

public class ConsoleRunner {

    public static final String MENU = "Select action:\n1. Compose Bouquet\n2. Sort flowers by freshness\n3. Find flowers by stem length";
    public static Scanner scanner = new Scanner(System.in);
    private static Bouquet bouquet;
    private static boolean repeat = true;

    public static void main(String[] args) {
        while (repeat) {
            printMenu();
            System.out.println("Do you want to continue? Y/N");
            String answer = scanner.next();
            if (!answer.equalsIgnoreCase("y")) {
                repeat = false;
                System.out.println("Bye-bye!");
            }
        }
    }

    private static void printMenu() {
        System.out.println(MENU);
        int action = scanner.nextInt();
        switch (action) {
            case 1 -> {
                getOrder();
                bouquet = Manager.composeBouquet();
                System.out.printf("Your bouquet price is: %.2f\n", Manager.getTotalPrice(bouquet));
                System.out.println(bouquet);
            }
            case 2 -> sortFlowers();
            case 3 -> filterFlowers();
            default -> System.out.println("Action not supported");
        }
    }

    private static void filterFlowers() {
        if (Objects.nonNull(bouquet)) {
            System.out.println("Enter min stem length ");
            int min = scanner.nextInt();
            System.out.println("Enter max stem length");
            int max = scanner.nextInt();
            System.out.println(Manager.findFlower(min, max, bouquet));
        } else {
            System.out.println("Create new bouquet");
        }
    }

    private static void sortFlowers() {
        if (Objects.nonNull(bouquet)) {
            System.out.println(Manager.sortByFreshness(bouquet));
        } else {
            System.out.println("Create new bouquet");
        }
    }

    private static void getOrder() {
        System.out.println("Select flowers, accessories and quantity");
        Arrays.stream(BouquetItem.values()).forEach(name -> {
            System.out.println("How many " + name.name().toLowerCase());
            int quantity = scanner.nextInt();
            Manager.setOrder(name, quantity);
        });

    }
}
