package CatalystAssessment;

import java.util.ArrayList;
import java.util.Arrays;

public class Star {

    public int[] lightPlot; //could extend to a collection of plots

    public String name;


    private int zero;
    private ArrayList<Event> events;

    public Star(String name, int[] plot)
    {
        this.name = name;
        this.lightPlot = plot;
        zero = 1000000;
        events = new ArrayList<>();
        characteriseEvents();

    }

    public void characteriseEvents()
    {
        String occurences = getOccurencePlot();
        String[] plot = occurences.split(" ");
        plot = Arrays.copyOfRange(plot, 1, plot.length);
        for (int i = 1; i < plot.length; i += 2)
        {
            Event e = new Event(Double.parseDouble(plot[i-1]), Integer.parseInt(plot[i]));
            events.add(e);
        }
    }

    public int getFlairCount()
    {
        return (int) events.stream().filter(e -> isFlair(e)).count();
    }

    public boolean isFlair(Event e)
    {
        if (e.value > zero)
        {
            int x = 6;
        }
        return e.value > zero;
    }

    public int getTransitCount()
    {
        return (int) events.stream().filter(e -> isTransit(e)).count();
    }

    public boolean isTransit(Event e)
    {
        double diff = (zero-e.value);
        double percentage = (diff / (double) zero) * 100;
        boolean result = e.length >= 5 && e.length <= 15 && percentage >= 0.5;
    //    boolean result = e.length >= 5 && percentage >= 0.5;
        return result;
    }




    public String getOccurencePlot()
    {
        String result = name + "";
        int[] data = lightPlot.clone();
        int value = 0;
        while (data.length > 1)
        {
            value = data[0];

            int occurence = countOccurence(value, data);
            data = Arrays.copyOfRange(data, occurence, data.length);
            if (data.length == 1 && data[0] == value)
            {
                occurence++;
            }
            result +=  " " + value + " " + occurence;
        }
        if (data[0] != value) result += " " + data[0] + " " + 1;
        return result;
    }

    public int countOccurence(int value, int[] array)
    {
        int occurence = 0;
        int x = value;
        while(x == value && array.length > 1)
        {
            array = Arrays.copyOfRange(array, 1, array.length);
            x = array[0];
            occurence++;
        }
        return occurence;
    }
}
