package src.main;

public class Board
{
    // instance variables
    int[][] board;



    // constructor for objects in Board class
    public Board(int rows, int columns) {
        // init instance variables
        board = new int[rows][columns];
    }

    // The get method returns value stored at the specified row/col location in the board
    public int get(int row, int col) {
        return board[row][col];
    }


    // The set method sets the specified row,col location to user-specified value
    public void set(int row, int col, int value) {
        board[row][col] = value;
    }

    // the getRows method returns the number of rows (the height) of the board
    public int getRows() {
        return board.length;
    }

    // the getColums method returns the number of columns (the width) of teh board
    public int getColumns() {
        return board[0].length;
    }

}
