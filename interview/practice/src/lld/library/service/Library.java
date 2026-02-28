package lld.library.service;

import lld.library.model.Book;
import lld.library.model.Member;
import lld.library.strategy.SearchStrategy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private List<Book> booksInLibrary= new ArrayList<>();
    private static Library instance;
    private Map<Integer, Integer> bookToMemberId = new HashMap<>();
    private Map<Integer, Member> membersOfLibrary = new HashMap<>();

    public Map<Integer, Integer> getBookToMemberId() {
        return bookToMemberId;
    }

    public void setBookToMemberId(Map<Integer, Integer> bookToMemberId) {
        this.bookToMemberId = bookToMemberId;
    }

    public Map<Integer, Member> getMembersOfLibrary() {
        return membersOfLibrary;
    }

    public void setMembersOfLibrary(Map<Integer, Member> membersOfLibrary) {
        this.membersOfLibrary = membersOfLibrary;
    }

    public void addMembersInLibrary(Member member){
        this.membersOfLibrary.put(member.getId(), member);
    }


    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public List<Book> getBooksInLibrary() {
        return booksInLibrary;
    }

    public void setBooksInLibrary(List<Book> booksInLibrary) {
        this.booksInLibrary = booksInLibrary;
    }
    public void addBook(Book book){
        this.booksInLibrary.add(book);
    }

    public void issueBook( int bookId, int memberId){
        List<Book> booksFound= new ArrayList<>();
        System.out.println("(inside issueBook)");
        Book book = findBookById(bookId);
        Member member = membersOfLibrary.get(memberId);
        if (book == null || member == null) {
            System.out.println("Invalid book or member.");
            return;
        }

        if (!book.isAvailable()) {
            System.out.println("Book not available.");
            return;
        }
        System.out.println("(inside returnBook) adding  the book" + bookId + "to memberID" + memberId + " to the list");
        this.bookToMemberId.put(bookId, memberId);
        book.setAvailable(false);
        member.getBorrowedBooks().add(book);
        System.out.println("(inside returnBook) added book to borrowed list");
//        for (int i=0;i< library.getBooksInLibrary().size(); i++){
//            if (library.getBooksInLibrary().get(i).getAuthor().equalsIgnoreCase(titleOrAuthor) ||
//                    library.getBooksInLibrary().get(i).getTitle().equalsIgnoreCase(titleOrAuthor)){
//                System.out.println("(inside issueBook) setting book " + bookId +" to member " + memberId);
//                this.bookToMemberId.put(memberId, memberId);
//                member.getBorrowedBooks().add(book);
//                book.setAvailable(false);
//            }
//        }

    }
    public List<Book> searchBooks(SearchStrategy strategy, String keyword) {
        return strategy.booksSearched(booksInLibrary, keyword);

    }

    public void returnBook( int bookId, int memberId){
        System.out.println("(inside returnBook)");
        List<Book> booksFound= new ArrayList<>();
        System.out.println("(inside returnBook)");
        Book book = findBookById(bookId);
        Member member = membersOfLibrary.get(memberId);
        if (book == null || member == null) {
            System.out.println("Invalid book or member.");
            return;
        }
        System.out.println("(inside returnBook) removing the book" + bookId + "to memberID" + memberId + " from the list");
        this.bookToMemberId.remove(bookId, memberId);
        book.setAvailable(true);
        member.getBorrowedBooks().remove(book);
        System.out.println("(inside returnBook) removed book from the borrowed list");

//        for (int i=0;i< library.getBooksInLibrary().size(); i++){
//            if (library.getBooksInLibrary().get(i).getAuthor().equalsIgnoreCase(titleOrAuthor) ||
//                    library.getBooksInLibrary().get(i).getTitle().equalsIgnoreCase(titleOrAuthor)){
//                System.out.println("(inside returnBook) removing book " + book.getId() +" from  member " + member.getId());
//                this.bookToMemberId.remove(book.getId(), member.getId());
//                member.getBorrowedBooks().remove(book);
//                book.setAvailable(true);
//            }
//        }
    }

    private Book findBookById(int id) {
        for (Book book : booksInLibrary) {
            if (book.getId()==id) {
                return book;
            }
        }
        return null;
    }


}
