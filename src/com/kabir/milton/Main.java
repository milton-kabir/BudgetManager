//package budget;
package com.kabir.milton;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        Scanner sc = new Scanner(System.in);
        ArrayList<String>[] purchaseList = new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            purchaseList[i] = new ArrayList<>();
        }
        ArrayList<String>[] priceList = new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            priceList[i] = new ArrayList<>();
        }
        double balance = 0, expense = 0;
        String cnt = "null";
        while (true) {
            System.out.println("\nChoose your action:\n" +
                    "1) Add income\n" +
                    "2) Add purchase\n" +
                    "3) Show list of purchases\n" +
                    "4) Balance\n" +
                    "5) Save\n" +
                    "6) Load\n" +
                    "7) Analyze (Sort)\n" +
                    "0) Exit");
            String cc = sc.nextLine();
            if (cc.equals("0")) {
                System.out.println("\nBye!");
                break;
            }

            if (cc.equals("7")) {
                while (true) {
                    System.out.println("\nHow do you want to sort?\n" +
                            "1) Sort all purchases\n" +
                            "2) Sort by type\n" +
                            "3) Sort certain type\n" +
                            "4) Back");
                    String vk = sc.nextLine();
                    System.out.println("\n");
                    if (vk.equals("4")) {
                        System.out.println();
                        break;
                    }

                    switch (vk) {
                        case "1": {
                            if (cnt.equals("null")) {
                                System.out.println("\nThe purchase list is empty!\n");
                                continue;
                            }
                            HashMap<Integer, Double> myMap = new HashMap<>();
                            ArrayList<Double> aba = new ArrayList<>();
                            double tt = 0;
                            for (int j = 1; j <= 4; j++) {
                                for (int i = 0; i < priceList[j].size(); i++) {
                                    String sss = priceList[j].get(i);
                                    double dd = Double.parseDouble(sss);
                                    tt += dd;
                                    int xx = j * 100 + i;
                                    myMap.put(xx, dd);
                                    aba.add(dd);
                                }
                            }
                            Collections.sort(aba);
                            Collections.reverse(aba);
                            for (int i = 1; i < aba.size(); i++) {
                                if (Objects.equals(aba.get(i - 1), aba.get(i))) {
                                    Collections.swap(aba, i, i - 1);

                                }
                            }
                            for (double yy : aba) {
                                int xx = 0;
                                for (int ii : myMap.keySet()) {
                                    if (yy == myMap.get(ii)) {
                                        xx = ii;
                                    }
                                }
                                myMap.remove(xx);
                                int xx1 = -1;
                                for (int ii : myMap.keySet()) {
                                    if (yy == myMap.get(ii)) {
                                        xx1 = ii;
                                    }
                                }
                                if (xx1 != -1) {
                                    myMap.remove(xx1);
                                    myMap.put(xx, yy);
                                    xx = xx1;
                                }


                                if (xx < 200) {
                                    xx -= 100;
                                    System.out.println(purchaseList[1].get(xx) + " $" + priceList[1].get(xx));
                                } else if (xx < 300) {
                                    xx -= 200;
                                    System.out.println(purchaseList[2].get(xx) + " $" + priceList[2].get(xx));

                                } else if (xx < 400) {
                                    xx -= 300;
                                    System.out.println(purchaseList[3].get(xx) + " $" + priceList[3].get(xx));

                                } else if (xx < 500) {
                                    xx -= 400;
                                    System.out.println(purchaseList[4].get(xx) + " $" + priceList[4].get(xx));

                                }
                            }
                            System.out.println("Total: $" + tt);
                            System.out.println();


                            break;
                        }
                        case "2": {
                            HashMap<Integer, Double> myMap = new HashMap<>();
                            ArrayList<Double> aba = new ArrayList<>();
                            double tt, ttc = 0;
                            for (int j = 1; j <= 4; j++) {
                                tt = 0;
                                for (int i = 0; i < priceList[j].size(); i++) {
                                    String sss = priceList[j].get(i);
                                    double dd = Double.parseDouble(sss);
                                    tt += dd;
                                }
                                ttc += tt;
                                aba.add(tt);
                                myMap.put(j, tt);
                            }
                            String[] aa = new String[5];
                            aa[1] = "Food";
                            aa[2] = "Clothes";
                            aa[3] = "Entertainment";
                            aa[4] = "Other";
                            System.out.println("\nTypes:");
                            Collections.sort(aba);
                            for (int i = aba.size() - 1; i >= 0; i--) {
                                double yy = aba.get(i);
                                int xx = 0;
                                for (int ii : myMap.keySet()) {
                                    if (yy == myMap.get(ii)) {
                                        xx = ii;
                                    }
                                }
                                System.out.println(aa[xx] + " - $" + String.format("%.2f", yy));
                                myMap.remove(xx);
                            }

                            System.out.println("Total sum: $" + String.format("%.2f", ttc));
                            System.out.println();
                            break;
                        }
                        case "3": {
                            System.out.println("\nChoose the type of purchase\n" +
                                    "1) Food\n" +
                                    "2) Clothes\n" +
                                    "3) Entertainment\n" +
                                    "4) Other");
                            String ssc = sc.nextLine();
                            int hsc = Integer.parseInt(ssc);
                            if (purchaseList[hsc].size() == 0) {
                                System.out.println("\nThe purchase list is empty!");
                                continue;
                            }
                            HashMap<Double, Integer> myMap = new HashMap<>();
                            double ttc = 0;
                            ArrayList<Double> aba = new ArrayList<>();
                            for (int i = 0; i < priceList[hsc].size(); i++) {
                                String sss = priceList[hsc].get(i);
                                double dd = Double.parseDouble(sss);
                                ttc += dd;
                                myMap.put(dd, i);
                                aba.add(dd);
                            }
                            Collections.sort(aba);
                            System.out.println("\nFood:");
                            for (int i = aba.size() - 1; i >= 0; i--) {
//                            System.out.println(aba.get(i));
                                for (double ii : myMap.keySet()) {
                                    if (aba.get(i) == ii) {
                                        int xx = myMap.get(ii);
                                        System.out.println(purchaseList[hsc].get(xx) + " $" + priceList[hsc].get(xx));
                                        break;
                                    }
                                }

                            }
                            System.out.println("Total sum: $" + String.format("%.2f", ttc));
                            System.out.println();


                            break;
                        }
                    }

                }
            } else if (cc.equals("5")) {
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
//                StringBuilder sb = new StringBuilder();    //constructs a string buffer with no characters
                String line;
//                System.out.println("hereeeeeeee");
                while ((line = br.readLine()) != null) {
//                    System.out.println("cffdfffffdfdfdfdfd");
                    String[] arr = line.split(" ");

                    switch (arr[0]) {
                        case "Balance:":
                            arr[1] = arr[1].substring(1);
                            balance = Double.parseDouble(arr[1]);
                            break;
                        case "Counter:":
                            arr[1] = arr[1].substring(1);
                            cnt = arr[1];
                            break;
                        case "Food": {
                            int l = arr.length;
                            StringBuilder ss = new StringBuilder(arr[1]);
                            for (int i = 2; i < l - 1; i++) {
                                ss.append(" ").append(arr[i]);
                            }
                            arr[l - 1] = arr[l - 1].substring(1);
                            purchaseList[1].add(ss.toString());
                            priceList[1].add(arr[l - 1]);

                            break;
                        }
                        case "Clothes": {
                            int l = arr.length;
                            StringBuilder ss = new StringBuilder(arr[1]);
                            for (int i = 2; i < l - 1; i++) {
                                ss.append(" ").append(arr[i]);
                            }
                            arr[l - 1] = arr[l - 1].substring(1);
                            purchaseList[2].add(ss.toString());
                            priceList[2].add(arr[l - 1]);

                            break;
                        }
                        case "Entertainment": {
                            int l = arr.length;
                            StringBuilder ss = new StringBuilder(arr[1]);
                            for (int i = 2; i < l - 1; i++) {
                                ss.append(" ").append(arr[i]);
                            }
                            arr[l - 1] = arr[l - 1].substring(1);
                            purchaseList[3].add(ss.toString());
                            priceList[3].add(arr[l - 1]);

                            break;
                        }
                        case "Other": {
                            int l = arr.length;
                            StringBuilder ss = new StringBuilder(arr[1]);
                            for (int i = 2; i < l - 1; i++) {
                                ss.append(" ").append(arr[i]);
                            }
                            arr[l - 1] = arr[l - 1].substring(1);
                            purchaseList[4].add(ss.toString());
                            priceList[4].add(arr[l - 1]);
                            break;
                        }
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

                label1:
                while (true) {
                    System.out.println("Choose the type of purchase\n" +
                            "1) Food\n" +
                            "2) Clothes\n" +
                            "3) Entertainment\n" +
                            "4) Other\n" +
                            "5) Back\n");
                    String ck = sc.nextLine();
                    switch (ck) {
                        case "5":
                            System.out.println();
                            break label1;
                        case "1": {
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
                            break;
                        }
                        case "2": {
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
                            break;
                        }
                        case "3": {
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
                            break;
                        }
                        case "4": {
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
                            break;
                        }
                    }
                }

            } else if (cc.equals("3")) {
                if (cnt.equals("null")) {
                    System.out.println("\nThe purchase list is empty\n");
                    continue;
                }
                label:
                while (true) {
                    System.out.println("\nChoose the type of purchases\n" +
                            "1) Food\n" +
                            "2) Clothes\n" +
                            "3) Entertainment\n" +
                            "4) Other\n" +
                            "5) All\n" +
                            "6) Back\n");
                    String ck = sc.nextLine();
                    switch (ck) {
                        case "1":
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
                                System.out.println();
                            }

                            break;
                        case "2":
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
                                System.out.println();
                            }

                            break;
                        case "3":
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
                                System.out.println();
                            }

                            break;
                        case "4":
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
                                System.out.println();
                            }

                            break;
                        case "5":
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
                                System.out.println();
                            }


                            break;
                        case "6":
                            System.out.println();
                            break label;

                    }
                }
            } else if (cc.equals("4")) {
                System.out.println();
                System.out.println("Balance: $" + String.format("%.2f", balance));
                System.out.println();
            }
        }
    }
}
