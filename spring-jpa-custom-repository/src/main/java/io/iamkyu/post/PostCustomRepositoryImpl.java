package io.iamkyu.post;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

// 접미사로 Impl 필수
@Repository
@Transactional
public class PostCustomRepositoryImpl implements PostCustomRepository {

    @Override
    public String print(final String text) {
        return text;
    }
}
