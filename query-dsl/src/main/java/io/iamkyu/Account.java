package io.iamkyu;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Account {
    @Id
    @GeneratedValue
    private Long id;

    private String userName;

    private String firstName;

    private String lastName;

    public Account(final String userName, final String firstName, final String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
