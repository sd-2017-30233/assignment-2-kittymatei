package service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import data.*;
import org.w3c.dom.Document;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
/**
 * Created by Cristina on 4/12/2017.
 */
public class EmployeeService {


    public boolean verify(String username,String password)
    {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document=null;
        try {
            document = builder.parse(new FileInputStream("employees.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        XPath xPath =  XPathFactory.newInstance().newXPath();
        String expression = "/Employees/Employee[username='"+username+"' and password='"+password+"']";
        Node node=null;
        try {
            node = (Node)xPath.compile(expression).evaluate(document, XPathConstants.NODE);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        if(node==null)
            return false;
        return true;
    }

    public ArrayList<Employee> viewAll()
    {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document=null;
        try {
            document = builder.parse(new FileInputStream("employees.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        XPath xPath =  XPathFactory.newInstance().newXPath();
        String expression="Employees/Employee";
        NodeList nodeList=null;
        try {
            nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }

        ArrayList<Employee> array=new ArrayList<Employee>();
        if(null != nodeList) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                String[] str=new String[3];
                int x=0;
                NodeList nodeList1 = nodeList.item(i).getChildNodes();
                for (int j = 0;null!=nodeList1 && j < nodeList1.getLength(); j++) {
                    Node nod = nodeList1.item(j);
                    if(nod.getNodeType() == Node.ELEMENT_NODE)
                    {
                        str[x]=String.valueOf(nod.getFirstChild().getNodeValue());
                        x++;
                    }
                }
                if(x==3)
                {
                    Employee e=new Employee(str[1],str[2],str[0]);
                    array.add(e);
                }
            }
        }
        return array;
    }

    public boolean updatePassword(String name, String newPassword)
    {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document=null;
        try {
            document = builder.parse(new FileInputStream("employees.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        XPath xPath =  XPathFactory.newInstance().newXPath();
        String expression = "/Employees/Employee[name='"+name+"']/password";
        try {
            Node node = (Node)xPath.compile(expression).evaluate(document, XPathConstants.NODE);
            if(node!=null)
            {
                System.out.println(node.getFirstChild().getNodeValue());
                node.setTextContent(newPassword);
                Transformer xformer = TransformerFactory.newInstance().newTransformer();
                xformer.transform(new DOMSource(document), new StreamResult(new File("employees.xml")));
                return true;
            }
            else
                return false;
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return false;
    }


    public boolean deleteEmployee(String name)
    {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document=null;
        try {
            document = builder.parse(new FileInputStream("employees.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        XPath xPath =  XPathFactory.newInstance().newXPath();
        String expression = "/Employees/Employee[name='"+name+"']";
        try {
            Node node = (Node)xPath.compile(expression).evaluate(document, XPathConstants.NODE);
            if(node!=null) {
                node.getParentNode().removeChild(node);
                Transformer xformer = TransformerFactory.newInstance().newTransformer();
                xformer.transform(new DOMSource(document), new StreamResult(new File("employees.xml")));
                return true;
            }else
                return false;
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addEmployee(String name, String username, String password)
    {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document=null;
        try {
            document = builder.parse(new FileInputStream("employees.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        XPath xPath =  XPathFactory.newInstance().newXPath();
        String expression = "/Employees/Employee[username ='"+username+"']";

        NodeList nodeList = null;
        try {
            nodeList = (NodeList)xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        if(nodeList.getLength()==0)
        {
            Element newBook = document.createElement("Employee");
            Element newName = document.createElement("name");
            newName.setTextContent(name);
            Element newUsername = document.createElement("username");
            newUsername.setTextContent(username);
            Element newPassword = document.createElement("password");
            newPassword.setTextContent(password);
            newBook.appendChild(newName);
            newBook.appendChild(newUsername);
            newBook.appendChild(newPassword);
            document.getDocumentElement().appendChild(newBook);
            try {
                Transformer xformer = TransformerFactory.newInstance().newTransformer();
                xformer.transform(new DOMSource(document), new StreamResult(new File("employees.xml")));
            } catch (TransformerConfigurationException e) {
                e.printStackTrace();
            } catch (TransformerException e) {
                e.printStackTrace();
            }
            return true;
        }
        else return false;
    }


}
