package io.iamkyu;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RunWith(SpringRunner.class)
@DataJpaTest
public class HibernateTestContext {

    @PersistenceContext
    private EntityManager entityManager;

    protected Session session;

    @Before
    public void setUp() {
        session = entityManager.unwrap(Session.class);
    }
}
