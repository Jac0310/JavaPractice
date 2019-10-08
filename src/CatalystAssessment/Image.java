package CatalystAssessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class Image {

    public int[][] array;
    public int columnCount;
    public int rowCount;
    public int timestamp;

    private Shape shape;

    public Image(int[][] ary, int timestamp)
    {
        this.array = ary;
        columnCount = array[0].length;
        rowCount = array.length;
        this.timestamp = timestamp;
        initShape();
    }

    public Shape getShape()
    {
        return shape;
    }

    private void initShape()
    {
        ArrayList<int[]> result = new ArrayList<>();


        int[][] binaryArray = new int[array.length][array[0].length];
        if (containsAsteroid())
        {

            Stream<int[]> nonZeroRows = Arrays.stream(array).filter(n -> Arrays.stream(n).filter(x -> x != 0).toArray().length > 0);
            nonZeroRows.forEach(n -> result.add(Arrays.stream(n).filter(x -> x > 0 ).toArray()));

            binaryArray = Arrays.stream(array).map(n -> Arrays.stream(n).map(x -> x > 0 ? 1 : 0).toArray()).toArray(int[][]::new);

        }
        int area = Arrays.stream(binaryArray).mapToInt(a -> Arrays.stream(a).sum()).sum();
        shape = new Shape(area, binaryArray);
    }


    public boolean containsAsteroid()
    {
        for (int r = 0; r < array.length; r++)
        {
            for (int c = 0; c < array[0].length; c++)
            {
                int pixel = array[r][c];
                if (pixel > 0 && hasPosNeighbour(r, c))
                {
                    return true;
                }
            }
        }
        return false;
    }


    private boolean hasPosNeighbour(int r, int c)
    {
        int up = 0;
        int down = 0;
        int left = 0;
        int right = 0;
        if (r > 0)
        {
            up = array[r-1][c];
        }
        if (r < rowCount-1)
        {
            down = array[r+1][c];
        }
        if (c > 0)
        {
            left = array[r][c-1];
        }
        if (c < columnCount-1)
        {
            right = array[r][c+1];
        }
        return up > 0 || down > 0 || left > 0 || right > 0;
    }
}
