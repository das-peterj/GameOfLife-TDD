import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LifeTest {
    public static final int ROWS = 2;
    public static final int COLUMNS = 2;
    final Board board = new Board(ROWS, COLUMNS);

    @Test
    void displayingBoardShouldBeTrue() {
        boolean test = Life.displayBoard(board, ROWS, COLUMNS);
        assertTrue(test);
    }

    @Test
    void chosenCellShouldHaveThreeAliveNeighbours() {
        Life.initTestBoard(board);
        assertEquals(Life.countNeighbours(0, 0, board, ROWS, COLUMNS), 3);
    }

    @Test
    void boardShouldNotUpdateWithFourAliveCellsInA2x2Grid() {
        Life.initTestBoard(board);
        Board nextTestBoard = new Board(ROWS, COLUMNS);
        Life.calcNextNeighbour(board, nextTestBoard, ROWS, COLUMNS);
        Life.copyCurrentBoardToNext(board, nextTestBoard, ROWS, COLUMNS);

        assertEquals(Life.countNeighbours(0, 0, board, ROWS, COLUMNS),
                     Life.countNeighbours(0, 0, nextTestBoard, ROWS, COLUMNS));
        assertEquals(Life.countNeighbours(0, 1, board, ROWS, COLUMNS),
                     Life.countNeighbours(0, 1, nextTestBoard, ROWS, COLUMNS));
        assertEquals(Life.countNeighbours(1, 0, board, ROWS, COLUMNS),
                     Life.countNeighbours(1, 0, nextTestBoard, ROWS, COLUMNS));
        assertEquals(Life.countNeighbours(1, 1, board, ROWS, COLUMNS),
                     Life.countNeighbours(1, 1, nextTestBoard, ROWS, COLUMNS));
    }

    @Test
    void checkIfCellExistsInBoard() {
        Life.initTestBoard(board);
        assertNotNull(Life.countNeighbours(0,0, board, ROWS, COLUMNS));
    }
}
