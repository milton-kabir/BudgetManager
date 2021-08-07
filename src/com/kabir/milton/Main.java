//package budget;
package com.kabir.milton;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        ArrayList<String> purchaseList = new ArrayList<>();
        ArrayList<String> priceList = new ArrayList<>();
        double balance = 0, expense = 0;
        while (true) {
            System.out.println("Choose your action:\n" +
                    "1) Add income\n" +
                    "2) Add purchase\n" +
                    "3) Show list of purchases\n" +
                    "4) Balance\n" +
                    "0) Exit\n");
            String cc = sc.nextLine();
            if (cc.equals("0")) {
                System.out.println("Bye!");
                break;
            }
            if (cc.equals("1")) {
                System.out.println("\nEnter income:");
                String st = sc.nextLine();
                double d = Double.parseDouble(st);
                balance += d;
                System.out.println("Income was added!\n");
            } else if (cc.equals("2")) {
                System.out.println("\nEnter purchase name:");
                String st = sc.nextLine();
                System.out.println("Enter its price:");
                String pp = sc.nextLine();
                System.out.println("Purchase was added!\n");
                expense += Double.parseDouble(pp);
                balance = Double.max(0, balance - Double.parseDouble(pp));
                purchaseList.add(st);
                priceList.add(pp);
            } else if (cc.equals("3")) {
                if (purchaseList.size() == 0) {
                    System.out.println("\nThe purchase list is empty\n");
                } else {
                    System.out.println("");
                    for (int i = 0; i < purchaseList.size(); i++) {
                        System.out.println(purchaseList.get(i) + " $" + priceList.get(i));
                    }
                    System.out.println("Total sum: $" + String.format("%.2f", expense));
                    System.out.println("");
                }

            } else if (cc.equals("4")) {
                System.out.println("");
                System.out.println("Balance: $" + String.format("%.2f", balance));
                System.out.println("");
            }
        }
    }
}
