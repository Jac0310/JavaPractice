package CatalystAssessment;
import java.util.*;

import java.util.stream.Collectors;


public class AsteroidOutput extends AbstractOutput {


    @Override
    public void output(Object[] data, int level)
    {
        Image[] images = (Image[])data;
        l = level + "";
        if (level == 1)
        {
            OutputTimestamps(images);
        }
        if (level == 2)
        {
            OutPutOccurrences(images);
        }
    }


    private void OutputTimestamps(Image[] data)
    {
        int[] result = Arrays.stream(data).filter(i -> i.containsAsteroid()).sorted((a, b) -> a.timestamp > b.timestamp ? 1 : b.timestamp > a.timestamp ? -1 : 0).mapToInt(i -> i.timestamp).toArray();
        OutputArray(result);
    }

    private void OutPutOccurrences(Image[] data)
    {

        Image[] ordered = Arrays.stream(data).filter(i -> i.containsAsteroid()).sorted((a, b) -> a.timestamp > b.timestamp ? 1 : b.timestamp > a.timestamp ? -1 : 0).toArray(Image[]::new);
        Map<Shape, Long> shapeOccurence = Arrays.stream(ordered).collect(Collectors.groupingBy(Image::getShape, Collectors.counting()));
        ArrayList<String> result = new ArrayList<>();
        for (Image img: ordered
             ) {

            Image[] occurrences = Arrays.stream(data).filter(i -> i.getShape().equals(img.getShape())).toArray(Image[]::new);
            int first = occurrences[0].timestamp;
            int last = occurrences[occurrences.length-1].timestamp;

            String line = first + " " + last + " " + occurrences.length;
            if (!result.contains(line)) result.add(line);
        }
        toFile(result);
    }



}
