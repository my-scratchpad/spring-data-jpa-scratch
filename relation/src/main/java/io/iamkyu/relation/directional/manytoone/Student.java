package io.iamkyu.relation.directional.manytoone;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Getter
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public Student(final String name) {
        this.name = name;
    }
}
