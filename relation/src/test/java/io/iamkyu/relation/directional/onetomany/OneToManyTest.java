package io.iamkyu.relation.directional.onetomany;

import io.iamkyu.HibernateTestContext;
import org.junit.Test;

public class OneToManyTest extends HibernateTestContext {
    @Test
    public void testOneToMany() {
        //given
        Book jpa = new Book("JPA");
        BookStore store = new BookStore("교보문고");
        store.addBook(jpa);

        //when
        session.save(jpa);
        session.save(store);

        //then
        // book_store_books 라는 조인테이블 만들어짐.
    }
}