package com.github.rafaelsilvestri.graphql.author;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    final AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        this.repository = repository;
    }

    public Optional<Author> findAuthorById(Integer id) {
        return repository.findById(id);
    }

    public Optional<Author> findAuthorByEmail(String email) {
        return repository.findByEmail(email);
    }

    public Author create(Author author) {
        return null;
    }

    public Iterable<Author> findAll() {
        return repository.findAll();
    }
}
