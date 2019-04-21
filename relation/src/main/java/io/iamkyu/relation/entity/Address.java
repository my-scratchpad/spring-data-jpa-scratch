package io.iamkyu.relation.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Address {
    private String street;

    public Address(final String street) {
        this.street = street;
    }
}
