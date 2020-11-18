package com.github.rafaelsilvestri.graphql.book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Book Repository.
 *
 * @author Rafael Silvestri
 */
@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findByAuthorId(Integer id);

}
