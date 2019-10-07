package CatalystAssessment;

import java.util.ArrayList;

public class Manager {

    public static void main(String[] args)
    {
       // levelOne();
        levelTwo();
    }



    public static void levelOne()
    {
        readProcessOutput("lvl1-0.inp", 1);
        readProcessOutput("lvl1-1.inp", 1);
        readProcessOutput("lvl1-2.inp", 1);
        readProcessOutput("lvl1-3.inp", 1);
        readProcessOutput("lvl1-4.inp", 1);
    }

    public static void levelTwo()
    {
        readProcessOutput("lvl2-0.inp", 2);
        readProcessOutput("lvl2-1.inp", 2);
        readProcessOutput("lvl2-2.inp", 2);
        readProcessOutput("lvl2-3.inp", 2);
        readProcessOutput("lvl2-4.inp", 2);
    }


    public static void readProcessOutput(String filename, int level)
    {
        Reader reader = new Reader();
        Processor processor = new Processor();
        ArrayList<int[]> data = reader.read(filename);
        Image[] images = processor.process1(data);
        Output.Output(images, level);
    }
}
