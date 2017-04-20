package presentation;

import data.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Cristina on 4/15/2017.
 */
public class Controller
{
    private View view;

    public Controller()
    {
        view=new View();
        view.bLogIn.addActionListener(new LogInListener());
        view.bLogOut1.addActionListener(new LogOut1Listener());
        view.bLogOut2.addActionListener(new LogOut2Listener());
        view.bSearchTitle.addActionListener(new SearchByTitleListener());
        view.bSearchAuthor.addActionListener(new SearchByAuthorListener());
        view.bSearchGenre.addActionListener(new SearchByGenreListener());
        view.bSell.addActionListener(new SellBookListener());
        view.bAddBook.addActionListener(new AddBookListener());
        view.bDeleteBook.addActionListener(new DeleteBookListener());
        view.bUpdateBookQ.addActionListener(new AddBookQuantityListener());
        view.bUpdateBookP.addActionListener(new UpdateBookPriceListener());
        view.bViewBook.addActionListener(new ViewBookListener());
        view.bAddEmployee.addActionListener(new AddEmployeeListener());
        view.bDeleteEmployee.addActionListener(new DeleteEmployeeListener());
        view.bUpdateEmployee.addActionListener(new UpdateEmployeeListener());
        view.bViewEmployee.addActionListener(new ViewEmployeeListener());
        view.bReport.addActionListener(new ReportListener());
    }

