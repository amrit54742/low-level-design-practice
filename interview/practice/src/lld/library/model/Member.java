package lld.library.model;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private int id;
    private String name;
    private List<Book> borrowedBooks= new ArrayList<>();

    public int getId() {
        return id;
    }

    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }
}
