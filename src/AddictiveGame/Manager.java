package AddictiveGame;

import java.util.Arrays;

public class Manager {


    public static void main(String[] args)
    {

     //   levelOneTest();
        levelTwoTest();

    }

    public static Board initializeBoard(int rows, int columns)
    {
        Board board = new Board(rows, columns);
        return board;
    }

    public static void levelOneTest()
    {
        readAndProcess1("level1-0.in");
        readAndProcess1("level1-1.in");
        readAndProcess1("level1-2.in");
        readAndProcess1("level1-3.in");
    }

    public static void levelTwoTest()
    {
        readAndProcess2("level2-0.in");
        readAndProcess2("level2-1.in");
        readAndProcess2("level2-2.in");
        readAndProcess2("level2-3.in");
    }

    private static void readAndProcess1(String fileName)
    {
        Processor processor = new Processor();
        DataReader dataReader = new DataReader();
        int[] input0 = dataReader.readfile(fileName);
        processor.process1(input0);
    }

    private static void readAndProcess2(String fileName)
    {
        Processor processor = new Processor();
        DataReader dataReader = new DataReader();
        int[] input0 = dataReader.readfile(fileName);
        processor.process2(input0);
    }

}
