// Faktorial

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Zadajte číslo: ");

        // Var
        Scanner s = new Scanner(System.in);
        int f = s.nextInt(), prev = f, res = f;
        String line = "";

        // Check
        if (f == 0) {System.out.println("0! = 1"); System.exit(0);};
        if (f == 1) {System.out.println("1! = 1"); System.exit(0);};
        if (f <= -1) {System.out.println("Číslo musí byť kladné."); System.exit(0);}
        if (f >= 13) {System.out.println("Chyba! Tento program využíva integery, ktoré zvyknú pretekať pri hodnotách vyšších ako 12!. "); System.exit(0);};

        // Loop
        for (; f>0; f--) {
            if (f-1 == 0) {break;}
            System.out.println(prev + " * " + (f-1) + " = " + (prev*(f-1)));
            prev = prev*(f-1);
        }

        // Result
        System.out.println("Výsledok je: " + res + "! = " + prev);
    }
}
