package lld.library;

import lld.library.model.Book;
import lld.library.model.Member;
import lld.library.service.Library;
import lld.library.strategy.SearchByTitle;

import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class LibraryMain {
    public static void main(String[] args) {
        Library library= Library.getInstance();
        library.addBook(new Book(1, "java basics", "amrit"));
        library.addBook(new Book(2, "c basics", "aditya"));


        Member member= new Member(101, "user1");
        Member member1= new Member(102, "user2");
        library.addMembersInLibrary(member);
        library.addMembersInLibrary(member1);
        List<Book> result = library.searchBooks(new SearchByTitle(), "Java Basics");

        System.out.println("Search Result:");
        result.forEach(System.out::println);

        library.issueBook(1, 101 );
        library.issueBook(1, 102 );
        for (Map.Entry<Integer, Integer> entry : library.getBookToMemberId().entrySet()){
            Integer bookID= entry.getKey();
            Integer memberID= entry.getValue();
            System.out.println("Search Result of getBookToMemberId :"+ bookID + " to " + memberID );
        }
    }
}
