package io.iamkyu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DomainEventTest {
    @Autowired
    private ApplicationContext context;

    @Test
    public void testEventPublishing1() {
        //given
        Post post = new Post("My First Code", "Hello World");
        PostPublishedEvent postPublishedEvent = new PostPublishedEvent(post);

        //when
        context.publishEvent(postPublishedEvent);

        //then
    }

    @Test
    public void testEventPublishing2() {
        //given
        Post post = new Post("My First Code", "Hello World");

        //when
        post.publish();

        //then
    }
}
