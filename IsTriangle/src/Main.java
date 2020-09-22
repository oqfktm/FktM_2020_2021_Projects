// IsTriangle

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Var
        float a = 0, b = 0, c = 0;
        boolean a0 = false, b0 = false, c0 = false;
        boolean iab = false, ibc = false, iac = false;
        Scanner s = new Scanner(System.in);

        // Scanner
        System.out.print("a = "); System.out.println();
        a = s.nextFloat();
        System.out.print("b = "); System.out.println();
        b = s.nextFloat();
        System.out.print("c = "); System.out.println();
        c = s.nextFloat();

        // Zero Check
        a0 = (a == 0) ? true : false; b0 = (b == 0) ? true : false; c0 = (c == 0) ? true : false;
        if (a0 || b0 || c0) {System.out.println("Error: Side cannot be of length 0."); System.exit(0);}

        // Inequality Check
        iab = !(a + b > c) ? true : false; ibc = !(b + c > a) ? true : false; iac = !(a + c > b) ? true : false;
        if (iab || ibc || iac) {System.out.println("Error: Sides do not match the Inequality Theorem."); System.exit(0);}

        // Success
        System.out.println("Triangle can be generated.");

    }
}
