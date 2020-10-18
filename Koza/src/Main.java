// Koza

public class Main {
    public static void main(String[] args) {
        System.out.println();

        // Var
        int maxnum = 110, maxline = 11;
        String div3 = "Koza", div5 = "Loza", div7 = "Woza", result = "";
        boolean isdiv3, isdiv5, isdiv7;

        // Loop
        for(int i = 1; i <= maxnum; i++) {
            isdiv3 = i % 3 == 0; isdiv5 = i % 5 == 0; isdiv7 = i % 7 == 0;
            if (!(isdiv3 || isdiv5 || isdiv7)) {result = result.concat(String.valueOf(i));};
            if (isdiv3) {result = result.concat(div3);} if (isdiv5) {result = result.concat(div5);} if (isdiv7) {result = result.concat(div7);}
            result = result.concat(" ");
            if (i % maxline == 0) {System.out.println(result); result = "";}
        }
    }
}
