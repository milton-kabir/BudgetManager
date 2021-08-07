//package budget;
package com.kabir.milton;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
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
        String cnt = "null";
        while (true) {
            System.out.println("Choose your action:\n" +
                    "1) Add income\n" +
                    "2) Add purchase\n" +
                    "3) Show list of purchases\n" +
                    "4) Balance\n" +
                    "5) Save\n" +
                    "6) Load\n" +
                    "0) Exit");
            String cc = sc.nextLine();
            if (cc.equals("0")) {
                System.out.println("\nBye!");
                break;
            }
            if (cc.equals("5")) {


                try {
                    FileWriter myWriter = new FileWriter("purchases.txt");
                    myWriter.write("Balance: $" + String.format("%.2f", balance));
                    myWriter.write(System.getProperty("line.separator"));

                    myWriter.write("Counter: " + cnt);
                    myWriter.write(System.getProperty("line.separator"));
                    String[] aa = new String[5];
                    aa[1] = "Food";
                    aa[2] = "Clothes";
                    aa[3] = "Entertainment";
                    aa[4] = "Other";

                    for (int j = 1; j <= 4; j++) {
                        for (int i = 0; i < purchaseList[j].size(); i++) {
                            myWriter.write(aa[j] + " " + purchaseList[j].get(i) + " $" + priceList[j].get(i));
                            myWriter.write(System.getProperty("line.separator"));
                        }
                    }

                    myWriter.close();
                    System.out.println("Purchases were saved!");
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

            } else if (cc.equals("6")) {
                FileReader fr = new FileReader("purchases.txt");   //reads the file
                BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
                StringBuffer sb = new StringBuffer();    //constructs a string buffer with no characters
                String line;
//                System.out.println("hereeeeeeee");
                while ((line = br.readLine()) != null) {
//                    System.out.println("cffdfffffdfdfdfdfd");
                    String st = line;
                    String[] arr = st.split(" ");

                    if (arr[0].equals("Balance:")) {
                        arr[1] = arr[1].substring(1);
                        balance = Double.parseDouble(arr[1]);
                    } else if (arr[0].equals("Counter:")) {
                        arr[1] = arr[1].substring(1);
                        cnt = arr[1];
                    } else if (arr[0].equals("Food")) {
                        int l = arr.length;
                        String ss = arr[1];
                        for (int i = 2; i < l - 1; i++) {
                            ss = ss + " " + arr[i];
                        }
                        arr[l - 1] = arr[l - 1].substring(1);
                        purchaseList[1].add(ss);
                        priceList[1].add(arr[l - 1]);

                    } else if (arr[0].equals("Clothes")) {
                        int l = arr.length;
                        String ss = arr[1];
                        for (int i = 2; i < l - 1; i++) {
                            ss = ss + " " + arr[i];
                        }
                        arr[l - 1] = arr[l - 1].substring(1);
                        purchaseList[2].add(ss);
                        priceList[2].add(arr[l - 1]);

                    } else if (arr[0].equals("Entertainment")) {
                        int l = arr.length;
                        String ss = arr[1];
                        for (int i = 2; i < l - 1; i++) {
                            ss = ss + " " + arr[i];
                        }
                        arr[l - 1] = arr[l - 1].substring(1);
                        purchaseList[3].add(ss);
                        priceList[3].add(arr[l - 1]);

                    } else if (arr[0].equals("Other")) {
                        int l = arr.length;
                        String ss = arr[1];
                        for (int i = 2; i < l - 1; i++) {
                            ss = ss + " " + arr[i];
                        }
                        arr[l - 1] = arr[l - 1].substring(1);
                        purchaseList[4].add(ss);
                        priceList[4].add(arr[l - 1]);
                    }

                }
                fr.close();
                System.out.println("\nPurchases were loaded!\n");

            } else if (cc.equals("1")) {
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
                        cnt = "notnull";
                        System.out.println("\nEnter purchase name:");
                        String st = sc.nextLine();
                        System.out.println("Enter its price:");
                        String pp = sc.nextLine();
                        double ddd = Double.parseDouble(pp);
                        ddd *= 1.00;
                        pp = Double.toString(ddd);
                        int pnt = -1;
                        for (int i = 0; i < pp.length(); i++) {
                            if (pp.charAt(i) == '.') {
                                pnt = 1;
                                String ssd = pp.substring(i + 1);
                                if (ssd.length() == 1) {
                                    pp += "0";

                                }
                                break;
                            }
                        }
                        if (pnt == -1) {
                            pp += ".00";
                        }
                        purchaseList[Integer.parseInt(ck)].add(st);
                        priceList[Integer.parseInt(ck)].add(pp);
                        System.out.println("Purchase was added!\n");
                        expense += Double.parseDouble(pp);
                        balance = Double.max(0, balance - Double.parseDouble(pp));
                    } else if (ck.equals("2")) {
                        cnt = "notnull";
                        System.out.println("\nEnter purchase name:");
                        String st = sc.nextLine();
                        System.out.println("Enter its price:");
                        String pp = sc.nextLine();

                        expense += Double.parseDouble(pp);
                        balance = Double.max(0, balance - Double.parseDouble(pp));
                        double ddd = Double.parseDouble(pp);
                        ddd *= 1.00;
                        pp = Double.toString(ddd);
                        int pnt = -1;
                        for (int i = 0; i < pp.length(); i++) {
                            if (pp.charAt(i) == '.') {
                                pnt = 1;
                                String ssd = pp.substring(i + 1);
                                if (ssd.length() == 1) {
                                    pp += "0";

                                }
                                break;
                            }
                        }
                        if (pnt == -1) {
                            pp += ".00";
                        }

                        purchaseList[Integer.parseInt(ck)].add(st);
                        priceList[Integer.parseInt(ck)].add(pp);
                        System.out.println("Purchase was added!\n");
                    } else if (ck.equals("3")) {
                        cnt = "notnull";
                        System.out.println("\nEnter purchase name:");
                        String st = sc.nextLine();
                        System.out.println("Enter its price:");
                        String pp = sc.nextLine();
                        double ddd = Double.parseDouble(pp);
                        ddd *= 1.00;
                        pp = Double.toString(ddd);
                        int pnt = -1;
                        for (int i = 0; i < pp.length(); i++) {
                            if (pp.charAt(i) == '.') {
                                pnt = 1;
                                String ssd = pp.substring(i + 1);
                                if (ssd.length() == 1) {
                                    pp += "0";

                                }
                                break;
                            }
                        }
                        if (pnt == -1) {
                            pp += ".00";
                        }
                        purchaseList[Integer.parseInt(ck)].add(st);
                        priceList[Integer.parseInt(ck)].add(pp);
                        System.out.println("Purchase was added!\n");
                        expense += Double.parseDouble(pp);
                        balance = Double.max(0, balance - Double.parseDouble(pp));
                    } else if (ck.equals("4")) {
                        cnt = "notnull";
                        System.out.println("\nEnter purchase name:");
                        String st = sc.nextLine();
                        System.out.println("Enter its price:");
                        String pp = sc.nextLine();
                        double ddd = Double.parseDouble(pp);
                        ddd *= 1.00;
                        pp = Double.toString(ddd);
                        int pnt = -1;
                        for (int i = 0; i < pp.length(); i++) {
                            if (pp.charAt(i) == '.') {
                                pnt = 1;
                                String ssd = pp.substring(i + 1);
                                if (ssd.length() == 1) {
                                    pp += "0";

                                }
                                break;
                            }
                        }
                        if (pnt == -1) {
                            pp += ".00";
                        }
                        purchaseList[Integer.parseInt(ck)].add(st);
                        priceList[Integer.parseInt(ck)].add(pp);
                        System.out.println("Purchase was added!\n");
                        expense += Double.parseDouble(pp);
                        balance = Double.max(0, balance - Double.parseDouble(pp));
                    }
                }

            } else if (cc.equals("3")) {
                if (cnt.equals("null")) {
                    System.out.println("\nThe purchase list is empty\n");
                    continue;
                }
                while (true) {
                    System.out.println("\nChoose the type of purchases\n" +
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
                        if (cnt.equals("null")) {
                            System.out.println("\nThe purchase list is empty\n");
                        } else {
                            double xx = 0;
                            for (int j = 1; j <= 4; j++) {
                                for (int i = 0; i < purchaseList[j].size(); i++) {
                                    String sss = priceList[j].get(i);
//                                    System.out.println(sss);
                                    xx += Double.parseDouble(sss);
                                    System.out.println(purchaseList[j].get(i) + " $" + priceList[j].get(i));
                                }
                            }
                            System.out.println("Total sum: $" + String.format("%.2f", xx));
                            System.out.println("");
                        }


                    } else if (ck.equals("6")) {
                        System.out.println();
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
