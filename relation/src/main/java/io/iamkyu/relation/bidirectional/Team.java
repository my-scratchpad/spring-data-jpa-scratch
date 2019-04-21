package io.iamkyu.relation.bidirectional;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Team {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();

    public Team(final String name) {
        this.name = name;
    }

    // Convenient Method
    // 양방향 관계에서 양쪽 객체 모두에게 참조를 설정하는 것 중요!
    public void addMember(final Member member) {
        this.members.add(member);
        member.joinTeam(this);
    }
}
