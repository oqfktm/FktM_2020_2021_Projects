import java.util.Random;

// TTT AI
@SuppressWarnings("FieldNameHidesFieldInSuperclass")


public class AI {
    
        static Main m = new Main();
        String[] board = {"ZERO",
                             "N", "N", "N", 
                             "N", "N", "N", 
                             "N", "N", "N"
    };
        int XMoves = 0;
        int OMoves = 0;
        Random rand = new Random();
        
        void Update() {
        board = m.board;
        XMoves = getXMoves(board);
        OMoves = getOMoves(board);
        }
        
        // AI Shutdown
        @Override
        @SuppressWarnings("FinalizeDeclaration")
        protected void finalize() throws Throwable {
            try {
                System.out.print("");
            } finally {
                super.finalize();
            }
        }
        
        public int getXMoves(String[] board) {
            int xmoves = 0;
            for (String i : board) {
                if (i == "X") {xmoves++;}
            }
            return xmoves;
        }
        public int getOMoves(String[] board) {
            int omoves = 0;
            for (String i : board) {
                if (i == "O") {omoves++;}
            }
            return omoves;
        }
        
        public int Move() {
            Update();
            int SelectedPosition = 0;
            
            // First Move
            if (OMoves == 0) {
                int movecheck = rand.nextInt(8)+1;
               while (board[movecheck] != "N") {movecheck = rand.nextInt(8)+1;}
               SelectedPosition = movecheck;
            }
            
            // Check if self is close to winning
            if (CloseToWinning(true) != 0) {SelectedPosition = CloseToWinning(true);}
            
            // Check if X is close to winning
            if (CloseToWinning(false) != 0) {SelectedPosition = CloseToWinning(false);}
            
            // Find space with most free lines running through it
            // Pick a random line to follow
            // Pick a random position on the line
            else {
                int movecheck = rand.nextInt(8)+1;
               while (board[movecheck] != "N") {movecheck = rand.nextInt(8)+1;}
               SelectedPosition = movecheck;
            }
            
            
            return SelectedPosition;
        }
        
        public int CloseToWinning(boolean self) {
            int Result = 0;
            String CA = "N";
            if (self) {CA = "O";} else {CA = "X";}
            
            // H LINES
            if (CombinationCheck(board[1], board[2], board[3], CA)) {Result = DetermineLocation(board, "123");}
            if (CombinationCheck(board[4], board[5], board[6], CA)) {Result = DetermineLocation(board, "456");}
            if (CombinationCheck(board[7], board[8], board[9], CA)) {Result = DetermineLocation(board, "789");}
            
            // V LINES
            if (CombinationCheck(board[1], board[4], board[7], CA)) {Result = DetermineLocation(board, "147");}
            if (CombinationCheck(board[2], board[5], board[8], CA)) {Result = DetermineLocation(board, "258");}
            if (CombinationCheck(board[3], board[6], board[9], CA)) {Result = DetermineLocation(board, "369");}
            
            // D LINES
            if (CombinationCheck(board[1], board[5], board[9], CA)) {Result = DetermineLocation(board, "159");}
            if (CombinationCheck(board[3], board[5], board[7], CA)) {Result = DetermineLocation(board, "357");}
            
            return Result;
        }
        
        public boolean CombinationCheck(String val1, String val2, String val3, String Filter) {
            int ncount = 0, xcount = 0, ocount = 0;
            if (val1 == "N") {ncount++;} else if (val1 == "X") {xcount++;} else if (val1 == "O") {ocount++;}
            if (val2 == "N") {ncount++;} else if (val2 == "X") {xcount++;} else if (val2 == "O") {ocount++;}
            if (val3 == "N") {ncount++;} else if (val3 == "X") {xcount++;} else if (val3 == "O") {ocount++;}
            
            if (Filter == "X") {if (ncount == 1 && xcount == 2) {return true;}}
            if (Filter == "O") {if (ncount == 1 && ocount == 2) {return true;}}
            
            return false;
        }
        
        public int DetermineLocation(String[] board, String ID) {
            int Result = 0;
            
            switch (ID) {
                case "123":
                    if (board[1] == "N") {Result = 1;} else if (board[2] == "N") {Result = 2;} else if (board[3] == "N") {Result = 3;}
                    break;
                case "456":
                    if (board[4] == "N") {Result = 4;} else if (board[5] == "N") {Result = 5;} else if (board[6] == "N") {Result = 6;}
                    break;
                case "789":
                    if (board[7] == "N") {Result = 7;} else if (board[8] == "N") {Result = 8;} else if (board[9] == "N") {Result = 9;}
                    break;
                case "147":
                    if (board[1] == "N") {Result = 1;} else if (board[4] == "N") {Result = 4;} else if (board[7] == "N") {Result = 7;}
                    break;
                case "258":
                    if (board[2] == "N") {Result = 2;} else if (board[5] == "N") {Result = 5;} else if (board[8] == "N") {Result = 8;}
                    break;
                case "369":
                    if (board[3] == "N") {Result = 3;} else if (board[6] == "N") {Result = 6;} else if (board[9] == "N") {Result = 9;}
                    break;
                case "159":
                    if (board[1] == "N") {Result = 1;} else if (board[5] == "N") {Result = 5;} else if (board[9] == "N") {Result = 9;}
                    break;
                case "357":
                    if (board[3] == "N") {Result = 3;} else if (board[5] == "N") {Result = 5;} else if (board[7] == "N") {Result = 7;}
                    break;
            }
            
            return Result;
        }
}
    
