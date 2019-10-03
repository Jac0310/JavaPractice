package AddictiveGame;

public class Point  {
    Coordinate coordinate;
    int colour;


    public Point(int value, int colour, Board board) {
        this.coordinate = board.getCoord(value);
        this.colour = colour;
    }

    public int getRow()
    {
        return coordinate.row;
    }

    public int getColumn()
    {
        return coordinate.column;
    }
}
