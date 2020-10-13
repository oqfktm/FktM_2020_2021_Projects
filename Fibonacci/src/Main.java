// Fibonacci Sequence

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Vars
        Scanner s = new Scanner(System.in);
        int n1=0,n2=1,n3,i,count;

        // Get i
        System.out.println("Koľko čísel?");
        count = s.nextInt();
        System.out.println();
        if (count < 1) {System.out.println("Nesprávny počet."); System.exit(1);}
        if (count == 1) {System.out.println("0"); System.exit(1);} if (count == 2) {System.out.println("0 1"); System.exit(1);}

        // F Loop
        System.out.print(n1+" "+n2); // 0 a 1 default
        for(i=2;i<count;++i) {
            n3=n1+n2;
            System.out.print(" "+n3);
            n1=n2; n2=n3;
        }
    }}
