package CatalystAssessment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Reader {


    public ArrayList<int[]> read(String fileName)
    {
        String line;
        String result = null;
        ArrayList<int[]> rows = new ArrayList<>();

        fileName = "src/CatalystAssessment/" + fileName;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                // System.out.println(line);
                result = line;
                int[] row = Arrays.stream(result.split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
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

//        int[][] data = new int[rows.size()][rows.get(0).length];
//        for (int i = 0; i < rows.size(); i++)
//        {
//            data[i] = rows.get(i);
//        }
//        return data;
    }
}
