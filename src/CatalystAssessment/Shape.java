package CatalystAssessment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Shape {

    public int area;

    public HashSet<Line> lines = new HashSet<>();

    int[][]binaryMap;




    public Shape(int area, int[][] binaryMap)
    {
        this.area = area;
        this.binaryMap = binaryMap;
        initialiseLines();
    }

    public void initialiseLines()
    {
        for (int r = 0; r < binaryMap.length; r++)
        {
            int horizontal = 0;
            for (int c = 0; c < binaryMap[0].length; c++)
            {
                int pixel = binaryMap[r][c];
                if (pixel == 1)
                {
                    if (r > 0)
                    {
                        if (binaryMap[r-1][c]==0)
                        {
                            horizontal++;
                        }
                    } else { horizontal++; }
                    if (horizontalLineEnd(r, c)) { lines.add(new Line(horizontal)); horizontal = 0; }
                }
            }
        }

        for (int c = 0; c < binaryMap[0].length; c++)
        {
            int vertical = 0;
            for (int r = 0; r < binaryMap.length; r++)
            {
                int pixel = binaryMap[r][c];
                if (pixel == 1)
                {
                    if (c < 0)
                    {
                        if (binaryMap[r][c-1]==0)
                        {
                            vertical++;
                        }
                    } else { vertical++; }
                    if (verticalLineEnd(r, c)) { lines.add(new Line(vertical)); vertical = 0; }
                }
            }
        }
    }

    public boolean horizontalLineEnd(int row, int column)
    {
        if (column < binaryMap[0].length-1)
        {
            if (binaryMap[row][column+1] == 0) return true;
            if (row > 0)
            {
                if (binaryMap[row-1][column+1] == 1) return true;
            }
            return false;
        }
        return true;
    }

    public boolean verticalLineEnd(int row, int column)
    {
        if (row < binaryMap.length-1)
        {
            if (binaryMap[row+1][column] == 0) return true;
            if (column > 0)
            {
                if (binaryMap[row+1][column-1] == 1) return true;
            }
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object s)
    {
        Shape other = (Shape) s;
        return other.area == area && other.lines.equals(lines);
    }


}
