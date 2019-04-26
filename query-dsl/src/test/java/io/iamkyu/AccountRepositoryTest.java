package io.iamkyu;

import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void queryDslTest() {
        //given
        BooleanExpression contains = QAccount.account.firstName.containsIgnoreCase("kyu");
        BooleanExpression startWith = QAccount.account.lastName.startsWith("iam");
        Predicate predicate = contains.and(startWith);

        //when
        Optional<Account> optional = accountRepository.findOne(predicate);

        //then
        assertThat(optional).isEmpty();
    }
}