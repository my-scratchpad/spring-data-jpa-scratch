package io.iamkyu;

import javax.persistence.Column;
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

    public User(final String userName, final String password, final Date created, final String ignoreField) {
        this.userName = userName;
        this.password = password;
        this.created = created;
        this.ignoreField = ignoreField;
    }
}
