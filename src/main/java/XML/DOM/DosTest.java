package XML.DOM;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

import static javax.xml.transform.OutputKeys.*;

/**
 * Created by by642 on 2017.05.20.
 */
public class DosTest {
    public DocumentBuilder getDocumentBuilder(){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        //DocumentBuilder
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return db;
    }
    public void xmlParser() throws ParserConfigurationException {
        try {
            //通过DocumentBuilder对象的Parse方法加载books.xml
            Document doc = getDocumentBuilder().parse("books.xml");
            //获取book节点的集合
            NodeList booklist = doc.getElementsByTagName("book");
//
//            //通过Nodelist的getlength方法获取长度
////            System.out.println(booklist.getLength());
//            for (int i = 0; i < booklist.getLength(); i++) {
//                Node books = booklist.item(i);
//                //获取book节点的所有属性集合
//                NamedNodeMap namedNodeMap = books.getAttributes();
////                System.out.println(namedNodeMap);
//                //遍历
////                for(int j= 0; j<namedNodeMap.getLength();j++)
////                {
////                    //通过item（index）获取某个节点内的属性
////                    String attr = namedNodeMap.item(j).getNodeName();
////                    System.out.println(attr);
////                    String value = namedNodeMap.item(j).getNodeValue();
////                    System.out.println(value);
////                }
////                int i = 0;
////                Element book1= (Element)booklist.item(i);
////                String attrvalue = book1.getAttribute("id");
////                System.out.println("ID属性值为：" + attrvalue);
//                NodeList childNodes = books.getChildNodes();
//                //遍历ChildNodes获取每个节点的节点名和节点值
//                System.out.println("第" + (i + 1) + "本书共有" + childNodes.getLength() + "个子节点");
//                for (int k = 0; k < childNodes.getLength(); k++) {
//                    //区分text的node以及element类型的node
//                    if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
//                        //获取element类型姐弟那的节点名
//                        System.out.print(childNodes.item(k).getNodeName()+ ":");
////                        System.out.println(childNodes.item(k).getFirstChild().getNodeValue());
//                        System.out.println(childNodes.item(k).getTextContent());
//                    }
//
//                }
//                System.out.println("=================");
//            }
            System.out.println(booklist);

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    生成xml的方法
     */
    public void createXml(){
        DocumentBuilder db = getDocumentBuilder();
        Document document = db.newDocument();
        document.setXmlStandalone(true);
        Element bookstore = document.createElement("bookstore");
        Element book = document.createElement("book");
        Element name = document.createElement("name");
        Element year = document.createElement("year");
        Element price = document.createElement("price");
        Element language = document.createElement("language");
        book.appendChild(name);
        book.appendChild(year);
        book.appendChild(price);
        book.appendChild(language);
        name.setTextContent("小王子");
        year.setTextContent("1997");
        price.setTextContent("24");
        language.setTextContent("French");
        book.setAttribute("id","1");
        bookstore.appendChild(book);
        document.appendChild(bookstore);
        TransformerFactory tff = TransformerFactory.newInstance();
        try {
            Transformer tf = tff.newTransformer();

            tf.transform(new DOMSource(document), new StreamResult(new File("book1.xml")));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException, SAXException {
        //准备工作
        //创建DocumentBuilderFactory的对象
        DosTest test = new DosTest();
        test.createXml();
    }
}

