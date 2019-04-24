package io.iamkyu.lifecycle;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    public Post(final String title) {
        this.title = title;
    }

    // for test
    public void setId(final Long id) {
        this.id = id;
    }
}
