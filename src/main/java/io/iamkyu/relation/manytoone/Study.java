package io.iamkyu.relation.manytoone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Study {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private Student student;

    public Study(final String name, final Student student) {
        this.name = name;
        this.student = student;
    }
}
