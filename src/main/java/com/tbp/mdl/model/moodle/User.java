package com.tbp.mdl.model.moodle;

import com.tbp.mdl.model.support.Identifiable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "users")
public class User extends Identifiable<Long> {
    @Id
    @Column(name = "id", updatable=false, insertable = false)
    Long id;
    @Column(name = "username", updatable=false, insertable = false)
    String  username;
    @Column(name = "firstname", updatable=false, insertable = false)
    String firstName;
    @Column(name = "lastname", updatable=false, insertable = false)
    String lastName;
    @Column(name = "creation", updatable=false, insertable = false)
    Date creation;

    @Override
    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public String getFullName() {
        return firstName + " " + lastName;
    }
}
