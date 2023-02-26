package example;

import java.io.FileNotFoundException;

import javax.naming.NameNotFoundException;

import finchcsvwriter.CSVFile;
import finchcsvwriter.CSVFileWriter;

public class ChainingExample {
    public static void main(String[] args) throws NameNotFoundException, FileNotFoundException {
        // PLEASE DO NOT DO THIS!!!
        CSVFile chainingFile = new CSVFile();
        chainingFile.addHeaders("Chaining", "Example").addData("Chaining", "ChainingData")
                .addData("Chaining", "ChainingData").addData("Chaining", "ChainingData")
                .addData("Chaining", "ChainingData").addData("Chaining", "ChainingData")
                .addData("Chaining", "ChainingData").addData("Chaining", "ChainingData")
                .addData("Chaining", "ChainingData").addData("Example", "Example Stuff")
                .addData("Example", "Example Stuff").addData("Example", "Example Stuff")
                .addData("Example", "Example Stuff").addData("Example", "Example Stuff")
                .addData("Example", "Example Stuff").addData("Example", "Example Stuff")
                .addData("Example", "Example Stuff").addData("Example", "Example Stuff")
                .addData("Example", "Example Stuff").addData("Example", "Example Stuff")
                .addData("Example", "Example Stuff").addData("Example", "Example Stuff")
                .addData("Example", "Example Stuff").addData("Example", "Example Stuff")
                .addData("Example", "Example Stuff").addData("Example", "Example Stuff")
                .addData("Example", "Example Stuff").addData("Example", "Example Stuff");

        CSVFileWriter.writeCSVFile(chainingFile, "src/example/DO_NOT_DO_THIS");
    }
}
