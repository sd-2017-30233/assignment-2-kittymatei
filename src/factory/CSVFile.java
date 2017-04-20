package factory;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVWriter;
import data.Book;

/**
 * Created by Cristina on 4/12/2017.
 */
public class CSVFile extends File {

    private CSVWriter writer;

    public CSVFile(String name, String start)
    {
        super(start);
        try {
            writer = new CSVWriter(new FileWriter(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveFile(String[] str)
    {
        try {
            String[] s=start.split(", ");
            writer.writeNext(s);
            for(int i=0;i<str.length;i++) {
                if(str[i]!=null) {
                    String[] record = str[i].split(", ");
                    writer.writeNext(record);
                }else break;
            }
            writer.close();
        } catch (IOException e) {
        e.printStackTrace();
    }
    }
}
