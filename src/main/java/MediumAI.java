public class MediumAI extends Player {
    public MediumAI(String symbol) {
        super(symbol);
    }

    @Override
    public String[] move(String[] board) {
        String currentPlayer = getSymbol();
        String opponent = currentPlayer.equals("X") ? "O" : "X";
        System.out.println(currentPlayer + opponent);

        int move = checkFields(board, opponent);
        if (move == -1) {
            move = checkFields(board, currentPlayer);
            if (move == -1) {
                System.out.println("Making move level \"medium\"");
                return randomMove(board);
            }
        }

        board[move] = currentPlayer;
        System.out.println("Making move level \"medium\"");
        return board;
    }

    public int checkFields(String[] board, String player) {
        for (int i = 0; i < board.length; i++) {
            if (board[i].equals(Main.EMPTY_CELL)) {
                board[i] = player;
                String winner = isWinner(board);
                if (winner != null && winner.equals(player)) {
                    board[i] = Main.EMPTY_CELL;
                    return i;
                } else {
                    board[i] = Main.EMPTY_CELL;
                }
            }
        }

        return -1;
    }
}