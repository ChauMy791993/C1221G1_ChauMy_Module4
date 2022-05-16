package com.codegym.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameBook;
    private String author;
    private Integer quantity;
    @OneToMany(mappedBy = "book")
    private List<BorrowBookCode> borrowBookCodeList;

    public Book() {
    }

    public Book(String nameBook, String author, Integer quantity, List<BorrowBookCode> borrowBookCodeList) {
        this.nameBook = nameBook;
        this.author = author;
        this.quantity = quantity;
        this.borrowBookCodeList = borrowBookCodeList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<BorrowBookCode> getBorrowBookCodeList() {
        return borrowBookCodeList;
    }

    public void setBorrowBookCodeList(List<BorrowBookCode> borrowBookCodeList) {
        this.borrowBookCodeList = borrowBookCodeList;
    }
}
