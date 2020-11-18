package com.github.rafaelsilvestri.graphql.author;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuthorResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    private final AuthorService authorService;

    public AuthorResolver(AuthorService authorService) {
        this.authorService = authorService;
    }

    public Iterable<Author> findAuthors() {
        return authorService.findAll();
    }

    public Optional<Author> findAuthorByEmail(String email) {
        return authorService.findAuthorByEmail(email);
    }

    public Optional<Author> findAuthorById(Integer id) {
        return authorService.findAuthorById(id);
    }

    public Author createAuthor(Author author) {
        return authorService.create(author);
    }
}
