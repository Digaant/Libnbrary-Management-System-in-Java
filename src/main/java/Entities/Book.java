package Entities;

public class Book {
    private Long BID;
    private String bookName;
    private int price;
    private String genre;

    public Book(Long BID, String bookName, int price, String genre) {
        this.BID = BID;
        this.bookName = bookName;
        this.price = price;
        this.genre = genre;
    }

    public Long getBID() {
        return BID;
    }

    public void setBID(Long BID) {
        this.BID = BID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "BID=" + BID +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", genre='" + genre + '\'' +
                '}';
    }
}
