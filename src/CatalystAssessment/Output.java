package CatalystAssessment;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Output {

    static String l;

    static int test = 0;


    public static void Output(Image[] data, int level)
    {
        l = level + " ";
        if (level == 1)
        {
            OutputTimestamps(data);
        }
        if (level == 2)
        {
            OutPutOccurrences(data);
        }

    }


    private static void OutputTimestamps(Image[] data)
    {
        int[] result = Arrays.stream(data).filter(i -> i.containsAsteroid()).sorted((a, b) -> a.timestamp > b.timestamp ? 1 : b.timestamp > a.timestamp ? -1 : 0).mapToInt(i -> i.timestamp).toArray();
        OutputArray(result);
    }

    private static void OutPutOccurrences(Image[] data)
    {

        Stream<Image> ordered = Arrays.stream(data).filter(i -> i.containsAsteroid()).sorted((a, b) -> a.timestamp > b.timestamp ? 1 : b.timestamp > a.timestamp ? -1 : 0);
        var x = ordered.collect(Collectors.groupingBy(i -> i.getShape()));
        System.out.println(x);

      //  OutputArray(result);
    }

    private static void OutputArray(int[] data)
    {
        ArrayList<String> lines = new ArrayList<>();
        for (int i = 0; i < data.length; i++)
        {
            lines.add(" " + data[i]);
        }
        toFile(lines);
    }


    private static void toFile(List<String> lines)
    {
        Path file = Paths.get("out-" + l + "-" + test++);
        try {
            Files.write(file, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
