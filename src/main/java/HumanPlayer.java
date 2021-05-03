import java.util.Scanner;

public class HumanPlayer extends Player {
    public HumanPlayer(String symbol) {
        super(symbol);
    }

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String[] move(String[] board) {
        System.out.println("Enter the coordinates (1-9):");
        int coordinate;
        String sc = scanner.nextLine();

        try {
            coordinate = Integer.parseInt(sc);
        } catch (NumberFormatException e) {
            System.out.println("You should enter numbers!");
            return move(board);
        }

        if (coordinate > 10 || coordinate < 1) {
            System.out.println("Coordinates should be from 1 to 9!");
            return move(board);
        }
        if (!board[coordinate - 1].equals(Main.EMPTY_CELL)) {
            System.out.println("This cell is occupied! Choose another one!");
            return move(board);
        }

        board[coordinate - 1] = getSymbol();
        return board;
    }
}
