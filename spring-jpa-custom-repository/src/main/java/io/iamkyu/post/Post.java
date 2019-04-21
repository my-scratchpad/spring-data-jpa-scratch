package io.iamkyu.post;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Getter
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Lob
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public Post(final String title, final String content) {
        this(title, content, new Date());
    }

    public Post(final String title, final String content, final Date createdDate) {
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
    }
}
