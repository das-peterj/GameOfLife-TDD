public class Life {
    // setting static int variables for defining the board
    public static final int ROWS = 10;
    public static final int COLUMNS = 25;
    public static final int TIME_DELAY = 500;


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



    // the displayBoard method displays the board.
    public static void displayBoard(Board board) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                if (board.get(r, c) == 0) {
                    System.out.print(".");
                } else if (board.get(r,c) == 1) {
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }



//   method calcNextNeighbour that actually handles the rules of Conways Game of Life.
//   1. Any live cell with fewer than two live neighbors dies, as if caused by underpopulation.
//   2. Any live cell with more than three live neighbors dies, as if by overcrowding.
//   3. Any live cell with two or three live neighbors lives on to the next generation.
//   4. Any dead cell with exactly three live neighbors becomes a live cell.
    public static void calcNextNeighbour(Board board, Board nextBoard) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                if (board.get(r, c) == 1 && countNeighbours(r, c, board) < 2) { // rule 1
                    nextBoard.set(r, c, 0);
                }
                else if ( board.get(r, c) == 1 && countNeighbours(r, c, board) > 3) { // rule 2
                    nextBoard.set(r, c, 0);
                }
                else if (board.get(r, c) == 1 && countNeighbours(r, c, board) < 4) { // rule 3
                    nextBoard.set(r, c, 1);
                }
                else if (board.get(r, c) == 0 && countNeighbours(r, c, board) == 3) { // rule 4
                    nextBoard.set(r, c, 1);
                }
                else {
                    nextBoard.set(r, c, 0); // if none of the rules above happens, this is a "failsafe".
                }

            }
        }
    }



    // the method countNeighbours counts the eight cells around a specific cell.
    // useful to make sure it doesnt count outside of the bounds of the awway and
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



    public static void main(String[] args) {
        Board board = new Board(ROWS, COLUMNS);
        initBoard(board);
        displayBoard(board);
        // make this a test later on ?
        System.out.println(countNeighbours(0, 0, board) + " live neighbour(s).");
    }
}
