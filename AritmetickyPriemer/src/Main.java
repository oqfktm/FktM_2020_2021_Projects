// Aritmeticky Priemer

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Var
        int var = 1, n = 0, sum = 0;
        double AP = 0;
        Scanner s = new Scanner(System.in);

        // Loop
        System.out.println("Piste cisla:");
        for (;;) {
            var = s.nextInt();
            if (var == 0) {break;}
            n++;
            sum += var;
            System.out.println("n=" + n + " sum=" + sum);
            AP = sum/n;
        }
        System.out.println("Aritmeticky priemer je: " + AP);
    }
}