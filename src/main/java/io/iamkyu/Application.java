package io.iamkyu;

import io.iamkyu.relation.manytomany.Member;
import io.iamkyu.relation.manytomany.Team;
import io.iamkyu.relation.manytoone.Student;
import io.iamkyu.relation.manytoone.Study;
import io.iamkyu.relation.onetomany.Book;
import io.iamkyu.relation.onetomany.BookStore;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // @Component
    public class ManyToOneTest implements ApplicationRunner {
        @PersistenceContext
        private EntityManager entityManager;

        @Transactional
        @Override
        public void run(final ApplicationArguments args) throws Exception {
            Student kim = new Student("kim");
            Study spring = new Study("Spring", kim);

            // Study 가 Student 의 외래키를 가짐.
            Session session = entityManager.unwrap(Session.class);
            session.save(kim);
            session.save(spring);
        }
    }

    // @Component
    public class OneToManyTest implements ApplicationRunner {
        @PersistenceContext
        private EntityManager entityManager;

        @Transactional
        @Override
        public void run(final ApplicationArguments args) throws Exception {
            Book jpa = new Book("JPA");
            BookStore store = new BookStore("교보문고");
            store.addBook(jpa);
            // BookStore store = new BookStore("교보문고", Arrays.asList(jpa));

            // book_store_books 라는 조인테이블 만들어짐.
            Session session = entityManager.unwrap(Session.class);
            session.save(jpa);
            session.save(store);
        }
    }

    @Component
    public class ManyToManyTest implements ApplicationRunner {
        @PersistenceContext
        private EntityManager entityManager;

        @Transactional
        @Override
        public void run(final ApplicationArguments args) throws Exception {
            Member member = new Member("Member1");
            Team team = new Team("Team1");
            team.addMember(member);

            // Member 가 Team 아이디 가짐.
            // Member 를 Owner 로 설정했기 때문. Team 에 mappedBy 설정.
            Session session = entityManager.unwrap(Session.class);
            session.save(member);
            session.save(team);
        }
    }
}
