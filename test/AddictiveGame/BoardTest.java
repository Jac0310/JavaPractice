package AddictiveGame;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class BoardTest extends TestCase {

    Board testBoard;

    @Before
    public void setUp()
    {
        testBoard = new Board(6, 4);
    }

    @Test
    public void test1()
    {
        Coordinate result = testBoard.getCoord(1);
        assert result.row == 1 && result.column == 1;
    }

    @Test
    public void test2()
    {
        Coordinate result = testBoard.getCoord(11);
        assert result.row == 3 && result.column == 3;
    }

    @Test
    public void test3()
    {
        Coordinate result = testBoard.getCoord(24);
        assert result.row == 6 && result.column == 4;
    }

    @Test
    public void test4()
    {
        Coordinate result = testBoard.getCoord(7);
        assert result.row == 2 && result.column == 3;
    }

    @Test
    public void test5()
    {
        Coordinate result = testBoard.getCoord(6);
        assert result.row == 2 && result.column == 2;
    }

}