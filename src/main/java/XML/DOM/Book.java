package XML.DOM;

/**
 * Created by by642 on 2017.05.21.
 */
public class Book {
    private String id ;
    private String name;
    private String author;
    private String year;
    private String language;
    private String price;

    public String getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {

        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
