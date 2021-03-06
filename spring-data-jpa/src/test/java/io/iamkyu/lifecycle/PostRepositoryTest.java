package io.iamkyu.lifecycle;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private PostRepository postRepository;

    @Test
    public void testPersist() {
        // Persist 는 전달 받은 객체를 Persist 상태로 변경 후 반환
        Post post = new Post("New Post");
        Post savedPost = postRepository.save(post); // Persist 발생

        assertThat(entityManager.contains(post)).isTrue();
        assertThat(post).isSameAs(savedPost);
    }

    @Test
    public void testMerge() {
        // Merge 는 전달 받은 객체를 복사해서 Persist 상태로 만들고 반함.
        Post savedPost = postRepository.save(new Post("New Post"));
        Post update = new Post("Update Post");
        update.setId(savedPost.getId());
        Post updatedPost = postRepository.save(update);// Merge 발생

        assertThat(entityManager.contains(updatedPost)).isTrue();
        assertThat(entityManager.contains(update)).isFalse();
        assertThat(updatedPost).isNotSameAs(update);
    }

    @Test
    public void testQuery() {
        //given
        Post foo = new Post("Foo");
        postRepository.save(foo);
        Post bar = new Post("Bar");
        postRepository.save(bar);

        //when
        Post found = postRepository.myFindByTitle("Bar").get(0);

        //then
        assertThat(found.getTitle()).isEqualTo(bar.getTitle());
    }

    @Test
    public void testSortWithSort() {
        postRepository.myFindByTitleSortByTitleLength("Foo", Sort.by("title"));
        postRepository.myFindByTitleSortByTitleLength("Foo", JpaSort.unsafe("LENGTH(title)"));
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void testSortWithSortWithFunction() {
        postRepository.myFindByTitleSortByTitleLength("Foo", Sort.by("LENGTH(title)"));
    }
}