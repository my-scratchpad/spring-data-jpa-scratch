package io.iamkyu.relation.manytomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
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

    public void addMember(final Member member) {
        this.members.add(member);

        // 양방향 관계에서 중요!
        member.joinTeam(this);
    }
}
