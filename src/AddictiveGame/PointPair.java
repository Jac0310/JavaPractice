package AddictiveGame;

public class PointPair {
    Point p1;
    Point p2;
    int ManhattanDifference;

    public PointPair(Point p1, Point p2)
    {
        this.p1 = p1;
        this.p2 = p2;
        ManhattanDifference = Math.abs(p1.getRow() - p2.getRow()) + Math.abs(p1.getColumn() - p2.getColumn());
    }
}
