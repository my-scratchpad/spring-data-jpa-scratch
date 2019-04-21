package io.iamkyu.relation.bidirectional;

import io.iamkyu.HibernateTestContext;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BiDirectionalTest extends HibernateTestContext {

    @Test
    public void testBiDirectional() {
        //given
        Member member = new Member("Member1");
        Team team = new Team("Team1");
        team.addMember(member);

        //when
        session.save(member);
        session.save(team);

        //then
        Member savedMember = session.get(Member.class, member.getId());

        // Member 가 Team 아이디 가짐. Member 를 Owner 로 설정했기 때문. Team 에 mappedBy 설정.
        assertThat(savedMember.getTeam().getId()).isEqualTo(team.getId());
    }
}