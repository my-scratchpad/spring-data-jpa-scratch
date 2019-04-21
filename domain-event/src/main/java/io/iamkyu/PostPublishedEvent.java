package io.iamkyu;

import org.springframework.context.ApplicationEvent;
import org.springframework.util.ClassUtils;

public class PostPublishedEvent extends ApplicationEvent {

    private final Post post;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public PostPublishedEvent(final Object source) {
        super(source);

        if (!ClassUtils.isAssignableValue(Post.class, source)) {
            throw new IllegalArgumentException();
        }

        this.post = (Post) source;
    }

    public Post getPost() {
        return post;
    }
}
