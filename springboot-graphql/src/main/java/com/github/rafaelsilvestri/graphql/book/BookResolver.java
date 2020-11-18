package com.github.rafaelsilvestri.graphql.book;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final BookService bookService;

    public BookResolver(BookService bookService) {
        this.bookService = bookService;
    }

    public Optional<Book> findBookById(Integer id) {
        return bookService.findBookById(id);
    }

    public List<Book> findBookByAuthor(Integer id) {
        return bookService.findBookByAuthor(id);
    }

    public Book createBook(Book book, String email) {
        return bookService.create(book, email);
    }

}
