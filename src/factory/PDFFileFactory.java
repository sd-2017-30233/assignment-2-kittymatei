package factory;

/**
 * Created by Cristina on 4/12/2017.
 */
public class PDFFileFactory extends FileFactory {
    public File buildFile()
    {
        PDFFile file=new PDFFile("PDFReport.pdf","Books out of stock: ");
        return file;
    }
}
