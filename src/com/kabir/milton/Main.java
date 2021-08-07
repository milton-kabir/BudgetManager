//package budget;
package com.kabir.milton;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc = new Scanner(System.in);
        ArrayList<String>[] purchaseList = new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            purchaseList[i] = new ArrayList<String>();
        }
        ArrayList<String>[] priceList = new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            priceList[i] = new ArrayList<String>();
        }
        double balance = 0, expense = 0;
        int cnt = 0;
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

                while (true) {
                    System.out.println("Choose the type of purchase\n" +
                            "1) Food\n" +
                            "2) Clothes\n" +
                            "3) Entertainment\n" +
                            "4) Other\n" +
                            "5) Back\n");
                    String ck = sc.nextLine();
                    if (ck.equals("5")) {
                        System.out.println();
                        break;
                    } else if (ck.equals("1")) {
                        cnt++;
                        System.out.println("\nEnter purchase name:");
                        String st = sc.nextLine();
                        System.out.println("Enter its price:");
                        String pp = sc.nextLine();
                        purchaseList[Integer.parseInt(ck)].add(st);
                        priceList[Integer.parseInt(ck)].add(pp);
                        System.out.println("Purchase was added!\n");
                        expense += Double.parseDouble(pp);
                        balance = Double.max(0, balance - Double.parseDouble(pp));
                    } else if (ck.equals("2")) {
                        cnt++;
                        System.out.println("\nEnter purchase name:");
                        String st = sc.nextLine();
                        System.out.println("Enter its price:");
                        String pp = sc.nextLine();
                        purchaseList[Integer.parseInt(ck)].add(st);
                        priceList[Integer.parseInt(ck)].add(pp);
                        System.out.println("Purchase was added!\n");
                        expense += Double.parseDouble(pp);
                        balance = Double.max(0, balance - Double.parseDouble(pp));
                    } else if (ck.equals("3")) {
                        cnt++;
                        System.out.println("\nEnter purchase name:");
                        String st = sc.nextLine();
                        System.out.println("Enter its price:");
                        String pp = sc.nextLine();
                        purchaseList[Integer.parseInt(ck)].add(st);
                        priceList[Integer.parseInt(ck)].add(pp);
                        System.out.println("Purchase was added!\n");
                        expense += Double.parseDouble(pp);
                        balance = Double.max(0, balance - Double.parseDouble(pp));
                    } else if (ck.equals("4")) {
                        cnt++;
                        System.out.println("\nEnter purchase name:");
                        String st = sc.nextLine();
                        System.out.println("Enter its price:");
                        String pp = sc.nextLine();
                        purchaseList[Integer.parseInt(ck)].add(st);
                        priceList[Integer.parseInt(ck)].add(pp);
                        System.out.println("Purchase was added!\n");
                        expense += Double.parseDouble(pp);
                        balance = Double.max(0, balance - Double.parseDouble(pp));
                    }
                }

            } else if (cc.equals("3")) {
                if (cnt == 0) {
                    System.out.println("\nThe purchase list is empty\n");
                    continue;
                }
                while (true) {
                    System.out.println("Choose the type of purchases\n" +
                            "1) Food\n" +
                            "2) Clothes\n" +
                            "3) Entertainment\n" +
                            "4) Other\n" +
                            "5) All\n" +
                            "6) Back\n");
                    String ck = sc.nextLine();
                    if (ck.equals("1")) {
                        System.out.println("\nFood:");
                        if (purchaseList[Integer.parseInt(ck)].size() == 0) {
                            System.out.println("\nThe purchase list is empty\n");
                        } else {
                            double xx = 0;
                            for (int i = 0; i < purchaseList[Integer.parseInt(ck)].size(); i++) {
                                String sss = priceList[Integer.parseInt(ck)].get(i);
                                xx += Double.parseDouble(sss);

                                System.out.println(purchaseList[Integer.parseInt(ck)].get(i) + " $" + priceList[Integer.parseInt(ck)].get(i));
                            }
                            System.out.println("Total sum: $" + String.format("%.2f", xx));
                            System.out.println("");
                        }

                    } else if (ck.equals("2")) {
                        System.out.println("\nClothes:");
                        if (purchaseList[Integer.parseInt(ck)].size() == 0) {
                            System.out.println("\nThe purchase list is empty\n");
                        } else {
                            double xx = 0;
                            for (int i = 0; i < purchaseList[Integer.parseInt(ck)].size(); i++) {
                                String sss = priceList[Integer.parseInt(ck)].get(i);
                                xx += Double.parseDouble(sss);

                                System.out.println(purchaseList[Integer.parseInt(ck)].get(i) + " $" + priceList[Integer.parseInt(ck)].get(i));
                            }
                            System.out.println("Total sum: $" + String.format("%.2f", xx));
                            System.out.println("");
                        }

                    } else if (ck.equals("3")) {
                        System.out.println("\nEntertainment:");
                        if (purchaseList[Integer.parseInt(ck)].size() == 0) {
                            System.out.println("\nThe purchase list is empty\n");
                        } else {
                            double xx = 0;
                            for (int i = 0; i < purchaseList[Integer.parseInt(ck)].size(); i++) {
                                String sss = priceList[Integer.parseInt(ck)].get(i);
                                xx += Double.parseDouble(sss);

                                System.out.println(purchaseList[Integer.parseInt(ck)].get(i) + " $" + priceList[Integer.parseInt(ck)].get(i));
                            }
                            System.out.println("Total sum: $" + String.format("%.2f", xx));
                            System.out.println("");
                        }

                    } else if (ck.equals("4")) {
                        System.out.println("\nOther:");
                        if (purchaseList[Integer.parseInt(ck)].size() == 0) {
                            System.out.println("\nThe purchase list is empty\n");
                        } else {
                            double xx = 0;
                            for (int i = 0; i < purchaseList[Integer.parseInt(ck)].size(); i++) {
                                String sss = priceList[Integer.parseInt(ck)].get(i);
                                xx += Double.parseDouble(sss);

                                System.out.println(purchaseList[Integer.parseInt(ck)].get(i) + " $" + priceList[Integer.parseInt(ck)].get(i));
                            }
                            System.out.println("Total sum: $" + String.format("%.2f", xx));
                            System.out.println("");
                        }

                    } else if (ck.equals("5")) {
                        System.out.println();
                        System.out.println("All:");
                        if (cnt == 0) {
                            System.out.println("\nThe purchase list is empty\n");
                        } else {
                            double xx = 0;
                            for (int j = 1; j <= 4; j++) {
                                for (int i = 0; i < purchaseList[j].size(); i++) {
                                    String sss = priceList[j].get(i);
                                    xx += Double.parseDouble(sss);
                                    System.out.println(purchaseList[j].get(i) + " $" + priceList[j].get(i));
                                }
                            }
                            System.out.println("Total sum: $" + String.format("%.2f", xx));
                            System.out.println("");
                        }


                    } else if (ck.equals("6")) {
                        break;

                    }
                }
            } else if (cc.equals("4")) {
                System.out.println("");
                System.out.println("Balance: $" + String.format("%.2f", balance));
                System.out.println("");
            }
        }
    }
}
