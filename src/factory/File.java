package factory;

import data.Book;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Cristina on 4/12/2017.
 */
public abstract class File {
    public String start;
    public File(String s)
    {
        start=s;
    }
    public abstract void saveFile(String[] str);
}
