import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Player {
    private String symbol;

    public Player(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract String[] move(String[] board);

    public String[] randomMove(String[] board) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            if (board[i].equals(Main.EMPTY_CELL)) { list.add(i); }
        }

        Random random = new Random();
        int n = random.nextInt(list.size());
        board[list.get(n)] = getSymbol();

        return board;
    }

    public String isWinner(String[] board) {
        if (board[0].equals(board[1]) && board[1].equals(board[2]) && !board[2].equals(Main.EMPTY_CELL)) { return board[0]; }
        if (board[3].equals(board[4]) && board[4].equals(board[5]) && !board[5].equals(Main.EMPTY_CELL)) { return board[3]; }
        if (board[6].equals(board[7]) && board[7].equals(board[8]) && !board[8].equals(Main.EMPTY_CELL)) { return board[6]; }
        if (board[0].equals(board[3]) && board[3].equals(board[6]) && !board[6].equals(Main.EMPTY_CELL)) { return board[0]; }
        if (board[1].equals(board[4]) && board[4].equals(board[7]) && !board[7].equals(Main.EMPTY_CELL)) { return board[1]; }
        if (board[2].equals(board[5]) && board[5].equals(board[8]) && !board[8].equals(Main.EMPTY_CELL)) { return board[2]; }
        if (board[0].equals(board[4]) && board[4].equals(board[8]) && !board[8].equals(Main.EMPTY_CELL)) { return board[0]; }
        if (board[2].equals(board[4]) && board[4].equals(board[6]) && !board[6].equals(Main.EMPTY_CELL)) { return board[2]; }

        return null;
    }

    public boolean isDraw(String[] board) {
        for (String cell : board) {
            if (cell.equals(Main.EMPTY_CELL)) { return false; }
        }
        return true;
    }
}

