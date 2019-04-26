package io.iamkyu.projection;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<CommentSummary> findByBlog_Id(Long id);

    // 시그니처 하나로 여러개의 커스텀 프로젝션을 만들때 사용할만함.
    <T> List<T> findByBlog_Id(Long id, Class<T> type);
}
