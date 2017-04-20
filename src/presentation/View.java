package presentation;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Cristina on 4/15/2017.
 */
public class View extends JFrame {

    public JLabel lLogIn;
    public JComboBox comboLogIn;
    public JLabel lUsername;
    public JLabel lPassword;
    public JTextField tUsername;
    public JButton bLogIn;
    public JPasswordField tPassword;

    public JButton bSearchAuthor;
    public JButton bSearchGenre;
    public JButton bSearchTitle;
    public JLabel lEmployee;
    public JButton bLogOut1;
    public JButton bSell;

    public JButton bDeleteBook;
    public JButton bUpdateBookQ;
    public JButton bAddBook;
    public JLabel lAdmin;
    public JButton bUpdateBookP;
    public JButton bViewBook;
    public JLabel lBook;
    public JLabel lEmployees;
    public JButton bAddEmployee;
    public JButton bDeleteEmployee;
    public JButton bUpdateEmployee;
    public JButton bViewEmployee;
    public JLabel lReport;
    public JLabel lType;
    public JComboBox comboFile;
    public JButton bReport;
    public JButton bLogOut2;


    public JPanel panel1;
    public JPanel panel2;
    public JPanel panel3;

    public View()
    {
        Color c1=new Color(255,250,170);
        Color c2=new Color(50,75,50);
        Color c3=new Color(170,200,150);
        Font f=new Font("Century Gothic",Font.PLAIN,15);
        Font f1=new Font("Century Gothic",Font.PLAIN,13);
        setPreferredSize (new Dimension (667, 400));
        panel1=new JPanel();
        panel2=new JPanel();
        panel3=new JPanel();
        JPanel panel=new JPanel();

        panel.setBackground(c1);
        panel1.setBackground(c1);
        panel2.setBackground(c1);
        panel3.setBackground(c1);

        //construct preComponents
        String[] comboLogInItems = {"Admin", "Employee"};
        String[] comboFileItems = {"CSV", "PDF"};
        //construct components
        lLogIn = new JLabel ("Log In as : ");
        comboLogIn = new JComboBox (comboLogInItems);
        lUsername = new JLabel ("Username :");
        lPassword = new JLabel ("Password :");
        tUsername = new JTextField (15);
        bLogIn = new JButton ("Log In");
        tPassword = new JPasswordField (15);

        bSearchAuthor = new JButton ("Search books by author");
        bSearchGenre = new JButton ("Search books by genre");
        bSearchTitle = new JButton ("Search books by title");
        lEmployee = new JLabel ("EMPLOYEE");
        bLogOut1 = new JButton ("Log Out");
        bSell = new JButton ("Sell books");

        bDeleteBook = new JButton ("Delete");
        bUpdateBookQ = new JButton ("Add Quantity");
        bAddBook = new JButton ("Add");
        lAdmin = new JLabel ("ADMINISTRATOR");
        bUpdateBookP = new JButton ("Update Price");
        bViewBook = new JButton ("View All");
        lBook = new JLabel ("Books :");
        lEmployees = new JLabel ("Employees :");
        bAddEmployee = new JButton ("Add");
        bDeleteEmployee = new JButton ("Delete");
        bUpdateEmployee = new JButton ("Update Password");
        bViewEmployee = new JButton ("View All");
        lReport = new JLabel ("Reports :");
        lType = new JLabel ("File Type:");
        comboFile = new JComboBox (comboFileItems);
        bReport = new JButton ("Generate Report");
        bLogOut2 = new JButton ("Log Out");


        lAdmin.setForeground(c2);
        lBook.setForeground(c2);
        lEmployees.setForeground(c2);
        lEmployee.setForeground(c2);
        lLogIn.setForeground(c2);
        lPassword.setForeground(c2);
        lReport.setForeground(c2);
        lType.setForeground(c2);
        lUsername.setForeground(c2);

        lLogIn.setFont(f);
        lUsername.setFont(f);
        lPassword.setFont(f);
        lType.setFont(f);
        lReport.setFont(f);
        lAdmin.setFont(f);
        lBook.setFont(f);
        lEmployee.setFont(f);
        lEmployees.setFont(f);

        comboLogIn.setFont(f1);
        comboFile.setFont(f1);

        bLogIn.setFont(f1);
        bSearchAuthor.setFont(f1);
        bLogOut2.setFont(f1);
        bLogOut1.setFont(f1);
        bSearchGenre.setFont(f1);
        bSearchTitle.setFont(f1);
        bSell.setFont(f1);
        bAddBook.setFont(f1);
        bAddEmployee.setFont(f1);
        bDeleteEmployee.setFont(f1);
        bDeleteBook.setFont(f1);
        bUpdateEmployee.setFont(f1);
        bUpdateBookQ.setFont(f1);
        bUpdateBookP.setFont(f1);
        bViewEmployee.setFont(f1);
        bViewBook.setFont(f1);
        bReport.setFont(f1);

        bReport.setBackground(c3);
        bViewEmployee.setBackground(c3);
        bDeleteEmployee.setBackground(c3);
        bViewBook.setBackground(c3);
        bAddBook.setBackground(c3);
        bAddEmployee.setBackground(c3);
        bDeleteBook.setBackground(c3);
        bLogIn.setBackground(c3);
        bLogOut1.setBackground(c3);
        bLogOut2.setBackground(c3);
        bSearchAuthor.setBackground(c3);
        bSearchGenre.setBackground(c3);
        bSearchTitle.setBackground(c3);
        bSell.setBackground(c3);
        bUpdateBookP.setBackground(c3);
        bUpdateBookQ.setBackground(c3);
        bUpdateEmployee.setBackground(c3);

        comboFile.setBackground(c3);
        comboLogIn.setBackground(c3);

        //adjust size and set layout
        panel1.setPreferredSize (new Dimension (667, 400));
        panel1.setLayout (null);
        panel2.setPreferredSize (new Dimension (667, 400));
        panel2.setLayout (null);
        panel3.setPreferredSize (new Dimension (667, 400));
        panel3.setLayout (null);

        //add components
        panel1.add (lLogIn);
        panel1.add (comboLogIn);
        panel1.add (lUsername);
        panel1.add (lPassword);
        panel1.add (tUsername);
        panel1.add (bLogIn);
        panel1.add (tPassword);

        panel2.add (bSearchAuthor);
        panel2.add (bSearchGenre);
        panel2.add (bSearchTitle);
        panel2.add (lEmployee);
        panel2.add (bLogOut1);
        panel2.add (bSell);

        panel3.add (bDeleteBook);
        panel3.add (bUpdateBookQ);
        panel3.add (bAddBook);
        panel3.add (lAdmin);
        panel3.add (bUpdateBookP);
        panel3.add (bViewBook);
        panel3.add (lBook);
        panel3.add (lEmployees);
        panel3.add (bAddEmployee);
        panel3.add (bDeleteEmployee);
        panel3.add (bUpdateEmployee);
        panel3.add (bViewEmployee);
        panel3.add (lReport);
        panel3.add (lType);
        panel3.add (comboFile);
        panel3.add (bReport);
        panel3.add (bLogOut2);


        lLogIn.setBounds (290, 65, 100,40);
        comboLogIn.setBounds (285, 105, 100, 25);
        lUsername.setBounds (190, 170, 100, 25);
        lPassword.setBounds (190, 205, 100, 25);
        tUsername.setBounds (285, 170, 100, 25);
        bLogIn.setBounds (285, 260, 100, 25);
        tPassword.setBounds (285, 205, 100, 25);

        bSearchAuthor.setBounds (210, 120, 220, 25);
        bSearchGenre.setBounds (210, 160, 220, 25);
        bSearchTitle.setBounds (210, 80, 220, 25);
        lEmployee.setBounds (280, 25, 100, 25);
        bLogOut1.setBounds (270, 260, 100, 25);
        bSell.setBounds (210, 200, 220, 25);

        bDeleteBook.setBounds (40, 120, 150, 20);
        bUpdateBookQ.setBounds (40, 150, 150, 20);
        bAddBook.setBounds (40, 90, 150, 20);
        lAdmin.setBounds (265, 10, 130, 25);
        bUpdateBookP.setBounds (40, 180, 150, 20);
        bViewBook.setBounds (40, 210, 150, 20);
        lBook.setBounds (80, 60, 100, 25);
        lEmployees.setBounds (280, 60, 100, 25);
        bAddEmployee.setBounds (255, 90, 150, 20);
        bDeleteEmployee.setBounds (255, 120, 150, 20);
        bUpdateEmployee.setBounds (255, 150, 150, 20);
        bViewEmployee.setBounds (255, 180, 150, 20);
        lReport.setBounds (490, 60, 100, 25);
        lType.setBounds (435, 100, 100, 25);
        comboFile.setBounds (520, 100, 100, 25);
        bReport.setBounds (455, 150, 150, 20);
        bLogOut2.setBounds (280, 280, 100, 25);

        panel.add(panel1);
        panel.add(panel2);
        panel.add(panel3);

        panel3.setVisible(false);
        panel2.setVisible(false);


        this.setContentPane(panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}


