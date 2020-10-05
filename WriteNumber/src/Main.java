// Convert Numbers to Words
// Language: SVK

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Vars
        Scanner s = new Scanner(System.in);
        double check;
        int number, digits, floored, temp;
        String result = "", space = " ";

        // Dictionary
        String minus = "Mínus";
        String[] decimal = {"Nula", "Jeden", "Dva", "Tri", "Štyri", "Päť", "Šesť", "Sedem", "Osem", "Deväť"};
        String two_alt = "Dve";
        String[] teen = {"Desať", "Jedenásť", "Dvanásť", "Trinásť", "Štrnásť", "Pätnásť", "Šestnásť", "Sedemnásť", "Osemnásť", "Devätnásť"};
        String deci_append1 = "dsať";
        String deci_append2 = "desiat";
        String hundred = "sto";
        String kilo = "tisíc";
        String mega = "Milión";
        String mega_alt = "Miliónov";

        // Setup
        System.out.println("Podporované hodnoty: 0 -> 9,99...^10 (aj do mínusu)");
        System.out.println("Číslo?");

        // Get Number, check it and convert it
        check = s.nextDouble();
        if (check < -999999999 || check > 999999999) {System.out.println("Číslo mimo dosahu."); System.exit(1);}
        if (check < 0) {check*=-1; result = result.concat(space+minus);}
        number = (int)Math.round(check);

        // Break-up the number
        digits = String.valueOf(number).length();

        // Create Result
        if (digits == 1) {result = result.concat(space+decimal[number]);}
        doubledigit:
        if (digits == 2) {
            if (number >= 10 && number <= 19) {result = result.concat(space+teen[number-10]); break doubledigit;}
            floored = (int) Math.round(Math.floor(number/10));
            if (number >= 20 && number <= 49) {result = result.concat(space+decimal[floored]+deci_append1);}
            if (number >= 50 && number <= 99) {result = result.concat(space+decimal[floored]+deci_append2);}
            if (number-(10*floored) != 0) {result = result.concat(space+decimal[number-(10*floored)]);}
        }
        tripledigit:
        if (digits == 3) {
            floored = (int) Math.round(Math.floor(number/100));
            if (floored == 1) {result = result.concat(space+hundred.substring(0, 1).toUpperCase() + hundred.substring(1));}
            else if (floored == 2) {result = result.concat(space+two_alt+hundred);} else {
                result = result.concat(space+decimal[floored]+hundred);
            }
            number = number - (floored*100);
            floored = (int) Math.round(Math.floor(number/10));
            if (number >= 10 && number <= 19) {result = result.concat(space+teen[number-10]); break tripledigit;}
            if (number >= 20 && number <= 49) {result = result.concat(space+decimal[floored]+deci_append1);}
            if (number >= 50 && number <= 99) {result = result.concat(space+decimal[floored]+deci_append2);}
            number = number - (floored*10);
            if (number != 0) {result = result.concat(space+decimal[number]);}
        }
        quaddigit:
        if (digits == 4) {
            floored = (int) Math.round(Math.floor(number/1000));
            if (floored == 1) {result = result.concat(space+kilo.substring(0, 1).toUpperCase() + kilo.substring(1));}
            else if (floored == 2) {result = result.concat(space+two_alt+kilo);} else {
                result = result.concat(space+decimal[floored]+kilo);
            }

            number = number - (floored*1000);
            floored = (int) Math.round(Math.floor(number/100));
            if (floored == 1) {result = result.concat(space+hundred.substring(0, 1).toUpperCase() + hundred.substring(1));}
            else if (floored == 2) {result = result.concat(space+two_alt+hundred);} else {
                result = result.concat(space+decimal[floored]+hundred);
            }
            number = number - (floored*100);
            floored = (int) Math.round(Math.floor(number/10));
            if (number >= 10 && number <= 19) {result = result.concat(space+teen[number-10]); break quaddigit;}
            if (number >= 20 && number <= 49) {result = result.concat(space+decimal[floored]+deci_append1);}
            if (number >= 50 && number <= 99) {result = result.concat(space+decimal[floored]+deci_append2);}
            number = number - (floored*10);
            if (number != 0) {result = result.concat(space+decimal[number]);}
        }
        pentadigit:
        if (digits == 5) {
            floored = (int) Math.round(Math.floor(number/1000));
            temp = (int) Math.round(Math.floor(number/10000));
            if (floored >= 20 && floored <= 49) {result = result.concat(space+decimal[floored/10]+deci_append1);}
            if (floored >= 50 && floored <= 99) {result = result.concat(space+decimal[floored/10]+deci_append2);}
            if (floored >= 10 && floored <= 19) {result = result.concat(space+teen[temp]);} else {result = result.concat(space+decimal[temp]);}
            result = result.concat(space+kilo);

            number = number - (floored*1000);
            number = number - (temp*10000);
            floored = (int) Math.round(Math.floor(number/1000));
            if (floored == 1) {result = result.concat(space+hundred.substring(0, 1).toUpperCase() + hundred.substring(1));}
            else if (floored == 2) {result = result.concat(space+two_alt+hundred);} else {
                result = result.concat(space+decimal[floored+10]+hundred);
            }
            number = number - (floored*100);
            floored = (int) Math.round(Math.floor(number/10));
            if (number >= 10 && number <= 19) {result = result.concat(space+teen[number-10]); break pentadigit;}
            if (number >= 20 && number <= 49) {result = result.concat(space+decimal[floored]+deci_append1);}
            if (number >= 50 && number <= 99) {result = result.concat(space+decimal[floored]+deci_append2);}
            number = number - (floored*10);
            if (number != 0) {result = result.concat(space+decimal[number+10]);}
        }




        // Display Result
        System.out.println(result.substring(1));
        System.exit(0);
    }
}
