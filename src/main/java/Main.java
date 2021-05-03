import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static boolean isGameOver = true;
    static Player playerX;
    static Player playerO;
    static Scanner scanner = new Scanner(System.in);

    public static final String EMPTY_CELL = " ";

    public static void main(String[] args) throws InterruptedException {
        start();
    }

    private static void start() throws InterruptedException {
        isGameOver = false;
        showMenu();

        String[] board = null;
        if (!isGameOver) {
            board = new String[9];
            Arrays.fill(board, EMPTY_CELL);
            printBoard(board);
        }
        while (!isGameOver) {
            board = playerX.move(board);
            printBoard(board);
            if (isGameOver) { break; }
            Thread.sleep(1000);
            board = playerO.move(board);
            printBoard(board);
        }
    }

    public static String checkGameStatus(String[] board) {
        String winner = playerX.isWinner(board);
        if (winner != null) {
            isGameOver = true;
            return winner + " wins";
        }
        if (playerX.isDraw(board)) {
            isGameOver = true;
            return "Draw";
        }
        return null;
    }

    public static void printBoard(String[] board) {
        for (int i = 0; i < board.length; i++) {
            if (i == 2 || i == 5 || i == 8) {
                System.out.println(board[i] + EMPTY_CELL);
            } else {
                System.out.print(board[i] + EMPTY_CELL);
                System.out.print("| ");
            }
        }
        System.out.println();
        String gameStatus = checkGameStatus(board);
        if (gameStatus != null) { System.out.println(gameStatus); }
    }

    public static void showMenu() {
        label:
        while (true) {
            System.out.println("Choose player X");
            System.out.println("Enter: [user/bot]");
            String x = scanner.nextLine();

            if (x.equals("user")) {
                playerX = new HumanPlayer("X");
                break;
            } else if (x.equals("bot")) {
                System.out.println("Choose difficulty level for bot");
                System.out.println("Enter: [easy/medium/hard]");
                String level = scanner.nextLine();
                switch (level) {
                    case "easy":
                        playerX = new EasyAI("X");
                        break label;
                    case "medium":
                        playerX = new MediumAI("X");
                        break label;
                    case "hard":
                        playerX = new HardAI("X");
                        break label;
                }
            } else {
                System.out.println("Incorrect input");
            }
        }

        label:
        while (true) {
            System.out.println("Choose player O");
            System.out.println("Enter: [user/bot]");
            String o = scanner.nextLine();

            if (o.equals("user")) {
                playerO = new HumanPlayer("O");
                break;
            } else if (o.equals("bot")) {
                System.out.println("Choose difficulty level for bot");
                System.out.println("Enter: [easy/medium/hard]");
                String level = scanner.nextLine();
                switch (level) {
                    case "easy":
                        playerO = new EasyAI("O");
                        break label;
                    case "medium":
                        playerO = new MediumAI("O");
                        break label;
                    case "hard":
                        playerO = new HardAI("O");
                        break label;
                }
            } else {
                System.out.println("Incorrect input");
            }
        }

        System.out.println("Game started!");
        System.out.println("Enter cell coordinates to make a move (1-9)");
        System.out.println();
    }
}

