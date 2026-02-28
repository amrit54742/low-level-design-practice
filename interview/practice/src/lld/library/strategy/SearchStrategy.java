package lld.library.strategy;

import lld.library.model.Book;

import java.util.List;

public interface SearchStrategy {
    List<Book> booksSearched (List<Book> books, String titleOrAuthor);
}
