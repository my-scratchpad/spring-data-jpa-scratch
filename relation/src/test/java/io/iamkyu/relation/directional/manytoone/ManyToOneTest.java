package io.iamkyu.relation.directional.manytoone;

import io.iamkyu.HibernateTestContext;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ManyToOneTest extends HibernateTestContext {
    @Test
    public void testManyToOne() {
        //given
        Student student = new Student("kim");
        Study study = new Study("Spring", student);

        //when
        session.save(student);
        session.save(study);

        //then
        Study savedStudy = session.get(Study.class, study.getId());

        // Study 가 Student 의 외래키를 가짐.
        assertThat(savedStudy.getStudent().getId()).isEqualTo(student.getId());
    }
}