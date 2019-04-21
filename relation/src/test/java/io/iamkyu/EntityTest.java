package io.iamkyu;

import io.iamkyu.relation.entity.Address;
import io.iamkyu.relation.entity.User;
import org.junit.Test;

import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

public class EntityTest extends HibernateTestContext {

    @Test
    public void testInsert() {
        //given
        Address home = new Address("123");
        Address company = new Address("456");
        User user = new User("foo", "bar", new Date(), "notPersistence", home, company);

        //when
        session.save(user);

        //then
        User savedUser = session.get(User.class, user.getId());

        // User 테이블에 Address 의 필드들까지 포함해서 테이블 생성
        assertThat(savedUser.getCompanyAddress().getStreet()).isEqualTo(company.getStreet());
        assertThat(savedUser.getHomeAddress().getStreet()).isEqualTo(home.getStreet());
    }
}