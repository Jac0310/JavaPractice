package CatalystAssessment;

import java.util.ArrayList;
import java.util.Arrays;

public class AsteroidProcessor extends AbstractProcessor {

    public Image[] process(ArrayList<String[]> data, int level)
    {

        int startTimeStamp = Integer.parseInt(data.get(0)[0]);
        int endTimeStamp = Integer.parseInt(data.get(0)[1]);
        int imageCount = Integer.parseInt(data.get(0)[2]);
        data.remove(0);
        Image[] images = new Image[imageCount];

        for (int n = 0; n < imageCount; n++)
        {
            Image image = processImage(data);
            for (int i = 0; i < image.array.length; i++)
            {
                data.remove(0);
            }
            images[n] = image;
        }
        return images;
    }


    private Image processImage(ArrayList<String[]> data)
    {
        int timestamp = Integer.parseInt(data.get(0)[0]);
        int rowcount = Integer.parseInt(data.get(0)[1]);
        int colcount = Integer.parseInt(data.get(0)[2]);
        data.remove(0);
        int[][] ary = new int[rowcount][colcount];
        for (int r = 0; r < rowcount; r++)
        {
            for (int c = 0; c < colcount; c++)
            {
                ary[r][c] = Integer.parseInt(data.get(r)[c]);
            }
        }
        return new Image(ary, timestamp);
    }
}
