package com.github.rafaelsilvestri.graphql.author;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("author")
public class Author {
    @Id
    @Column("id")
    private Integer id;
    @Column("full_name")
    private String fullName;
    @Column("email")
    private String email;

    //private List<Book> books;

    public Author() {
        //this.books = new ArrayList<>();
    }
}
