package CatalystAssessment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Reader {


    public ArrayList<String[]> read(String fileName)
    {
        String line;
        String result = null;
        ArrayList<String[]> rows = new ArrayList<>();

        fileName = "src/CatalystAssessment/" + fileName;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                // System.out.println(line);
                result = line;
                String[] row = Arrays.stream(result.split(" ")).toArray(String[]::new);
                rows.add(row);
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        }
        catch(IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        return rows;
    }
}
