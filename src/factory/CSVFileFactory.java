package factory;

/**
 * Created by Cristina on 4/12/2017.
 */
public class CSVFileFactory extends FileFactory {
    public File buildFile()
    {
        CSVFile file=new CSVFile("CSVReport.csv", "Title, Author, Genre, Price");
        return file;
    }
}
