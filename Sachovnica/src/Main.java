// Sachovnica - Moznosti Pohnutia - SK

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static boolean DebugMode = false;

    static void Debug(String process, String message) {if (DebugMode) {System.out.println("[" + "\u001B[35m" + process +"] " + "\u001B[0m" + message);}}

    static int ChoosePiece(Scanner s) {newline();
        System.out.println("Vyberte si figúrku podľa čísla a stlačte ENTER: ");
        System.out.println("1. Kráľ (KK) | 2. Dáma (DD) | 3. Veža (VV) | 4.Strelec (SS) | 5. Jazdec (JJ) | 6. Pešiak (PP)");
        newline();
        System.out.print("Voľba? >");
        int choice = s.nextInt();
        newline();
        if (!ChoiceCheck(1, 6, choice)) {System.out.println("Nesprávna Voľba."); System.exit(0);}
        return choice-1;
    }

    static boolean ChoiceCheck(int min, int max, int choice) {if (choice < min || choice > max) {return false;} return true;}

    static void CLS() {for (int i = 1; i<50; i++) {newline();}}
    static void newline() {System.out.println();}
    static void load(int value) throws InterruptedException {Thread.sleep(value*1000);}

    static void draw_board_empty(String[][] texture) {
            for (int i = 7; i>=0; i--) {newline();
                for (int j = 0; j <=7; j++) {System.out.print(texture[0][j] + texture[1][i] + " ");}}
    }

    static void draw_board_full(String[][] texture, String[] models, ArrayList<String> moves, int x, int y, int type) {
        String text_red = "\u001b[31m", ansi_reset = "\u001b[0m", back_blue = "\u001b[44;1m", text_black = "\u001b[30m";
        String buffer = "";
        String currentpos = texture[0][x] + texture[1][y];
        for (int i = 7; i>=0; i--) {newline();
            for (int j = 0; j <=7; j++) {
                buffer = texture[0][j] + texture[1][i];
                if (moves.contains(buffer)) {System.out.print(back_blue + buffer + " " + ansi_reset); continue;}
                if (buffer.equals(currentpos)) {System.out.print(text_red + models[type] +" " + ansi_reset); continue;}
                System.out.print(texture[0][j] + texture[1][i] + " ");
            }}
    }
    static boolean checkLocation(int x, int y) {if (x <= 7 && x >= 0 && y <= 7 && y >= 0) {Debug("CheckLocation", "Checked: X" + x + " Y" + y + " returning TRUE ");return true;} else {Debug("CheckLocation", "Checked: X" + x + " Y" + y + " returning FALSE "); return false;}}

    static ArrayList<String> pieceLogic(String[][] coordsystem, int type, int x, int y) {
        int left = x-1, right = x+1, up = y+1, down = y-1;

        Debug("pieceLogic", "L" + left + " R" + right + " U" + up + " D" + down);
        ArrayList<String> flagged = new ArrayList<String>();
        switch (type) {
            case 0:
                if (checkLocation(left, up)) {flagged.add(coordsystem[0][left] + coordsystem[1][up]);}
                if (checkLocation(x, up)) {flagged.add(coordsystem[0][x] + coordsystem[1][up]);}
                if (checkLocation(right, up)) {flagged.add(coordsystem[0][right] + coordsystem[1][up]);}
                if (checkLocation(left, y)) {flagged.add(coordsystem[0][left] + coordsystem[1][y]);}
                if (checkLocation(right, y)) {flagged.add(coordsystem[0][right] + coordsystem[1][y]);}
                if (checkLocation(left, down)) {flagged.add(coordsystem[0][left] + coordsystem[1][down]);}
                if (checkLocation(x, down)) {flagged.add(coordsystem[0][x] + coordsystem[1][down]);}
                if (checkLocation(right, down)) {flagged.add(coordsystem[0][right] + coordsystem[1][down]);}
                break;
            case 1:
                while (checkLocation(left, y)) {flagged.add(coordsystem[0][left] + coordsystem[1][y]); left--;} left = x-1;
                while (checkLocation(right, y)) {flagged.add(coordsystem[0][right] + coordsystem[1][y]); right++;} right = x+1;
                while (checkLocation(x, up)) {flagged.add(coordsystem[0][x] + coordsystem[1][up]); up++;} up = y+1;
                while (checkLocation(x, down)) {flagged.add(coordsystem[0][x] + coordsystem[1][down]); down--;} down = y-1;
                while (checkLocation(left, up)) {flagged.add(coordsystem[0][left] + coordsystem[1][up]); left--; up++;} left = x-1; up = y+1;
                while (checkLocation(right, up)) {flagged.add(coordsystem[0][right] + coordsystem[1][up]); right++; up++;} right = x+1; up = y+1;
                while (checkLocation(left, down)) {flagged.add(coordsystem[0][left] + coordsystem[1][down]); left--; down--;} left = x-1; down = y-1;
                while (checkLocation(right, down)) {flagged.add(coordsystem[0][right] + coordsystem[1][down]); right++; down--;} right = x+1; down = y-1;
                break;
            case 2:
                while (checkLocation(left, y)) {flagged.add(coordsystem[0][left] + coordsystem[1][y]); left--;} left = x-1;
                while (checkLocation(right, y)) {flagged.add(coordsystem[0][right] + coordsystem[1][y]); right++;} right = x+1;
                while (checkLocation(x, up)) {flagged.add(coordsystem[0][x] + coordsystem[1][up]); up++;} up = y+1;
                while (checkLocation(x, down)) {flagged.add(coordsystem[0][x] + coordsystem[1][down]); down--;} down = y-1;
                break;
            case 3:
                while (checkLocation(left, up)) {flagged.add(coordsystem[0][left] + coordsystem[1][up]); left--; up++;} left = x-1; up = y+1;
                while (checkLocation(right, up)) {flagged.add(coordsystem[0][right] + coordsystem[1][up]); right++; up++;} right = x+1; up = y+1;
                while (checkLocation(left, down)) {flagged.add(coordsystem[0][left] + coordsystem[1][down]); left--; down--;} left = x-1; down = y-1;
                while (checkLocation(right, down)) {flagged.add(coordsystem[0][right] + coordsystem[1][down]); right++; down--;} right = x+1; down = y-1;
                break;
            case 4:
                if (checkLocation(left, up+1)){flagged.add(coordsystem[0][left] + coordsystem[1][up+1]);}
                if (checkLocation(right, up+1)){flagged.add(coordsystem[0][right] + coordsystem[1][up+1]);}
                if (checkLocation(left-1, up)){flagged.add(coordsystem[0][left-1] + coordsystem[1][up]);}
                if (checkLocation(left-1, down)){flagged.add(coordsystem[0][left-1] + coordsystem[1][down]);}
                if (checkLocation(right+1, up)){flagged.add(coordsystem[0][right+1] + coordsystem[1][up]);}
                if (checkLocation(right+1, down)){flagged.add(coordsystem[0][right+1] + coordsystem[1][down]);}
                if (checkLocation(left, down-1)){flagged.add(coordsystem[0][left] + coordsystem[1][down-1]);}
                if (checkLocation(right, down-1)){flagged.add(coordsystem[0][right] + coordsystem[1][down-1]);}
                break;
            case 5:
                if (checkLocation(x, up)) {flagged.add(coordsystem[0][x] + coordsystem[1][up]);}
                break;
            default: System.exit(1); break;}

            Debug("pieceLogic", "Flagged a total of " + flagged.size() + " spaces");
        return flagged;
    }

    public static void main(String[] args) throws InterruptedException {Scanner s = new Scanner(System.in);
        String text_red = "\u001b[31m", text_green = "\u001B[32m", text_blue = "\u001b[34m", ansi_reset = "\u001b[0m";

        // Assets
        String[][] board = {{"1", "2", "3", "4", "5", "6", "7", "8"}, {"A", "B", "C", "D", "E", "F", "G", "H"}};
        String[] Pieces = {"KK", "DD", "VV", "SS", "JJ", "PP"};
        String[] Pieces_Long = {"Kráľ", "Dáma", "Veža", "Strelec", "Jazdec", "Pešiak"};

        // Start
        int choice = ChoosePiece(s);
        System.out.println("Vaša voľba: " + text_blue + Pieces_Long[choice] + " (" + Pieces[choice] + ")" + ansi_reset);
        draw_board_empty(board); newline(); newline();

        // Set Location
        System.out.println("Kam by ste chceli postaviť túto figúrku? (Formát ČÍSLOPÍSMENO - napr. 4E)"); System.out.print("Voľba?: ");
        String lchoice = s.next().toUpperCase();
        if (lchoice.length() > 2 || lchoice.length() < 2) {System.out.println("Nesprávna voľba."); System.exit(0);}
        String choice_number = String.valueOf(lchoice.charAt(0));
        String choice_letter = String.valueOf(lchoice.charAt(1));
        if (!(Arrays.asList(board[0]).contains(choice_number) || Arrays.asList(board[1]).contains(choice_letter))) {System.out.println("Nesprávna voľba."); System.exit(0);}
        int x = Arrays.asList(board[0]).indexOf(choice_number), y = Arrays.asList(board[1]).indexOf(choice_letter);
        System.out.println("Prepočítavam..."); newline();
        Debug("SetLocation", "X = " + x + " Y = " + y); load(1);

        // Creator
        ArrayList<String> PossibleMoves = new ArrayList<String>();
        PossibleMoves = pieceLogic(board, choice, x, y);
        load(1); Debug("Creator", "Compiled an array of possible moves."); load(1); Debug("Creator", PossibleMoves.toString());
        load(3); CLS(); draw_board_full(board, Pieces, PossibleMoves, x, y, choice); newline();
        System.out.println("Vaša figúrka je vyznačená v " + text_red + "červenom. (" + Pieces[choice] +")" + ansi_reset + " Pozícia: " + lchoice);
        System.out.println("Možné ťahy sú vyznačené v: " + text_blue + "modrom." + ansi_reset);
        System.out.println("Možné ťahy: " + text_blue + PossibleMoves.toString() + ansi_reset);
        System.exit(0);

    }

}
