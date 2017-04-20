package service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import data.Book;
import org.w3c.dom.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.xml.sax.SAXException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * Created by Cristina on 4/12/2017.
 */
public class BookService {

    public ArrayList<Book> searchByTitle(String title)
    {
        String expression = "/Books/Book[title='"+title+"']";
        return search(expression);
    }

    public ArrayList<Book> searchByAuthor(String author)
    {
        String expression = "/Books/Book[author='"+author+"']";
        return search(expression);
    }

    public ArrayList<Book> searchByGenre(String genre)
    {
        String expression = "/Books/Book[genre='"+genre+"']";
        return search(expression);
    }

    public ArrayList<Book> viewAll()
    {
        String expression="/Books/Book";
        return search(expression);
    }

    public ArrayList<Book> getOutOfStock()
    {
        String expression="/Books/Book[quantity='0']";
        return search(expression);
    }

    public ArrayList<Book> search(String expression)
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
            document = builder.parse(new FileInputStream("books.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        XPath xPath =  XPathFactory.newInstance().newXPath();
       NodeList nodeList=null;
        try {
            nodeList = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        ArrayList<Book> array=new ArrayList<Book>();

        if(null != nodeList) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                String[] str=new String[5];
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
                if (x == 5) {
                    Book b=new Book(str[0],str[1],str[2],Integer.parseInt(str[3]),Float.parseFloat(str[4]));
                    array.add(b);
                }
            }
        }
        return array;
    }

    public int getQuantity(String title)
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
            document = builder.parse(new FileInputStream("books.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        XPath xPath =  XPathFactory.newInstance().newXPath();
        String expression = "/Books/Book[title='"+title+"']/quantity";
        String priceStr=null;
        try {
            priceStr = xPath.compile(expression).evaluate(document);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        if(priceStr!="")
        {
            return Integer.parseInt(priceStr);
        }
        return -1;
    }

    public boolean updateQuantity(String title, int q)
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
            document = builder.parse(new FileInputStream("books.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        XPath xPath =  XPathFactory.newInstance().newXPath();
        String expression = "/Books/Book[title='"+title+"']/quantity";
        try {
            Node node = (Node)xPath.compile(expression).evaluate(document, XPathConstants.NODE);
            if(node!=null) {
                node.setTextContent(String.valueOf(q));
                Transformer xformer = TransformerFactory.newInstance().newTransformer();
                xformer.transform(new DOMSource(document), new StreamResult(new File("books.xml")));
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

    public boolean updatePrice(String title, float p)
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
            document = builder.parse(new FileInputStream("books.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        XPath xPath =  XPathFactory.newInstance().newXPath();
        String expression = "/Books/Book[title='"+title+"']/price";
        try {
            Node node = (Node)xPath.compile(expression).evaluate(document, XPathConstants.NODE);
            if(node!=null) {
                node.setTextContent(String.valueOf(p));
                Transformer xformer = TransformerFactory.newInstance().newTransformer();
                xformer.transform(new DOMSource(document), new StreamResult(new File("books.xml")));
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


    public boolean deleteBook(String title)
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
            document = builder.parse(new FileInputStream("books.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        XPath xPath =  XPathFactory.newInstance().newXPath();
        String expression = "/Books/Book[title='"+title+"']";
        try {
            Node node = (Node)xPath.compile(expression).evaluate(document, XPathConstants.NODE);
            if(node!=null) {
                node.getParentNode().removeChild(node);
                Transformer xformer = TransformerFactory.newInstance().newTransformer();
                xformer.transform(new DOMSource(document), new StreamResult(new File("books.xml")));
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

    public boolean addBook(String title, String author, String genre, int quantity, float price)
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
            document = builder.parse(new FileInputStream("books.xml"));
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        XPath xPath =  XPathFactory.newInstance().newXPath();
        String expression = "/Books/Book[title='"+title+"']";

        NodeList nodeList = null;
        try {
            nodeList = (NodeList)xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        if(nodeList.getLength()==0)
        {
            Element newBook = document.createElement("Book");
            Element newTitle = document.createElement("title");
            newTitle.setTextContent(title);
            Element newAuthor = document.createElement("author");
            newAuthor.setTextContent(author);
            Element newGenre = document.createElement("genre");
            newGenre.setTextContent(genre);
            Element newQuantity = document.createElement("quantity");
            newQuantity.setTextContent(String.valueOf(quantity));
            Element newPrice = document.createElement("price");
            newPrice.setTextContent(String.valueOf(price));
            newBook.appendChild(newTitle);
            newBook.appendChild(newAuthor);
            newBook.appendChild(newGenre);
            newBook.appendChild(newQuantity);
            newBook.appendChild(newPrice);
            document.getDocumentElement().appendChild(newBook);
            try {
                Transformer xformer = TransformerFactory.newInstance().newTransformer();
                xformer.transform(new DOMSource(document), new StreamResult(new File("books.xml")));
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
