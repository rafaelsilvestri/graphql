package com.github.rafaelsilvestri.graphql.author;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Author Repository.
 *
 * @author Rafael Silvestri
 */
@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {

    Optional<Author> findByEmail(String email);

}
