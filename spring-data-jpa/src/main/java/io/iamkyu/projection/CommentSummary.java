package io.iamkyu.projection;


import org.springframework.beans.factory.annotation.Value;

public interface CommentSummary {
    int getUp();

    int getDown();

    // Open Projection. target = Comment. 결국 target 을 전부 로딩함
    @Value("#{target.up + ' ' + target.down}")
    String getVotes();

    // 위 방법의 단점을 보완하기 위한 방법
    // default String getVotes() {
    //     return getUp() + " " + getDown();
    // }
}
