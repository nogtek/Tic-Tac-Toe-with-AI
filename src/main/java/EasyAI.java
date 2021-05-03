public class EasyAI extends Player {
    public EasyAI(String symbol) {
        super(symbol);
    }

    @Override
    public String[] move(String[] board) {
        board = randomMove(board);
        System.out.println("Making move level \"easy\"");

        return board;
    }
}
