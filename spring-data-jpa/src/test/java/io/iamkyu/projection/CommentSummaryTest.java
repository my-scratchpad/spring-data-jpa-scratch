package io.iamkyu.projection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CommentSummaryTest {

    @Autowired
    private CommentRepository commentRepository;

    @Test
    public void testClosedProjection() {
        List<CommentSummary> onlySummary = commentRepository.findByBlog_Id(1L);
    }
}