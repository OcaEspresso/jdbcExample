package model;

import java.io.File;

/**
 * @description  图书模型
 * @author: RicksonYu
 * @create: 2025年-03月-04日--03:24
 */
public class Book {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getBookTypeId() {
        return bookTypeId;
    }

    public void setBookTypeId(int bookTypeId) {
        this.bookTypeId = bookTypeId;
    }

    private int id;
    private String bookName;

    public Book(int id, String bookName, float price, String author, int bookTypeId, File context) {
        this.id = id;
        this.bookName = bookName;
        this.price = price;
        this.author = author;
        this.bookTypeId = bookTypeId;
        this.context = context;
    }

    public Book(int id, String bookName, float price, String author, int bookTypeId) {
        this.id = id;
        this.bookName = bookName;
        this.price = price;
        this.author = author;
        this.bookTypeId = bookTypeId;
    }

    private float price;
    private String author;
    private int bookTypeId;
    private File context;
    private File pic;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", bookTypeId=" + bookTypeId +
                ", context=" + context +
                ", pic=" + pic +
                '}';
    }

    public File getPic() {
        return pic;
    }

    public void setPic(File pic) {
        this.pic = pic;
    }

    public Book(int id, String bookName, float price, String author, int bookTypeId, File context, File pic) {
        this.id = id;
        this.bookName = bookName;
        this.price = price;
        this.author = author;
        this.bookTypeId = bookTypeId;
        this.context = context;
        this.pic = pic;
    }

    public File getContext() {
        return context;
    }

    public void setContext(File context) {
        this.context = context;
    }


}

