package io.iamkyu.relation.bidirectional;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    private Team team;

    public Member(final String name) {
        this.name = name;
    }

    public void joinTeam(final Team team) {
        this.team = team;
    }
}

