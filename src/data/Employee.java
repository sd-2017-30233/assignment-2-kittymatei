package data;

import service.BookService;
import service.EmployeeService;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Cristina on 4/12/2017.
 */
public class Employee extends User implements Serializable {
    private String name;

    public Employee(String username, String password, String name)
    {
        super(username,password);
        this.name=name;
    }
    public Employee(String username, String password)
    {
        super(username,password);
        this.name="";
    }

    public Employee ()
    {
        super("","");
        this.name="";
    }


    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name=name;
    }

    public boolean logIn()
    {
        EmployeeService es=new EmployeeService();
        return es.verify(getUsername(),getPassword());
    }

    public ArrayList<Book> getBooksByTitle(String title)
    {
        BookService bs=new BookService();
        return bs.searchByTitle(title);
    }
    public ArrayList<Book> getBooksByAuthor(String author)
    {
        BookService bs=new BookService();
        return bs.searchByAuthor(author);
    }
    public ArrayList<Book> getBooksByGenre(String genre)
    {
        BookService bs=new BookService();
        return bs.searchByGenre(genre);
    }

    public boolean sellBook(String title, int quantity)
    {
        BookService bs=new BookService();
        int q=bs.getQuantity(title);
        if(q<0 || q<quantity)
            return false;
        else
        {
            bs.updateQuantity(title,q-quantity);
            return true;
        }
    }

    public static String[] getFields()
    {
        return new String[] {"NAME","USERNAME","PASSWORD"};
    }

    public static String[][] getFieldValues(ArrayList<Employee> array)
    {
        String[][] o=new String[100][3];
        int i=0;
        for (Employee e:array)
        {
            o[i][0]=e.getName();
            o[i][1]=e.getUsername();
            o[i][2]=e.getPassword();
            i++;
        }
        return o;
    }
}
