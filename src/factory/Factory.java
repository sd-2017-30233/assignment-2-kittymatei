package factory;

/**
 * Created by Cristina on 4/12/2017.
 */
public class Factory {
    public File getFile(String s)
    {
        if(s==null)
            return null;
        if(s.equalsIgnoreCase("PDF"))
        {
            PDFFileFactory f=new PDFFileFactory();
            return f.buildFile();
        }
        if(s.equalsIgnoreCase("CSV"))
        {
            CSVFileFactory f=new CSVFileFactory();
            return f.buildFile();
        }
        return null;
    }
}
