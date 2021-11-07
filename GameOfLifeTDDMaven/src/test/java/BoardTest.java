import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {
    public static final int test_ROWS = 2;
    public static final int test_COLUMNS = 2;
    public Board board = new Board(test_ROWS, test_COLUMNS);

    @Test
    void shouldCompareBoardsColumnsIsTheSameHeight() {

        Board secondBoard = new Board(test_ROWS, test_COLUMNS);

        assertEquals(board.getColumns(), secondBoard.getColumns());
    }

    @Test
    void shouldCompareBoardsRowsIsTheSameHeight() {
        Board secondBoard = new Board(test_ROWS, test_COLUMNS);

        assertEquals(board.getRows(), secondBoard.getRows());
    }

    @Test
    void allCellsShouldBeAlive() {
        Life.initTestBoard(board);
        Board secondBoard = new Board(test_ROWS, test_COLUMNS);
        Life.initTestBoard(secondBoard);

        assertEquals(board.get(0, 0), secondBoard.get(0,0));
        assertEquals(board.get(0, 1), secondBoard.get(0,1));
        assertEquals(board.get(1, 0), secondBoard.get(1,0));
        assertEquals(board.get(1, 1), secondBoard.get(1,1));
    }
}
