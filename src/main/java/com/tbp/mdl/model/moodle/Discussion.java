package com.tbp.mdl.model.moodle;

import com.tbp.mdl.model.support.Identifiable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "discussion")
public class Discussion extends Identifiable<Long> {
    @Id
    @Column(name = "id", updatable=false, insertable = false)
    Long id;
    @Column(name = "name", updatable=false, insertable = false)
    String name;
    @Column(name = "forumid", updatable=false, insertable = false)
    Long forumId;
    @Column(name = "userid", updatable=false, insertable = false)
    Long userId;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getForumId() {
        return forumId;
    }

    public Long getUserId() {
        return userId;
    }
}
