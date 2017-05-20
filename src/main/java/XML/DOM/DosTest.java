package XML.DOM;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Created by by642 on 2017.05.20.
 */
public class DosTest {
    public static void main(String[] args) throws IOException, SAXException {
        //准备工作
        //创建DocumentBuilderFactory的对象
        DocumentBuilderFactory dbf =  DocumentBuilderFactory.newInstance();
        //DocumentBuilder
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            //通过DocumentBuilder对象的Parse方法加载books.xml
            Document doc = db.parse("books.xml");
            //获取book节点的集合
            NodeList booklist = doc.getElementsByTagName("book");
            //通过Nodelist的getlength方法获取长度
//            System.out.println(booklist.getLength());
//            for(int i =0;i<booklist.getLength();i++)
//            {
//                Node books = booklist.item(i) ;
//                //获取book节点的所有属性集合
//                NamedNodeMap namedNodeMap = books.getAttributes();
//                System.out.println(namedNodeMap);
//                //遍历
//                for(int j= 0; j<namedNodeMap.getLength();j++)
//                {
//                    //通过item（index）获取某个节点内的属性
//                    String attr = namedNodeMap.item(j).getNodeName();
//                    System.out.println(attr);
//                    String value = namedNodeMap.item(j).getNodeValue();
//                    System.out.println(value);
//                }
//            }
            int i = 0;
            Element book1= (Element)booklist.item(i);
            String attrvalue = book1.getAttribute("id");
            System.out.println("ID属性值为：" + attrvalue);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
    }

