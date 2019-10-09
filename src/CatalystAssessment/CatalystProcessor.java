package CatalystAssessment;

import java.util.ArrayList;
import java.util.Arrays;

public class CatalystProcessor extends AbstractProcessor {
    @Override
    public Object[] process(ArrayList<String[]> data, int level) {
        String[] d = data.get(0);


        for (int rows = 0; rows < data.size(); rows++)
        {
            if (level == 1 || level == 2)
            {
                int numberOfStars = Integer.parseInt(d[0]);
                d = Arrays.copyOfRange(d, 1, d.length);
                Object[] result = new Star[numberOfStars];
                for (int i = 0; i < numberOfStars; i++)
                {
                    Star s = readStar(d);
                    d = Arrays.copyOfRange(d, s.lightPlot.length+2, d.length);
                    result[i] = s;
                }
                return result;
            }
        }
        return new Object[0];
    }

    public Star readStar(String[] d)
    {
        String name = d[0];
        int lengthOfPlot = Integer.parseInt(d[1]);
        d = Arrays.copyOfRange(d, 2, d.length);
        String[] p = Arrays.copyOfRange(d, 0, lengthOfPlot);
        int[] plot = Arrays.stream(p).mapToInt(s -> Integer.parseInt(s)).toArray();
        return new Star(name, plot);

    }
}
