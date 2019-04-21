package io.iamkyu;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PostEventListener {

    @EventListener
    public void onPostPublished(final PostPublishedEvent event) {
        System.out.println(event);
    }
}
