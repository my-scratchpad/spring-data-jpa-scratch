package io.iamkyu.projection;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Blog {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @OneToMany(mappedBy = "blog")
    private List<Comment> comments;

    public Blog(String title) {
        this.title = title;
        comments = new ArrayList<>();
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setBlog(this);
    }
}
