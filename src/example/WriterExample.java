package example;

import java.io.FileNotFoundException;

import javax.naming.NameNotFoundException;

import finchcsvwriter.CSVFile;
import finchcsvwriter.CSVFileWriter;

public class WriterExample {
    public static void main(String[] args) throws NameNotFoundException, FileNotFoundException {

        // creating the file internatlly.
        CSVFile petFile = CSVFileWriter.createCSVFile("PetList");

        // creating initial headers
        // you can add multiple
        petFile.addHeaders("Cats", "Dogs");
        // or just one
        petFile.addHeader("Kids");

        // oops, Kids are not pets
        petFile.setHeader("Raccoons", 2);

        // lets add some pets.
        // you can add one data at a time
        petFile.addData("Dogs", "Rover");
        petFile.addData("Dogs", "Bone Man");
        petFile.addData("Dogs", "Link");
        petFile.addData("Raccoons", "Gud boi");
        // or multple
        petFile.addData("Cats", "Suzie", "David", "Cookie", "Cupcake", "Grace");
        // oops, the raccoon was misspelled
        petFile.setData("Raccoons", "Good Boy", 0);

        // you can include the file type
        CSVFileWriter.writeCSVFile("PetList", "src/example/pets.csv");
        // or not, its up to you
        CSVFileWriter.writeCSVFile("PetList", "src/example/pets");
    }
}
