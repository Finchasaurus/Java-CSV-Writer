package finchcsvwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Generates CSV files from CSV datatype.
 * 
 * @author Theo Last.
 * @version 22/2/23
 */
public class CSVFileWriter {
    // holds all csv datatypes.
    private static Map<String, CSVFile> files = new HashMap<>();

    private CSVFileWriter() {
    }

    /**
     * creates a csv file so you can add things. can override.
     * 
     * @param identifier unique identifier to distinguish files due to files being
     *                   able to be named the same thing
     * @return the created file datatype.
     */
    public static CSVFile createCSVFile(String identifier) {
        CSVFile csv = new CSVFile();
        files.put(identifier, csv);
        return csv;
    }

    /**
     * generates and writes a csv file to the filepath sent in.
     * 
     * @param identifier unique identifer to distinguish files
     * @param filepath   where to save the file
     * @return the file that was created.
     * @throws FileNotFoundException if the identifier does not hold anything
     */
    public static File writeCSVFile(String identifier, String filepath) throws FileNotFoundException {
        if (!files.containsKey(identifier))
            throw new FileNotFoundException();
        filepath.replace(filepath, ".csv");
        CSVFile csvData = files.get(identifier);
        File file = new File(filepath + ".csv");
        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.println(csvData);
        } catch (IOException e) {
            System.err.println("Cannot write to file.");
        }
        return file;
    }
}
