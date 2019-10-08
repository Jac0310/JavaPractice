package CatalystAssessment;

import java.util.ArrayList;

public class AsteroidManager extends AbstractManager {

    public static AsteroidManager instance;

    public static void main(String[] args)
    {
        instance = new AsteroidManager();
        instance.init();
        instance.runLevel(1);
        instance.runLevel(2);
//        instance.runLevel(3);
//        instance.runLevel(4);
    }



//    public void readProcessOutput(String filename, int level)
//    {
//        Reader reader = new Reader();
//        AsteroidProcessor asteroidProcessor = new AsteroidProcessor();
//        ArrayList<int[]> data = reader.read(filename);
//        Image[] images = asteroidProcessor.process1(data);
//        AsteroidOutput.AsteroidOutput(images, level);
//    }

    @Override
    public void init() {

        processor = new AsteroidProcessor();
        output = new AsteroidOutput();
        ArrayList<String> levelOneFiles = new ArrayList<>();
        levelOneFiles.add("lvl1-0.inp");
        levelOneFiles.add("lvl1-1.inp");
        levelOneFiles.add("lvl1-2.inp");
        levelOneFiles.add("lvl1-3.inp");
        levelOneFiles.add("lvl1-4.inp");

        instance.files.put(1, levelOneFiles);

        ArrayList<String> levelTwoFiles = new ArrayList<>();
        levelTwoFiles.add("lvl2-0.inp");
        levelTwoFiles.add("lvl2-1.inp");
        levelTwoFiles.add("lvl2-2.inp");
        levelTwoFiles.add("lvl2-3.inp");
        levelTwoFiles.add("lvl2-4.inp");

        instance.files.put(2, levelTwoFiles);


//        ArrayList<String> levelThreeFiles = new ArrayList<>();
//        levelThreeFiles.add("lvl3-0.inp");
//        levelThreeFiles.add("lvl3-1.inp");
//        levelThreeFiles.add("lvl3-2.inp");
//        levelThreeFiles.add("lvl3-3.inp");
//        levelThreeFiles.add("lvl3-4.inp");
//
//        instance.files.put(3, levelThreeFiles);
//
//        ArrayList<String> levelFourFiles = new ArrayList<>();
//        levelFourFiles.add("lvl4-0.inp");
//        levelFourFiles.add("lvl4-1.inp");
//        levelFourFiles.add("lvl4-2.inp");
//        levelFourFiles.add("lvl4-3.inp");
//        levelFourFiles.add("lvl4-4.inp");
//
//        instance.files.put(4, levelFourFiles);

    }
}
