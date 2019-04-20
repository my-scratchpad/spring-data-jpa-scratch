package io.iamkyu.relation.onetomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Book(final String name) {
        this.name = name;
    }
}
