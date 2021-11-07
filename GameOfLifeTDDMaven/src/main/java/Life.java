public class Life {
    // setting static int variables for defining the board
    public static final int ROWS = 25;
    public static final int COLUMNS = 80;
    public static final int TIME_DELAY = 200;

    // the initBoard method sets up the initial board
    public static void initBoard(Board board) {
        // r = rows || c = columns
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                int randValue = (int) (Math.random() * 3);

                if (randValue == 0) {               // 33% chance of having one live cell
                    board.set(r, c,1);
                }
            }
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

    // the displayBoard method displays the board.
    public static void displayBoard(Board board) {
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
    }

    public static boolean displayTestBoard(Board board) {
        for (int r = 0; r < LifeTest.test_ROWS; r++) {
            for (int c = 0; c < LifeTest.test_COLUMNS; c++) {
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

//   method calcNextNeighbour that actually handles the rules of Conways Game of Life.
//   1. Any live cell with fewer than two live neighbors dies, as if caused by underpopulation.
//   2. Any live cell with more than three live neighbors dies, as if by overcrowding.
//   3. Any live cell with two or three live neighbors lives on to the next generation.
//   4. Any dead cell with exactly three live neighbors becomes a live cell.
    public static void calcNextNeighbour(Board board, Board nextBoard) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                int countNeighbours = countNeighbours(r, c, board);
                if (board.get(r, c) == 1 && countNeighbours < 2) { // rule 1
                    nextBoard.set(r, c, 0);
                }
                else if ( board.get(r, c) == 1 && countNeighbours > 3) { // rule 2
                    nextBoard.set(r, c, 0);
                }
                else if (board.get(r, c) == 1 && countNeighbours < 4) { // rule 3
                    nextBoard.set(r, c, 1);
                }
                else if (board.get(r, c) == 0 && countNeighbours == 3) { // rule 4
                    nextBoard.set(r, c, 1);
                }
                else {
                    nextBoard.set(r, c, 0); // if none of the rules above happens, this is a "failsafe".
                }

            }
        }
    }

    // the method countNeighbours counts the eight cells around a specific cell.
    // useful to make sure it doesnt count outside of the bounds of the array and
    // not to count the specific cell in mind
    public static int countNeighbours(int row, int column, Board board) {
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

    // the method copyCurrentBoardToNext copies the conditions of the current board and transfers it to the next board
    // that way we can "play" the game and display the future generations of the game.
    public static void copyCurrentBoardToNext(Board board, Board nextBoard) {
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
        displayBoard(board);

        for (int i = 0; i < 200; i++) {
            clearConsole();
            displayBoard(board);
            slow();
            calcNextNeighbour(board, nextBoard);
            copyCurrentBoardToNext(board, nextBoard);
        }

//         make this a test later on ?
//        System.out.println(countNeighbours(0, 0, board) + " live neighbour(s).");
    }
}
