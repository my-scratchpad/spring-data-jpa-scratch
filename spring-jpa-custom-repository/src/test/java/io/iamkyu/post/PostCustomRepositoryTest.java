package io.iamkyu.post;

import io.iamkyu.JpaTestContext;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class PostCustomRepositoryTest extends JpaTestContext {

    @Autowired
    private PostRepository repository;

    @Test
    public void testCustomRepository() {
        //given
        String given = "hello";

        //given when
        String result = repository.print(given);

        //then
        assertThat(result).isEqualTo(given);
    }
}