package data;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Cristina on 4/12/2017.
 */
public class Book implements Serializable {
    private String title;
    private String author;
    private String genre;
    private int quantity;
    private float price;

    public Book()
    {
        title="";
        author="";
        genre="";
        quantity=0;
        price=0;
    }
    public Book(String title, String author, String genre, int quantity, float price)
    {
        this.title=title;
        this.author=author;
        this.genre=genre;
        this.quantity=quantity;
        this.price=price;
    }

    public String getTitle()
    {
        return title;
    }
    public String getAuthor()
    {
        return author;
    }
    public String getGenre()
    {
        return genre;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public float getPrice()
    {
        return price;
    }
    public void setTitle(String title)
    {
        this.title=title;
    }
    public void setAuthor(String author)
    {
        this.author=author;
    }
    public void setGenre(String genre)
    {
        this.genre=genre;
    }
    public void setQuantity(int quantity)
    {
        this.quantity=quantity;
    }
    public void setPrice(float price)
    {
        this.price=price;
    }

    public static String[] getFields()
    {
        return new String[] {"TITLE","AUTHOR","GENRE","QUANTITY","PRICE"};
    }

    public static String[][] getFieldValues(ArrayList<Book> array)
    {
        String[][] o=new String[100][5];
        int i=0;
        for (Book b:array)
        {
            o[i][0]=b.getTitle();
            o[i][1]=b.getAuthor();
            o[i][2]=b.getGenre();
            o[i][4]=String.valueOf(b.getPrice());
            o[i][3]=String.valueOf(b.getQuantity());
            i++;
        }
        return o;
    }



}
