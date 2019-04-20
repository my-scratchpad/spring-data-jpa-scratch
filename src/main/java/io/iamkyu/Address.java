package io.iamkyu;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Address {
    private String street;

    public Address(final String street) {
        this.street = street;
    }
}
