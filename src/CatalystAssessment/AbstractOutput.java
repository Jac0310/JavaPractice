package CatalystAssessment;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractOutput {

    public String l;

    public int test = 0;

    public abstract void output(Object[] data, int level);

    protected void OutputArray(int[] data)
    {
        ArrayList<String> lines = new ArrayList<>();
        for (int i = 0; i < data.length; i++)
        {
            lines.add(" " + data[i]);
        }
        toFile(lines);
    }


    protected void toFile(List<String> lines)
    {
        Path file = Paths.get( this.getClass().getName().replace("CatalystAssessment.", "") +"-" + l + "-" + test++);
        try {
            Files.write(file, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
