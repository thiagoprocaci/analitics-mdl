package com.tbp.mdl.model.moodle;

import com.tbp.mdl.model.support.Identifiable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mdl_course")
public class Course extends Identifiable<Long> {

    @Id
    @Column(name = "id", updatable=false, insertable = false)
    Long id;
    @Column(name = "shortname", updatable=false, insertable = false)
    String shortName;
    @Column(name = "fullname", updatable=false, insertable = false)
    String fullName;

    public Long getId() {
        return id;
    }

    public String getShortName() {
        return shortName;
    }

    public String getFullName() {
        return fullName;
    }

}