    class LogInListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String comboBox=(String)view.comboLogIn.getSelectedItem();
            String usr=view.tUsername.getText();
            String pwd=view.tPassword.getText();
            if(usr.equals("") || pwd.equals(""))
                JOptionPane.showMessageDialog(null,"Empty fields!", null, JOptionPane.ERROR_MESSAGE);
            else
            {
                if(comboBox.equals("Admin"))
                {
                    Admin a=new Admin(usr,pwd);
                    boolean ok=a.logIn();
                    if(!ok)
                        JOptionPane.showMessageDialog(null,"Username and/or password wrong!", null, JOptionPane.ERROR_MESSAGE);
                    else
                    {
                        view.tUsername.setText("");
                        view.tPassword.setText("");
                        view.panel1.setVisible(false);
                        view.panel3.setVisible(true);
                    }
                }
                else
                {
                    Employee em=new Employee(usr,pwd);
                    boolean ok=em.logIn();
                    if(!ok)
                        JOptionPane.showMessageDialog(null,"Username and/or password wrong!", null, JOptionPane.ERROR_MESSAGE);
                    else
                    {
                        view.tUsername.setText("");
                        view.tPassword.setText("");
                        view.panel1.setVisible(false);
                        view.panel2.setVisible(true);
                    }
                }
            }

        }
    }

    class LogOut1Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            view.panel2.setVisible(false);
            view.panel1.setVisible(true);
        }
    }

    class LogOut2Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            view.panel3.setVisible(false);
            view.panel1.setVisible(true);
        }
    }

    class SearchByTitleListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {

                String s = JOptionPane.showInputDialog(null, "Book title : ");
                if(s!=null)
                    if(s.equals(""))
                        JOptionPane.showMessageDialog(null, "Empty fields!",null,JOptionPane.ERROR_MESSAGE);
                    else
                    {
                        Employee em=new Employee();
                        ArrayList<Book> array=em.getBooksByTitle(s);
                        String[] columns=Book.getFields();
                        String[][] values=Book.getFieldValues(array);

                        DefaultTableModel model=new DefaultTableModel(values,columns);
                        JTable t=new JTable(model);
                        t.setEnabled(false);
                        JDialog dialog=new JDialog();
                        dialog.setBounds(0,0,400,400);
                        dialog.setLocationRelativeTo(null);
                        dialog.setTitle("Books");
                        t.setBackground(new Color(170,200,150));
                        JScrollPane scrollPane3 = new JScrollPane(t);
                        scrollPane3.setBounds(10, 50, 950, 120);
                        scrollPane3.setEnabled(false);
                        dialog.add(scrollPane3);
                        dialog.pack();
                        dialog.setVisible(true);

                    }


        }
    }

    class SearchByAuthorListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {

                String s = JOptionPane.showInputDialog(null, "Book author : ");
                if(s!=null)
                    if(s.equals(""))
                        JOptionPane.showMessageDialog(null, "Empty fields!",null,JOptionPane.ERROR_MESSAGE);
                    else
                    {
                        Employee em=new Employee();
                        ArrayList<Book> array=em.getBooksByAuthor(s);
                        String[] columns=Book.getFields();
                        String[][] values=Book.getFieldValues(array);

                        DefaultTableModel model=new DefaultTableModel(values,columns);
                        JTable t=new JTable(model);
                        t.setEnabled(false);
                        JDialog dialog=new JDialog();
                        dialog.setBounds(0,0,400,400);
                        dialog.setLocationRelativeTo(null);
                        dialog.setTitle("Books");
                        t.setBackground(new Color(170,200,150));
                        JScrollPane scrollPane3 = new JScrollPane(t);
                        scrollPane3.setBounds(10, 50, 950, 120);
                        scrollPane3.setEnabled(false);
                        dialog.add(scrollPane3);
                        dialog.pack();
                        dialog.setVisible(true);

                    }


        }
    }

    class SearchByGenreListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {

                String s = JOptionPane.showInputDialog(null, "Book genre : ");
                if(s!=null)
                    if(s.equals(""))
                        JOptionPane.showMessageDialog(null, "Empty fields!",null,JOptionPane.ERROR_MESSAGE);
                    else
                    {
                        Employee em=new Employee();
                        ArrayList<Book> array=em.getBooksByGenre(s);
                        String[] columns=Book.getFields();
                        String[][] values=Book.getFieldValues(array);

                        DefaultTableModel model=new DefaultTableModel(values,columns);
                        JTable t=new JTable(model);
                        t.setEnabled(false);
                        JDialog dialog=new JDialog();
                        dialog.setBounds(0,0,400,400);
                        dialog.setLocationRelativeTo(null);
                        dialog.setTitle("Books");
                        t.setBackground(new Color(170,200,150));
                        JScrollPane scrollPane3 = new JScrollPane(t);
                        scrollPane3.setBounds(10, 50, 950, 120);
                        scrollPane3.setEnabled(false);
                        dialog.add(scrollPane3);
                        dialog.pack();
                        dialog.setVisible(true);

                    }


        }
    }

    class SellBookListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            JTextField titleText = new JTextField();
            JTextField quantityText = new JTextField();

            Object[] msg = {"Title : ",titleText,"Quantity : ",quantityText};
            JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
            JDialog dialog = op.createDialog("");
            dialog.setVisible(true);
            int result = JOptionPane.OK_OPTION;
            try
            {
                result = ((Integer)op.getValue()).intValue();
            }
            catch(Exception ex)
            {}
            if (result == JOptionPane.OK_OPTION)
            {
                String title = titleText.getText();
                String quant = quantityText.getText();

                if (title.equals("")|| quant.equals(""))
                    JOptionPane.showMessageDialog(null, "Empty fields!", null, JOptionPane.ERROR_MESSAGE);
                else {
                    try {
                        int quantity = Integer.parseInt(quant);
                        if (quantity <= 0)
                            throw new NumberFormatException();
                        else {
                            Employee em = new Employee();
                            boolean ok = em.sellBook(title, quantity);
                            if (!ok)
                                JOptionPane.showMessageDialog(null, "Out of stock!", null, JOptionPane.ERROR_MESSAGE);
                            else
                                JOptionPane.showMessageDialog(null, "Successful operation!", null, JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                    catch (NumberFormatException nx)
                    {
                        JOptionPane.showMessageDialog(null, "The quantity has to be an integer grater than zero!", null, JOptionPane.ERROR_MESSAGE);
                    }
                }
            }

        }
    }

    class AddBookListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            JTextField titleText = new JTextField();
            JTextField authorText = new JTextField();
            JTextField genreText = new JTextField();
            JTextField quantityText = new JTextField();
            JTextField priceText = new JTextField();

            Object[] msg = {"Title : ",titleText,"Author : ",authorText,"Genre : ",genreText, "Quantity : ",quantityText, "Price : ",priceText};
            JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
            JDialog dialog = op.createDialog("");
            dialog.setVisible(true);
            int result = JOptionPane.OK_OPTION;
            try
            {
                result = ((Integer)op.getValue()).intValue();
            }
            catch(Exception ex)
            {}
            if (result == JOptionPane.OK_OPTION)
            {
                String title = titleText.getText();
                String author = authorText.getText();
                String genre = genreText.getText();
                String quant = quantityText.getText();
                String pr = priceText.getText();

                if (title.equals("") || author.equals("") || genre.equals("") || quant.equals("") || pr.equals(""))
                    JOptionPane.showMessageDialog(null, "Empty fields!", null, JOptionPane.ERROR_MESSAGE);
                else {
                    try {
                        int quantity = Integer.parseInt(quant);
                        float price = Float.parseFloat(pr);
                        if (quantity < 0 || price<0)
                            throw new NumberFormatException();
                        else {
                            Admin a = new Admin();
                            boolean ok = a.addBook(new Book(title, author, genre, quantity, price));
                            if (!ok)
                                JOptionPane.showMessageDialog(null, "The book already exists!", null, JOptionPane.ERROR_MESSAGE);
                            else
                                JOptionPane.showMessageDialog(null, "Successful operation!", null, JOptionPane.INFORMATION_MESSAGE);
                        }
                    }catch (NumberFormatException ex)
                    {
                        JOptionPane.showMessageDialog(null, "The quantity has to be an integer and the price has to be a real greater than zero!", null, JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }

    class DeleteBookListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {

                String s = JOptionPane.showInputDialog(null, "Book title : ");
                if(s!=null)
                    if(s.equals(""))
                        JOptionPane.showMessageDialog(null, "Empty fields!",null,JOptionPane.ERROR_MESSAGE);
                    else
                    {
                        Admin a=new Admin();
                        boolean ok=a.deleteBook(s);
                        if(!ok)
                            JOptionPane.showMessageDialog(null, "The book does not exist!",null,JOptionPane.ERROR_MESSAGE);
                        else JOptionPane.showMessageDialog(null, "Successful operation!", null, JOptionPane.INFORMATION_MESSAGE);

                    }

        }
    }

    class AddBookQuantityListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            JTextField titleText = new JTextField();
            JTextField quantityText = new JTextField();

            Object[] msg = {"Title : ",titleText,"Quantity : ",quantityText};
            JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
            JDialog dialog = op.createDialog("");
            dialog.setVisible(true);
            int result = JOptionPane.OK_OPTION;
            try
            {
                result = ((Integer)op.getValue()).intValue();
            }
            catch(Exception ex)
            {}
            if (result == JOptionPane.OK_OPTION)
            {
                String title = titleText.getText();
                String quant = quantityText.getText();

                if (title.equals("")|| quant.equals(""))
                    JOptionPane.showMessageDialog(null, "Empty fields!", null, JOptionPane.ERROR_MESSAGE);
                else {
                    try {
                        int quantity = Integer.parseInt(quant);
                        if (quantity <= 0)
                            throw new NumberFormatException();
                        else
                        {
                            Admin a = new Admin();
                            boolean ok = a.addBookQuantity(title, quantity);
                            if (!ok)
                                JOptionPane.showMessageDialog(null, "The book does not exist!", null, JOptionPane.ERROR_MESSAGE);
                            else
                                JOptionPane.showMessageDialog(null, "Successful operation!", null, JOptionPane.INFORMATION_MESSAGE);
                        }
                    }catch (NumberFormatException ex)
                    {
                        JOptionPane.showMessageDialog(null, "The quantity has to be an integer greater than zero!", null, JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }

    class UpdateBookPriceListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            JTextField titleText = new JTextField();
            JTextField priceText = new JTextField();

            Object[] msg = {"Title : ",titleText,"Price : ",priceText};
            JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
            JDialog dialog = op.createDialog("");
            dialog.setVisible(true);
            int result = JOptionPane.OK_OPTION;
            try
            {
                result = ((Integer)op.getValue()).intValue();
            }
            catch(Exception ex)
            {}
            if (result == JOptionPane.OK_OPTION)
            {
                String title = titleText.getText();
                String pr = priceText.getText();

                if (title.equals("")|| pr.equals(""))
                    JOptionPane.showMessageDialog(null, "Empty fields!", null, JOptionPane.ERROR_MESSAGE);
                else {
                    try {
                        float price = Float.parseFloat(pr);
                        if (price < 0)
                            throw new NumberFormatException();
                        else
                        {
                            Admin a = new Admin();
                            boolean ok = a.updateBookPrice(title, price);
                            if (!ok)
                                JOptionPane.showMessageDialog(null, "The book does not exist!", null, JOptionPane.ERROR_MESSAGE);
                            else
                                JOptionPane.showMessageDialog(null, "Successful operation!", null, JOptionPane.INFORMATION_MESSAGE);
                        }
                    }catch (NumberFormatException ex)
                    {
                        JOptionPane.showMessageDialog(null, "The price has to be a real number greater than zero!", null, JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }


    class ViewBookListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            Admin a=new Admin();
            ArrayList<Book> array=a.viewAllBooks();
            String[] columns=Book.getFields();
            String[][] values=Book.getFieldValues(array);

            DefaultTableModel model=new DefaultTableModel(values,columns);
            JTable t=new JTable(model);
            t.setEnabled(false);
            JDialog dialog=new JDialog();
            dialog.setBounds(0,0,400,400);
            dialog.setLocationRelativeTo(null);
            dialog.setTitle("Books");
            t.setBackground(new Color(170,200,150));
            JScrollPane scrollPane3 = new JScrollPane(t);
            scrollPane3.setBounds(10, 50, 950, 120);
            scrollPane3.setEnabled(false);
            dialog.add(scrollPane3);
            dialog.pack();
            dialog.setVisible(true);

        }
    }

    class AddEmployeeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            JTextField nameText = new JTextField();
            JTextField usernameText = new JTextField();
            JTextField passwordText = new JTextField();


            Object[] msg = {"Name : ",nameText,"Username : ",usernameText,"Password : ",passwordText};
            JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
            JDialog dialog = op.createDialog("");
            dialog.setVisible(true);
            int result = JOptionPane.OK_OPTION;
            try
            {
                result = ((Integer)op.getValue()).intValue();
            }
            catch(Exception ex)
            {}
            if (result == JOptionPane.OK_OPTION)
            {
                String name = nameText.getText();
                String username = usernameText.getText();
                String password = passwordText.getText();

                if (name.equals("") || username.equals("") || password.equals("") )
                    JOptionPane.showMessageDialog(null, "Empty fields!", null, JOptionPane.ERROR_MESSAGE);
                else {

                    Admin a = new Admin();
                    boolean ok = a.addEmployee(new Employee(username,password,name));
                    if (!ok)
                        JOptionPane.showMessageDialog(null, "The username already exists!", null, JOptionPane.ERROR_MESSAGE);
                    else
                        JOptionPane.showMessageDialog(null, "Successful operation!", null, JOptionPane.INFORMATION_MESSAGE);

                }
            }
        }
    }

    class DeleteEmployeeListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {

                String s = JOptionPane.showInputDialog(null, "Employee name : ");
                if(s!=null)
                    if(s.equals(""))
                        JOptionPane.showMessageDialog(null, "Empty fields!",null,JOptionPane.ERROR_MESSAGE);
                    else
                    {
                        Admin a=new Admin();
                        boolean ok=a.deleteEmployee(s);
                        if(!ok)
                            JOptionPane.showMessageDialog(null, "The employee does not exist!",null,JOptionPane.ERROR_MESSAGE);
                        else JOptionPane.showMessageDialog(null, "Successful operation!", null, JOptionPane.INFORMATION_MESSAGE);

                    }


        }
    }

    class UpdateEmployeeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            JTextField nameText = new JTextField();
            JTextField passwordText = new JTextField();

            Object[] msg = {"Name : ",nameText,"New Password : ",passwordText};
            JOptionPane op = new JOptionPane(msg,JOptionPane.QUESTION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,null,null);
            JDialog dialog = op.createDialog("");
            dialog.setVisible(true);
            int result = JOptionPane.OK_OPTION;
            try
            {
                result = ((Integer)op.getValue()).intValue();
            }
            catch(Exception ex)
            {}
            if (result == JOptionPane.OK_OPTION)
            {
                String name = nameText.getText();
                String password = passwordText.getText();

                if (name.equals("")|| password.equals(""))
                    JOptionPane.showMessageDialog(null, "Empty fields!", null, JOptionPane.ERROR_MESSAGE);
                else {

                            Admin a = new Admin();
                            boolean ok = a.updateEmployeePassword(name,password);
                            if (!ok)
                                JOptionPane.showMessageDialog(null, "The employee does not exist!", null, JOptionPane.ERROR_MESSAGE);
                            else
                                JOptionPane.showMessageDialog(null, "Successful operation!", null, JOptionPane.INFORMATION_MESSAGE);

                }
            }
        }
    }

    class ViewEmployeeListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            Admin a=new Admin();
            ArrayList<Employee> array=a.viewAllEmployees();
            String[] columns=Employee.getFields();
            String[][] values=Employee.getFieldValues(array);

            DefaultTableModel model=new DefaultTableModel(values,columns);
            JTable t=new JTable(model);
            t.setEnabled(false);
            JDialog dialog=new JDialog();
            dialog.setBounds(0,0,400,400);
            dialog.setLocationRelativeTo(null);
            dialog.setTitle("Employees");
            t.setBackground(new Color(170,200,150));
            JScrollPane scrollPane3 = new JScrollPane(t);
            scrollPane3.setBounds(10, 50, 950, 120);
            scrollPane3.setEnabled(false);
            dialog.add(scrollPane3);
            dialog.pack();
            dialog.setVisible(true);

        }
    }

    class ReportListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String s=(String)view.comboFile.getSelectedItem();
            Admin a=new Admin();
            a.generateReportFile(s);
            JOptionPane.showMessageDialog(null, "Successful operation!", null, JOptionPane.INFORMATION_MESSAGE);
        }
    }



}
