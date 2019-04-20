package io.iamkyu;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.util.Date;

@Entity(name = "account")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Temporal(TemporalType.DATE)
    private Date created;

    @Transient
    private String ignoreField;

    @Embedded
    private Address homeAddress;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = ("company_street")))
    })
    private Address companyAddress;

    public User(final String userName, final String password, final Date created, final String ignoreField, final Address homeAddress, final Address companyAddress) {
        this.userName = userName;
        this.password = password;
        this.created = created;
        this.ignoreField = ignoreField;
        this.homeAddress = homeAddress;
        this.companyAddress = companyAddress;
    }
}
