package src;

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
}
