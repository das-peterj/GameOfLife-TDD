public class Board
{
     final int[][] board;

    public Board(int rows, int columns) {
        board = new int[rows][columns];
    }

    public int get(int row, int col) {
        return board[row][col];
    }

    public void set(int row, int col, int value) {
        board[row][col] = value;
    }

    public int getRows() {
        return board.length;
    }

    public int getColumns() {
        return board[0].length;
    }
}
