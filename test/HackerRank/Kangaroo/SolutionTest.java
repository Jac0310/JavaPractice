package HackerRank.Kangaroo;

import junit.framework.TestCase;
import org.junit.Test;

public class SolutionTest extends TestCase {


    @Test
    public void testKangaroo1()
    {
        assert Solution.kangaroo(0, 3, 4, 2).equals("YES");
    }


    @Test
    public void testKangaroo2()
    {
        assert Solution.kangaroo(0, 2, 5, 3).equals("NO");
    }

}