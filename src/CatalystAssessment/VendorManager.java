package CatalystAssessment;

import java.util.ArrayList;

public class VendorManager extends AbstractManager {

    private static VendorManager instance;

    public static void main(String[] args)
    {
        instance = new VendorManager();
        instance.init();
     //   instance.runLevel(1);
        instance.runLevel(2);
//        instance.runLevel(3);
//        instance.runLevel(4);
    }
    @Override
    public void init() {
        processor = new VendorProcessor();
        output = new VenderOutput();
        ArrayList<String> levelOneFiles = new ArrayList<>();
        levelOneFiles.add("lvl-1-0-v");
        levelOneFiles.add("lvl-1-1-v");
        levelOneFiles.add("lvl-1-2-v");
        levelOneFiles.add("lvl-1-3-v");
        levelOneFiles.add("lvl-1-4-v");

        instance.files.put(1, levelOneFiles);

        ArrayList<String> levelTwoFiles = new ArrayList<>();
        levelTwoFiles.add("lvl-2-0-v");
        levelTwoFiles.add("lvl-2-1-v");
        levelTwoFiles.add("lvl-2-2-v");
        levelTwoFiles.add("lvl-2-3-v");
        levelTwoFiles.add("lvl-2-4-v");

        instance.files.put(2, levelTwoFiles);
    }
}
