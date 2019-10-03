package AddictiveGame;

import java.util.ArrayList;
import java.util.Arrays;

public class Processor {

    public void process1(int[] input)
    {
        Board board = new Board(input[0], input[1]);
        int ps = input[2];
        int[] positions = Arrays.copyOfRange(input, 3, input.length);
        outPutCoordinates(positions, board);
    }

    public void process2(int[] input)
    {
        Board board = new Board(input[0], input[1]);
        int[] ps = Arrays.copyOfRange(input, 3, input.length);
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 1; i < ps.length; i+= 2)
        {
            int p = ps[i-1];
            int c = ps[i];
            Point point = new Point(p, c, board);
            points.add(point);
        }
        points.sort((a, b) -> a.colour > b.colour ? 1 : a.colour < b.colour ? -1 : 0);

        ArrayList<PointPair> pointPairs = new ArrayList<>();
        for (int i = 1; i < points.size(); i+=2)
        {
            PointPair pointPair = new PointPair(points.get(i-1), points.get(i));
            pointPairs.add(pointPair);
        }

        outPutDistances(pointPairs);
    }

    public void outPutCoordinates(int[] positions, Board board)
    {
        Arrays.stream(positions).forEach(p -> System.out.print(board.getCoord(p) + " "));
        System.out.println();
    }

    public void outPutDistances(ArrayList<PointPair> pairs)
    {
        pairs.stream().forEach(p -> System.out.print(p.ManhattanDifference + " "));
        System.out.println();
    }
}
