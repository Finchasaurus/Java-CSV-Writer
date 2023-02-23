package finchcsvwriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NameNotFoundException;

/**
 * The datatype holding a CSV File.
 * 
 * @author Theo Last.
 * @version 22/2/23
 */
public class CSVFile {
    // holds headers
    private ArrayList<String> headers = new ArrayList<>();
    // holds data
    private Map<String, ArrayList<String>> data = new HashMap<>();

    CSVFile() {
    }

    /**
     * adds a single header to the file. internally creates a new column
     * automatically.
     * 
     * @param header the title of the header.
     * @return
     */
    public CSVFile addHeader(String header) {
        headers.add(header);
        data.put(header, new ArrayList<>());
        return this;
    }

    /**
     * adds multiple headers to the file. internally calls addHeader() individually.
     * 
     * @param headers
     * @return
     */
    public CSVFile addHeaders(String... headers) {
        for (String header : headers)
            addHeader(header);
        return this;
    }

    /**
     * sets an existing header to a differnt name
     * 
     * @param header the title of the new header
     * @param index  where do you want it
     * @return
     * @throws IndexOutOfBoundsException throws if the header does not exist.
     */
    public CSVFile setHeader(String header, int index) throws IndexOutOfBoundsException {
        ArrayList<String> d = data.get(headers.get(index));
        data.remove(headers.get(index));
        headers.set(index, header);
        data.put(header, d);
        return this;
    }

    /**
     * adds a single point of data to a column
     * 
     * @param header    under which header do you want your data.
     * @param dataPoint what the data is
     * @return
     * @throws NameNotFoundException if the header does not exist
     */
    public CSVFile addData(String header, String dataPoint) throws NameNotFoundException {
        if (!data.containsKey(header))
            throw new NameNotFoundException();
        data.get(header).add(dataPoint);

        return this;
    }

    /**
     * adds data points to a column.
     * 
     * @param header    under which header do you want your data.
     * @param dataPoint what the data is
     * @return
     * @throws NameNotFoundException if the header does not exist
     */
    public CSVFile addData(String header, String... dataPoints) throws NameNotFoundException {
        for (String dataPoint : dataPoints)
            addData(header, dataPoint);

        return this;
    }

    /**
     * sets existing data to another datapoint.
     * 
     * @param header    under which header do you want your data.
     * @param dataPoint what the new data is
     * @param index     where do you want the data.
     * @return
     * @throws NameNotFoundException if the header does not exist
     */
    public CSVFile setData(String header, String dataPoint, int index) throws NameNotFoundException {
        if (!data.containsKey(header))
            throw new NameNotFoundException();
        data.get(header).set(index, dataPoint);
        return this;
    }

    private StringBuilder headersToString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String header : headers) {
            stringBuilder.append(header);
            if (headers.indexOf(header) != headers.size() - 1)
                stringBuilder.append(",");
        }
        return stringBuilder;
    }

    private StringBuilder dataToString() {
        StringBuilder stringBuilder = new StringBuilder();
        int largestDataSize = getLargestDataSize();
        for (int i = 0; i < largestDataSize; i++) {
            stringBuilder.append("\n");
            for (int j = 0; j < headers.size(); j++) {
                if (data.get(headers.get(j)).size() > i) {
                    stringBuilder.append(data.get(headers.get(j)).get(i));
                }
                if (j != headers.size() - 1)
                    stringBuilder.append(",");
            }
        }
        return stringBuilder;
    }

    private int getLargestDataSize() {
        int largest = 0;
        for (ArrayList<String> dp : data.values()) {
            if (dp.size() > largest)
                largest = dp.size();
        }
        return largest;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(headersToString());
        stringBuilder.append(dataToString());
        return stringBuilder.toString();
    }
}
