public class HardAI extends Player {

    public HardAI(String symbol) {
        super(symbol);
    }

    @Override
    public String[] move(String[] board) {
        int bestScore = -9999;
        int move = -1;
        for (int i = 0; i < 9; i++) {
            if (board[i].equals(" ")) {
                board[i] = currentPlayer;
                int score = minimax(board,false);
                board[i] = " ";
                if (score > bestScore) {
                    bestScore = score;
                    move = i;
                }
            }
        }

        board[move] = currentPlayer;
        System.out.println("Making move level \"hard\"");
        return board;
    }

    String currentPlayer = getSymbol();

    public int evaluate(String[] board) {
        String winner = isWinner(board);
        if (winner != null && winner.equals(currentPlayer)) {
            return +10;
        } else if (winner != null) {
            return -10;
        }
        return 0;
    }

    public int minimax(String[] board, boolean isMax) {
        String opponent = currentPlayer.equals("O") ? "X" : "O";

        int score = evaluate(board);

        if (score == 10) {
            return score;
        }
        if (score == -10) {
            return score;
        }
        if (isDraw(board)) {
            return 0;
        }

        if (isMax) {
            int bestScore = -9999;
            for (int i = 0; i < board.length; i++) {
                if (board[i].equals(" ")) {
                    board[i] = currentPlayer;
                    bestScore = Math.max(bestScore, minimax(board,false));
                    board[i] = " ";
                }
            }
            return bestScore;
        } else {
            int bestScore = 9999;
            for (int i = 0; i < board.length; i++) {
                if (board[i].equals(" ")) {
                    board[i] = opponent;
                    bestScore = Math.min(bestScore, minimax(board, true));
                    board[i] = " ";
                }
            }
            return bestScore;
        }
    }
}