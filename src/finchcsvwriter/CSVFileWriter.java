package finchcsvwriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Generates CSV files from CSV datatype.
 * 
 * @author Theo Last.
 * @version 22/2/23
 */
public class CSVFileWriter {

    private CSVFileWriter() {
    }

    /**
     * generates and writes a csv file to the filepath sent in.
     * 
     * @param identifier unique identifer to distinguish files
     * @param filepath   where to save the file
     * @return the file that was created.
     * @throws FileNotFoundException if the identifier does not hold anything
     */
    public static File writeCSVFile(CSVFile csvFile, String filepath) {
        filepath = filepath.replace(".csv", "");
        File file = new File(filepath + ".csv");
        try (PrintWriter printWriter = new PrintWriter(file)) {
            printWriter.println(csvFile);
        } catch (IOException e) {
            System.err.println("Cannot write to file.");
        }
        return file;
    }
}
