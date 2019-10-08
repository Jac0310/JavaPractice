package CatalystAssessment;

import java.util.ArrayList;

public class Shape {

    public int area;

    public ArrayList<Integer> lines = new ArrayList<>();

    private int[][]bMap;
    private int[][]inverseBMap;




    public Shape(int area, int[][] binaryMap)
    {
        this.area = area;
        this.bMap = binaryMap;
        inverseBMap = new int[bMap.length][bMap[0].length];


        for (int i = 0; i < bMap.length; i++)
        {
            inverseBMap[i] = bMap[bMap.length-1-i];
            inverseBMap[bMap.length-1-i] = bMap[i];
        }


        initialiseLines(bMap);
        initialiseLines(inverseBMap);
    }

    public void initialiseLines(int[][] binaryMap)
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
                    if (horizontalLineEnd(r, c, binaryMap) && horizontal > 0) { lines.add(horizontal); horizontal = 0; }
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
                    if (c > 0)
                    {
                        if (binaryMap[r][c-1]==0)
                        {
                            vertical++;
                        }
                    } else { vertical++; }
                    if (verticalLineEnd(r, c, binaryMap) && vertical > 0) { lines.add(vertical); vertical = 0; }
                }
            }
        }
    }

    public boolean horizontalLineEnd(int row, int column, int[][] binaryMap)
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

    public boolean verticalLineEnd(int row, int column, int[][] binaryMap)
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

        return other.area == area && lines.containsAll(other.lines) && other.lines.containsAll(lines);
    }


}
