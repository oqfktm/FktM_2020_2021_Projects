// Java sorting demo by FktM

// Imports
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {public static final double version = 1.0;
    public static Scanner s = new Scanner(System.in);

    // Output handlers
    public static void out(String str) {System.out.print(str);}
    public static void outln(String str) {System.out.println(str + c.RESET);}
    public static void nl() {System.out.println(c.RESET);}

    public static void main(String[] args) { // Main execution loop
        int choice;

        outln(c.PURPLE_BOLD + "Java sorting demo by FktM, v" + version); nl();
        outln("Please enter a set of integers to be sorted, separated by a comma (example: 5,8,1,4,7,9,2): ");

        ArrayList<Integer> set = new ArrayList<Integer>(); String set_str[] = s.next().split(","); // Split string into array
        for (String i : set_str) {set.add(Integer.parseInt(i));} // Populate ArrayList with parsed integers
        ArrayList<Integer> data = new ArrayList<Integer>();

        out("Sort by Ascending? (true/false): "); boolean choice_ascend = s.nextBoolean();

        while (true) { // Algorithm Choice
            outln("\nWhich sorting algorithm would you like to use?");
            outln("1. SimpleSort\n2. Bubble\n3. Bubble2\n4. Insertion\n5. Insertion2\n6. Minsort\n7. Maxsort");
            out("Choose a number and press ENTER. ->");
            choice = s.nextInt(); if (choice >= 1 && choice <= 7) {break;} else {nl(); outln(c.RED_BOLD + "Invalid choice. Try again."); nl();} // Choice checking
        }

        switch (choice) { // Choice decoding
                    case 1:
                    data = SimpleSort(set, choice_ascend);
                    outln(c.YELLOW + "Efficiency: " + data.get(0) + " comparisons, " + data.get(1) + " operations.");
                    data_unpack(data); outln("Sorted Array: " + data);
                    break;
                    case 2:
                        data = Bubble(set, choice_ascend);
                    outln(c.YELLOW + "Efficiency: " + data.get(0) + " comparisons, " + data.get(1) + " operations.");
                    data_unpack(data); outln("Sorted Array: " + data);
                    break;
                    case 3:
                    data = Bubble2(set, choice_ascend);
                    outln(c.YELLOW + "Efficiency: " + data.get(0) + " comparisons, " + data.get(1) + " operations.");
                    data_unpack(data); outln("Sorted Array: " + data);
                    break;
                    case 4:
                    data = Insertion(set, choice_ascend);
                    outln(c.YELLOW + "Efficiency: " + data.get(0) + " comparisons, " + data.get(1) + " operations.");
                    data_unpack(data); outln("Sorted Array: " + data);
                    break;
                    case 5:
                    data = Insertion2(set, choice_ascend);
                    outln(c.YELLOW + "Efficiency: " + data.get(0) + " comparisons, " + data.get(1) + " operations.");
                    data_unpack(data); outln("Sorted Array: " + data);
                    break;
                    case 6:
                    data = MinSort(set, choice_ascend);
                    outln(c.YELLOW + "Efficiency: " + data.get(0) + " comparisons, " + data.get(1) + " operations.");
                    data_unpack(data); outln("Sorted Array: " + data);
                    break;
                    case 7:
                        data = MaxSort(set, choice_ascend);
                    outln(c.YELLOW + "Efficiency: " + data.get(0) + " comparisons, " + data.get(1) + " operations.");
                    data_unpack(data); outln("Sorted Array: " + data);
                    break;
            default: break;
            }
    }

    public static void data_pack(ArrayList<Integer> input, int data1, int data2) {input.add(0, data1); input.add(0, data2);}
    public static void data_unpack(ArrayList<Integer> packedData) {packedData.remove(0); packedData.remove(0);}

    public static ArrayList<Integer> SimpleSort(ArrayList<Integer> a, boolean asc) {int opr = 0; int comp = 0;
        for (int i = 0; i < a.size()-1; i++) { for (int j = i+1; j < a.size(); j++) {
            if (asc && (a.get(i) > a.get(j))) {Collections.swap(a, i, j); opr++;}
            else if (!asc && (a.get(i) < a.get(j))) {Collections.swap(a, i, j); opr++;}
            comp++;}}
        data_pack(a, comp, opr); return a;
    }

    public static ArrayList<Integer> Bubble(ArrayList<Integer> a, boolean asc) {int opr = 0; int comp = 0;
        for (int i = a.size()-1; i > 0; i--) {for (int j = 0; j < i; j++) {
            if (asc && (a.get(j) > a.get(j+1))) {Collections.swap(a, j, j+1); opr++;}
            else if (!asc && (a.get(j) < a.get(j+1))) {Collections.swap(a, j, j+1); opr++;}
        comp++;}}
        data_pack(a, comp, opr); return a;
    }

    public static ArrayList<Integer> Bubble2(ArrayList<Integer> a, boolean asc) {int opr = 0; int comp = 0;
        int i = a.size()-1, v;
        while (i >= 1) {
            v = -1;
            for (int j = 0; j < i; j++) {
                if (asc && (a.get(j) > a.get(j+1))) {Collections.swap(a, j, j+1); v = j; opr++;}
                else if (!asc && (a.get(j) < a.get(j+1))) {Collections.swap(a, j, j+1); v = j; opr++;}
                comp++;
            }
            i = v;
        }
        data_pack(a, comp, opr); return a;
    }

    public static ArrayList<Integer> Insertion(ArrayList<Integer> a, boolean asc) {int opr = 0; int comp = 0;
        int j;
        for (int i = 1; i < a.size(); i++) {
            j = i-1; comp++;
            if (asc) {while (j >= 0 && a.get(j) > a.get(j+1)) {
                Collections.swap(a, j, j+1);
                j--; opr++;
            }} else {while (j >= 0 && a.get(j) < a.get(j+1)) {
                Collections.swap(a, j, j+1);
                j--; opr++;}
            }
        }
        data_pack(a, comp, opr); return a;
    }

    public static ArrayList<Integer> Insertion2(ArrayList<Integer> a, boolean asc) {int opr = 0; int comp = 0;
        int j, temp;
        for (int i = 1; i < a.size(); i++) {
            j = i-1;
            temp = a.get(i);
            if (asc){
                while (j >= 0 && a.get(j) > temp) {
                    a.set(j + 1, a.get(j));
                    j--; opr++; comp++;
                }} else {
                    while (j >= 0 && a.get(j) < temp) {
                        a.set(j + 1, a.get(j));
                        j--; opr++; comp++;
                }}
            a.set(j+1, temp); opr++;
        }
        data_pack(a, comp, opr); return a;
    }

    public static ArrayList<Integer> MinSort(ArrayList<Integer> a, boolean asc) {int opr = 0; int comp = 0;
        int min;
        for (int i = 0; i < a.size()-1; i++) {
            min = i;
            for (int j = i+1; j < a.size(); j++) {
                if (asc && (a.get(min) > a.get(j))) {min = j; comp++;} else if (!asc && (a.get(min) < a.get(j))) {min = j; comp++;}
            }
            Collections.swap(a, i, min); opr++;
        }
        data_pack(a, comp, opr); return a;
    }

    public static ArrayList<Integer> MaxSort(ArrayList<Integer> a, boolean asc) {int opr = 0; int comp = 0;
        int max;
        for (int i = a.size()-1; i > 0; i--) {
            max = 0;
            for (int j = 1; j <= i; j++) {
                if (asc && (a.get(max) < a.get(j))) {max = j; comp++;} else if (!asc && (a.get(max) > a.get(j))) {max = j; comp++;}
            }
            Collections.swap(a, i, max); opr++;
        }
        data_pack(a, comp, opr); return a;
    }

// ANSI Output codes
class c {
    // Reset
    public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE

    // High Intensity
    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE
}
}
