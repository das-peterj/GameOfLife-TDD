import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.*;

public class LifeTest {
    public static final int test_ROWS = 2;
    public static final int test_COLUMNS = 2;
    Board board = new Board(test_ROWS, test_COLUMNS);

    @Test
    void displayingBoardShouldBeTrue() {
        boolean test = Life.displayTestBoard(board);
        assertTrue(test);
    }
}
