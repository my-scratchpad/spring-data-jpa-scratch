package io.iamkyu.relation.manytomany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
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

    public void joinTeam(Team team) {
        this.team = team;
    }
}

