package io.iamkyu.relation.directional.onetomany;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class BookStore {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany
    private List<Book> books;

    public BookStore(final String name) {
        this.name = name;
        books = new ArrayList<>();
    }

    public BookStore(final String name, final List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public void addBook(final Book book) {
        books.add(book);
    }
}
