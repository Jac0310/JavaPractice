package CatalystAssessment;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid {
    int[][] prices;
    private String[] ltrs = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private List<String> letters = Arrays.asList(ltrs);

    private int row = 0;
    private int column = 0;

    private int rows;
    private int columns;

    public int numberOfCells()
    {
        return rows * columns;
    }

    public Grid(String bottomRight)
    {
        String letterRows = bottomRight.substring(0, 1);
        rows = letters.indexOf(letterRows)+1;
        columns =  Integer.parseInt(bottomRight.substring(1));
        prices = new int[rows][columns];
    }

    public void setPrice(int price)
    {
        prices[row][column] = price;
        row = (row + 1) % rows;
        column = (column + 1) % columns;
    }

    public int getPrice(String cell)
    {
        char row = cell.charAt(0);
        int r = Character.getNumericValue(row);
        int c = Integer.parseInt(cell.substring(1));
        return prices[r][c];
    }
}
