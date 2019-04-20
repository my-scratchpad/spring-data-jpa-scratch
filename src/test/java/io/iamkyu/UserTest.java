package io.iamkyu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserTest {

    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void testInsert() {
        Address home = new Address("123");
        Address company = new Address("456");
        User user = new User("foo", "bar", new Date(), "notPersistence", home, company);
        entityManager.persist(user);
    }
}