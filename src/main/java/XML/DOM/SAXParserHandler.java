package XML.DOM;

import com.sun.xml.internal.stream.events.EndElementEvent;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

/**
 * Created by by642 on 2017.05.21.
 */
public class SAXParserHandler extends DefaultHandler {
    String value = null;
    Book book = null;

    public ArrayList<Book> getBookArrayList() {
        return bookArrayList;
    }

    ArrayList<Book> bookArrayList = new ArrayList<Book>();
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if(qName.equals("book")){
            book = new Book();

//            String value = attributes.getValue("id");
//            System.out.println("book的属性值是： "+value);
            int num = attributes.getLength();
            for (int i = 0; i< num; i++)
            {
                System.out.println(attributes.getQName(i));
                System.out.println(attributes.getValue(i));
                if(attributes.getQName(i).equals("id")){
                    book.setId(attributes.getQName(i));
                }
            }
        }
        else if (!qName.equals("book") && !qName.equals("bookstore"))
        {
            System.out.println("节点名是： "+ qName);
        }
    }
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);

        if(qName.equals("book")){
            bookArrayList.add(book);
            book = null;
            System.out.println("=============结束==============");
        }
        else if (qName.equals("name"))
        {
            book.setName(value);
        }
        else if (qName.equals("author"))
        {
            book.setAuthor(value);
        }
        else if (qName.equals("year"))
        {
            book.setYear(value);
        }
        else if (qName.equals("price"))
        {
            book.setPrice(value);
        }
        else if (qName.equals("language"))
        {
            book.setLanguage(value);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("SAX解析开始");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("SAX解析结束");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        value = new String(ch,start,length);
        if (!value.trim().equals("")) {
            System.out.println(value);
        }
    }
}
