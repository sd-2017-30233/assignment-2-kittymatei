package data;
import factory.Factory;
import factory.File;
import service.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Cristina on 4/12/2017.
 */
public class Admin extends User implements Serializable{
    public Admin(String username, String password)
    {
        super(username,password);
    }
    public Admin (){super("","");}

    public boolean logIn()
    {
        AdminService as=new AdminService();
        return as.verify(getUsername(),getPassword());
    }

    public boolean addBook(Book b)
    {
        BookService bs=new BookService();
        return bs.addBook(b.getTitle(),b.getAuthor(),b.getGenre(),b.getQuantity(),b.getPrice());
    }

    public boolean deleteBook(String title)
    {
        BookService bs=new BookService();
        return bs.deleteBook(title);
    }

    public boolean updateBookPrice(String title, float newPrice)
    {
        BookService bs=new BookService();
        return bs.updatePrice(title,newPrice);
    }

    public boolean addBookQuantity(String title, int newQuantity)
    {
        BookService bs=new BookService();
        int quantity=bs.getQuantity(title);
        if(quantity>=0)
            return bs.updateQuantity(title, newQuantity+quantity);
        return false;
    }

    public ArrayList<Book> viewAllBooks()
    {
        BookService bs=new BookService();
        return bs.viewAll();
    }

    public boolean addEmployee(Employee e)
    {
        EmployeeService es=new EmployeeService();
        return es.addEmployee(e.getName(),e.getUsername(),e.getPassword());
    }

    public boolean deleteEmployee(String name)
    {
        EmployeeService es=new EmployeeService();
        return es.deleteEmployee(name);
    }

    public boolean updateEmployeePassword(String name, String newPassword)
    {
        EmployeeService es=new EmployeeService();
        return es.updatePassword(name, newPassword);
    }

    public ArrayList<Employee> viewAllEmployees()
    {
        EmployeeService es=new EmployeeService();
        return es.viewAll();
    }

    public void generateReportFile(String fileType)
    {
        BookService bs=new BookService();
        ArrayList<Book> array=bs.getOutOfStock();
        String[] str=new String[10];
        int i=0;
        for(Book b: array)
        {
            str[i]=b.getTitle()+", "+b.getAuthor()+", "+b.getGenre()+", "+b.getPrice()+" RON";
            i++;
        }
        Factory f=new Factory();
        File file=f.getFile(fileType);
        file.saveFile(str);
    }


}
