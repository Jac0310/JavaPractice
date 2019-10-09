package CatalystAssessment;

import java.util.ArrayList;

public class CatalystManager extends AbstractManager {

    public static CatalystManager instance;

    public static void main(String[] args)
    {
        instance = new CatalystManager();
        instance.init();
  //      instance.runLevel(1);
        instance.runLevel(2);
//        instance.runLevel(3);
//        instance.runLevel(4);
    }
    @Override
    public void init() {
        processor = new CatalystProcessor();
        output = new CatalystOutput();
        ArrayList<String> levelOneFiles = new ArrayList<>();
        levelOneFiles.add("level1-1.in");
        levelOneFiles.add("level1-2.in");
        levelOneFiles.add("level1-3.in");
        levelOneFiles.add("level1-4.in");
        levelOneFiles.add("level1-5.in");

        instance.files.put(1, levelOneFiles);

        ArrayList<String> levelTwoFiles = new ArrayList<>();
        levelTwoFiles.add("level1-1.in");
        levelTwoFiles.add("level1-2.in");
        levelTwoFiles.add("level1-3.in");
        levelTwoFiles.add("level1-4.in");
        levelTwoFiles.add("level1-5.in");

        instance.files.put(2, levelTwoFiles);

        ArrayList<String> levelThreeFiles = new ArrayList<>();
        levelThreeFiles.add("");
        levelThreeFiles.add("");
        levelThreeFiles.add("");
        levelThreeFiles.add("");
        levelThreeFiles.add("");
        levelThreeFiles.add("");

        instance.files.put(3, levelThreeFiles);

        ArrayList<String> levelFourFiles = new ArrayList<>();
        levelFourFiles.add("");
        levelFourFiles.add("");
        levelFourFiles.add("");
        levelFourFiles.add("");
        levelFourFiles.add("");

        instance.files.put(4, levelFourFiles);

    }
}
