// Aky je den v tyzdni

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Var
        int currentday = 0;
        String[] days = {"Pondelok", "Utorok", "Streda", "Štvrtok", "Piatok", "Sobota", "Nedeľa"};
        Scanner s = new Scanner(System.in);

        // Get
        System.out.println("Aky je den? (Cislo 1-7 1=PON)");
        currentday = s.nextInt()-1;

        // Process
        if (currentday < 0 || currentday > 6) {System.out.println("Cislo je mimo rozsahu 1-7."); System.exit(0);}
        System.out.println("Dnes je " + days[currentday]);
    }
}
