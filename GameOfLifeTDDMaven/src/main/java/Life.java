public class Life {
    // setting static int variables for defining the board
    public static final int ROWS = 25;
    public static final int COLUMNS = 80;
    public static final int TIME_DELAY = 500;


    // the initBoard method sets up the initial board
    public static void initBoard(Board board) {
        // r = rows || c = columns
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                int randValue = (int) (Math.random()*3);

                if (randValue == 0) {               // 33% chance of having one live cell
                    board.set(r,c,1);
                }
            }
        }
    }



    // the displayBoard method displays the board.
    public static void displayBoard(Board board) {
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLUMNS; c++) {
                if (board.get(r,c) == 0) {
                    System.out.println(".");
                } else if (board.get(r,c) == 1) {
                    System.out.println("*");
                }
            }
            System.out.println();
        }
    }

    // the slow method sleep to slow the display down
    private static void slow(int TIME_DELAY) {
        try {
            Thread.sleep(TIME_DELAY);
        } catch(InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }

    private static void clearConsole() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        Board board = new Board(ROWS, COLUMNS);
        initBoard(board);
        displayBoard(board);
    }
}
