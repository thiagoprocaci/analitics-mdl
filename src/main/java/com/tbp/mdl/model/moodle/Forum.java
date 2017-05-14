package com.tbp.mdl.model.moodle;


import com.tbp.mdl.model.support.Identifiable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mdl_forum")
public class Forum extends Identifiable<Long> {

    @Id
    @Column(name = "id", updatable=false, insertable = false)
    Long id;
    @Column(name = "course", updatable=false, insertable = false)
    Long courseId;
    @Column(name = "name", updatable=false, insertable = false)
    String name;
    @Column(name = "type", updatable=false, insertable = false)
    String type;

    public Long getId() {
        return id;
    }

    public Long getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
