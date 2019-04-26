package io.iamkyu.projection;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
@Getter
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private String contents;

    private int up;

    private int down;

    private boolean isBest;

    @ManyToOne
    private Blog blog;

    public Comment(String contents) {
        this.contents = contents;
        this.up = 0;
        this.down = 0;
        this.isBest = false;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
