package com.github.rafaelsilvestri.graphql.book;

import com.github.rafaelsilvestri.graphql.author.Author;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("book")
public class Book {

    @Id
    @Column("id")
    private Integer id;
    @Column("isbn")
    private String isbn;
    @Column("title")
    private String title;
    @Column("author_id")
    private Integer authorId;
    @Transient
    private Author author;

    public Book() {
    }
}
