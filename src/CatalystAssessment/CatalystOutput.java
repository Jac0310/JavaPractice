package CatalystAssessment;

import java.util.ArrayList;
import java.util.List;

public class CatalystOutput extends AbstractOutput {
    @Override
    public void output(Object[] data, int level) {

      //  Image[] images = (Image[])data;
        l = level + " ";
        List<String> result = new ArrayList<>();
        if (level == 1)
        {
            Star[] stars = (Star[]) data;
            String s = getOccurences(stars);
            result.add(s.trim());
            toFile(result);
        }
        if (level == 2)
        {
            Star[] stars = (Star[]) data;
            String ss = "";

            for (Star s: stars
                 ) {
                int flair = s.getFlairCount();
                int trans = s.getTransitCount();
                //if (flair > 0 || trans > 0)
                ss += " " + s.name + " " + flair + " " + trans;
            }
            result.add(ss.trim());
            toFile(result);
        }

    }

    public String getOccurences(Star[] stars)
    {
        String result = "";
        for (Star s: stars
             ) {
            String occurences = " " + s.getOccurencePlot();
            result += occurences;
        }
        return result;

    }

    //helper methods
}
