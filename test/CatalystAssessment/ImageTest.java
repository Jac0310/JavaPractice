package CatalystAssessment;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class ImageTest extends TestCase {

    int[][] no = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

    int[][] yes = {
            {0, 0, 1},
            {0, 0, 1},
            {0, 0, 0}};

    int[][] yes1 = {
            {0, 1, 1},
            {0, 0, 0},
            {0, 0, 0}};


    int[][] yes3 = {
            {0, 1, 0},
            {1, 1, 1},
            {0, 0, 0}};


    int[][] yes4 = {
            {0, 0, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0}};

    int[][] yes5 = {
            {0, 0, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 1, 0, 0}};

    int[][] yes6 = {
            {0, 0, 0, 0},
            {1, 1, 0, 0},
            {1, 1, 1, 0},
            {1, 0, 0, 0}};

    int[][] no4 = {
            {0, 0, 0, 0},
            {1, 1, 1, 0},
            {0, 0, 1, 0}};

    int[][] no2 = {{1, 0, 0}, {0, 0, 1}, {0, 0, 0}};


    @Test
    public void test1()
    {
        Image noImage = new Image(no, 100);
        Image yesImage = new Image(yes, 100);
        Image noImage2 = new Image(no2, 100);

        assert !noImage.containsAsteroid();
        assert yesImage.containsAsteroid();
        assert !noImage2.containsAsteroid();
    }


    @Test
    public void test2()
    {

        Image yesImage = new Image(yes, 100);
        Image yesImage1 = new Image(yes1, 100);

        assert yesImage1.containsAsteroid();

        Shape s = yesImage.getShape();
        Shape s1 = yesImage1.getShape();


        assertTrue(s.equals(s1));

    }

    @Test
    public void test3()
    {
        Image yesImage3 = new Image(yes3, 100);
        Image yesImage4 = new Image(yes4, 100);

        Shape s3 = yesImage3.getShape();
        Shape s4 = yesImage4.getShape();

        assertTrue(s3.equals(s4));
    }

    @Test
    public void test4()
    {
        Image yesImage4 = new Image(yes4, 100);
        Image noImage4 = new Image(no4, 100);
        Shape s4 = yesImage4.getShape();
        Shape n4 = noImage4.getShape();
        assertTrue(!s4.equals(n4));

        assertTrue(s4.area == 4 );
    }

    @Test
    public void test5()
    {
        Image yesImage5 = new Image(yes5, 100);
        Image yesImage6 = new Image(yes6, 100);
        Shape s5 = yesImage5.getShape();
        Shape s6 = yesImage6.getShape();
        assertTrue(s5.equals(s6));
    }

}