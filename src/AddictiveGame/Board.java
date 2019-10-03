package AddictiveGame;

import java.util.HashMap;

public class Board {
    int rows;
    int columns;

    HashMap<Integer, Coordinate> valueToCoord;
    HashMap<Coordinate, Integer> coordToValue;



    public Board(int rows, int columns)
    {
        this.rows = rows;
        this.columns = columns;
        valueToCoord = new HashMap<>();
        coordToValue = new HashMap<>();
        int value = 0;
        for (int r = 1; r < rows+1; r++)
        {
            for (int c = 1; c < columns+1; c++)
            {
                int rs = r % rows;
                int cs = c % columns;
                if (rs == 0) rs = rows;
                if (cs == 0) cs = columns;
                value+=1;
                put(value, rs, cs);
            }
        }
    }

    public void put(int value, int row, int column)
    {
        Coordinate coordinate = new Coordinate(row, column);
        coordToValue.put(coordinate, value);
        valueToCoord.put(value, coordinate);
    }

    public Coordinate getCoord(int value)
    {
        return valueToCoord.get(value);
    }

    public int getValue(int row, int column)
    {
        Coordinate c = new Coordinate(row, column);
        return coordToValue.get(c);
    }
}




