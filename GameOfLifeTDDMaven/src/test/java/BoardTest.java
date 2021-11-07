

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    public static final int ROWS = 2;
    public static final int COLUMNS = 2;

    @Test
    void getCurrentBoardStatus() {
        Board board = new Board(ROWS, COLUMNS);
        Life.initBoard(board);


    }
}
