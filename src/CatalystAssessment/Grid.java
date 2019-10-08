package CatalystAssessment;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid {
    int[][] prices;
    int[][] stocks;
    private String[] ltrs = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private List<String> letters = Arrays.asList(ltrs);

    private int prow = 0;
    private int pcolumn = 0;

    private int srow = 0;
    private int scolumn = 0;

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
        stocks = new int[rows][columns];
    }

    public Grid(int[][] prices, int[][] stocks)
    {
        this.prices = Arrays.copyOf(prices, prices.length);
        this.stocks = Arrays.copyOf(stocks, prices.length);
        this.rows = prices.length+1;
        this.columns = prices[0].length+1;

    }

    public void setPrice(int price)
    {
        prices[prow][pcolumn] = price;
        pcolumn = pcolumn + 1;
        if (pcolumn == columns)
        {
            prow = prow + 1;
            pcolumn = 0;
        }
    }

    public void setStock(int stock)
    {
        stocks[srow][scolumn] = stock;
        scolumn = scolumn + 1;
        if (scolumn == columns)
        {
            srow = srow + 1;
            scolumn = 0;
        }
    }

    public int getPrice(String cell)
    {
        String letter = cell.substring(0, 1);
        int r = letters.indexOf(letter);
        int c = Integer.parseInt(cell.substring(1))-1;
        return prices[r][c];
    }

    public int getRevenue(Grid start, Grid end)
    {
        int revenue = 0;
        for (int r = 0; r < start.stocks.length; r++)
        {
            for (int c = 0; c < start.stocks[0].length; c++)
            {
                int diff = start.stocks[r][c] - end.stocks[r][c];
                int rev = diff * start.prices[r][c];
                revenue += rev;
            }
        }
        return revenue;
    }



    public Grid processOrder(String[] orders)
    {
        int[][] copyP = new int[prices.length][prices[0].length];
        int[][] copyS = new int[prices.length][prices[0].length];
        for (int i = 0; i < prices.length; i++)
        {
            copyP[i] = prices[i].clone();
            copyS[i] = stocks[i].clone();
        }

        for (String order: orders
             ) {
            String letter = order.substring(0, 1);
            int r = letters.indexOf(letter);
            int c = Integer.parseInt(order.substring(1))-1;
            int stock = copyS[r][c];
            if (stock > 0)
            {
                stock = stock - 1;
                copyS[r][c] = stock;
            }
        }
        Grid result = new Grid(copyP.clone(), copyS.clone());
        return result;
    }
}
