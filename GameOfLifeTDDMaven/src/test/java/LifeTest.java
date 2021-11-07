import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LifeTest {
    public static final int test_ROWS = 2;
    public static final int test_COLUMNS = 2;
    Board board = new Board(test_ROWS, test_COLUMNS);

    @Test
    void displayingBoardShouldBeTrue() {
        boolean test = Life.displayBoard(board, test_ROWS, test_COLUMNS);
        assertTrue(test);
    }

    @Test
    void chosenCellShouldHaveThreeAliveNeighbours() {
        Life.initTestBoard(board);
        assertEquals(Life.countNeighbours(0, 0, board, test_ROWS, test_COLUMNS), 3);
    }

    @Test
    void boardShouldNotUpdateWithFourAliveCellsInAGrid() {
        Life.initTestBoard(board);
        Board nextTestBoard = new Board(test_ROWS, test_COLUMNS);
        Life.calcNextNeighbour(board, nextTestBoard, test_ROWS, test_COLUMNS);
        Life.copyCurrentBoardToNext(board, nextTestBoard, test_ROWS, test_COLUMNS);

        assertEquals(Life.countNeighbours(0, 0, board, test_ROWS, test_COLUMNS),
                     Life.countNeighbours(0, 0, nextTestBoard, test_ROWS, test_COLUMNS));
        assertEquals(Life.countNeighbours(0, 1, board, test_ROWS, test_COLUMNS),
                     Life.countNeighbours(0, 1, nextTestBoard, test_ROWS, test_COLUMNS));
        assertEquals(Life.countNeighbours(1, 0, board, test_ROWS, test_COLUMNS),
                     Life.countNeighbours(1, 0, nextTestBoard, test_ROWS, test_COLUMNS));
        assertEquals(Life.countNeighbours(1, 1, board, test_ROWS, test_COLUMNS),
                     Life.countNeighbours(1, 1, nextTestBoard, test_ROWS, test_COLUMNS));
    }
}
