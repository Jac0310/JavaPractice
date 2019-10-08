package CatalystAssessment;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class AbstractManager {

    public HashMap<Integer, ArrayList<String>> files = new HashMap<>();

    public AbstractProcessor processor;

    public AbstractOutput output;




    public abstract void init();

    public void runLevel(int level)
    {
        ArrayList<String> levelFiles = files.get(level);
        levelFiles.stream().forEach(f -> readProcessOutput(f, level));
    }

    public void readProcessOutput(String filename, int level)
    {
        Reader reader = new Reader();
        ArrayList<int[]> data = reader.read(filename);
        Object[] things = processor.process(data);
        output.output(things, level);
    }
}
