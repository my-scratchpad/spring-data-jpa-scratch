package io.iamkyu;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post AS p where p.title = ?1")
    List<Post> myFindByTitle(String title);

    @Query("select p from Post AS p where p.title = ?1")
    List<Post> myFindByTitleSortByTitleLength(String title, Sort sort);
}