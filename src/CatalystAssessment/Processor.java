package CatalystAssessment;

import java.util.ArrayList;
import java.util.Arrays;

public class Processor {

    public Image[] process1(ArrayList<int[]> data)
    {
        int startTimeStamp = data.get(0)[0];
        int endTimeStamp = data.get(0)[1];
        int imageCount = data.get(0)[2];
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


    public Image processImage(ArrayList<int[]> data)
    {
        int timestamp = data.get(0)[0];
        int rowcount = data.get(0)[1];
        int colcount = data.get(0)[2];
        data.remove(0);
        int[][] ary = new int[rowcount][colcount];
        for (int r = 0; r < rowcount; r++)
        {
            for (int c = 0; c < colcount; c++)
            {
                ary[r][c] = data.get(r)[c];
            }
        }
        return new Image(ary, timestamp);
    }
}
