package lld.library.strategy;

import lld.library.model.Book;

import java.util.ArrayList;
import java.util.List;

public class SearchByAuthor implements SearchStrategy{
    @Override
    public List<Book> booksSearched(List<Book> books, String titleOrAuthor) {
        List<Book> foundBooks= new ArrayList<>();
        Book book= new Book();
        for (int i=0; i<books.size(); i++){
            if (books.get(i).getAuthor().equalsIgnoreCase(titleOrAuthor)){
                book= books.get(i);
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }
}
