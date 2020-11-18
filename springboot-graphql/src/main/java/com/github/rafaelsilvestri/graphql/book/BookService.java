package com.github.rafaelsilvestri.graphql.book;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Optional<Book> findBookById(Integer id) {
        return repository.findById(id);
    }

    public List<Book> findBookByAuthor(Integer id) {
        return repository.findByAuthorId(id);
    }

    public Book create(Book book, String email) {
        throw new RuntimeException("Not implemented yet!");
    }
}
