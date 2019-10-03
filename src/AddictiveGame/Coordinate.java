package AddictiveGame;

public class Coordinate {
    int column;
    int row;
    public Coordinate(int row, int column)
    {
        this.column = column;
        this.row = row;
    }

    @Override
    public String toString()
    {
        return row + " " + column;
    }
}
