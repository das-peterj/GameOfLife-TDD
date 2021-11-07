public class Life {
    public static final int ROWS = 25;
    public static final int COLUMNS = 80;
    public static final int TIME_DELAY = 200;

    public static void initBoard(Board board) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                int randValue = (int) (Math.random() * 3);
                if (randValue == 0) {
                    board.set(r, c,1);
                }
            }
        }
    }

    public static boolean displayBoard(Board board, int ROWS, int COLUMNS) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                if (board.get(r, c) == 0) {
                    System.out.print(".");
                } else if (board.get(r, c) == 1) {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
        return true;
    }

    public static void calcNextNeighbour(Board board, Board nextBoard, int ROWS, int COLUMNS) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                int countNeighbours = countNeighbours(r, c, board, ROWS, COLUMNS);
                if (board.get(r, c) == 1 && countNeighbours < 2) { // rule 1
                    nextBoard.set(r, c, 0);
                }
                else if (board.get(r, c) == 1 && countNeighbours > 3) { // rule 2
                    nextBoard.set(r, c, 0);
                }
                else if (board.get(r, c) == 1 && countNeighbours < 4) { // rule 3
                    nextBoard.set(r, c, 1);
                }
                else if (board.get(r, c) == 0 && countNeighbours == 3) { // rule 4
                    nextBoard.set(r, c, 1);
                }
                else {
                    nextBoard.set(r, c, 0);
                }

            }
        }
    }

    public static int countNeighbours(int row, int column, Board board, int ROWS, int COLUMNS) {
        int counter = 0;

        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = column -1; c <= column + 1; c++) {
                if (r >= 0 && r < ROWS && c >= 0 && c < COLUMNS &&
                !(r == row && c == column) && board.get(r, c) == 1) {
                    counter = counter + 1;
                }
            }
        }
        return counter;
    }

    public static void copyCurrentBoardToNext(Board board, Board nextBoard, int ROWS, int COLUMNS) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                board.set(r, c, nextBoard.get(r, c));
            }
        }
    }

    private static void slow() {
        try {
            Thread.sleep(Life.TIME_DELAY);
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }

    private static void clearConsole() {
        System.out.println("");
        System.out.println("");
        System.out.flush();
    }

    public static void main(String[] args) {

        Board board = new Board(ROWS, COLUMNS);
        Board nextBoard = new Board(ROWS, COLUMNS);
        initBoard(board);
        displayBoard(board, ROWS, COLUMNS);

        for (int i = 0; i < 200; i++) {
            clearConsole();
            displayBoard(board, ROWS, COLUMNS);
            slow();
            calcNextNeighbour(board, nextBoard, ROWS, COLUMNS);
            copyCurrentBoardToNext(board, nextBoard, ROWS, COLUMNS);
        }
    }

    public static void initTestBoard(Board board) {
        // puts each cell in this 2x2 grid to alive
        for (int r = 0; r < BoardTest.test_ROWS; r++) {
            for (int c = 0; c < BoardTest.test_COLUMNS; c++) {
                board.set(r, c,1);
            }
        }
    }
}
