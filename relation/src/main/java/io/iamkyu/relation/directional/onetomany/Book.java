package io.iamkyu.relation.directional.onetomany;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Book {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Book(final String name) {
        this.name = name;
    }
}
