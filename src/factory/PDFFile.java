package factory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import data.Book;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Cristina on 4/12/2017.
 */
public class PDFFile extends File {

    private Document document;

    public PDFFile(String name, String start)
    {
        super(start);
        try {
            PdfWriter writer = new PdfWriter(name);
            PdfDocument pdf = new PdfDocument(writer);
            document = new Document(pdf);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveFile(String[] str)
    {
        document.add(new Paragraph(start));
        for(int i=0;i<str.length;i++) {
            if(str[i]!= null)
                document.add(new Paragraph(str[i]));
            else break;

        }
        document.close();
    }
}
