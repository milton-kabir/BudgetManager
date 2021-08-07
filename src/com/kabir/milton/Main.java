//package budget;
package com.kabir.milton;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner sc=new Scanner(System.in);
        double tot=0;
        while(sc.hasNextLine()){
            String st=sc.nextLine();
            System.out.println(st);
            String[] ar=st.split(" ");
            String ss=ar[ar.length-1];
            ss=ss.substring(1);
            double d=Double.parseDouble(ss);
            tot+=d;
        }
        System.out.println("Total: $"+tot);
    }
}
