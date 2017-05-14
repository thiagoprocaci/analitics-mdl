package com.tbp.mdl.model.moodle;

import com.tbp.mdl.model.support.Identifiable;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "mdl_forum_posts")
public class Post extends Identifiable<Long> {
    @Id
    @Column(name = "id", updatable=false, insertable = false)
    Long id;
    @Column(name = "parent", updatable=false, insertable = false)
    Long parentPost;
    @Column(name = "discussion", updatable=false, insertable = false)
    Long discussionId;
    @ManyToOne
    @JoinColumn(name = "userid", updatable=false, insertable = false)
    User user;
    @Column(name = "creation", updatable=false, insertable = false)
    Date creation;
    @Lob
    @Column(name = "message", updatable=false, insertable = false)
    String message;

    public Long getId() {
        return id;
    }

    public Long getParentPost() {
        return parentPost;
    }

    public Long getDiscussionId() {
        return discussionId;
    }

    public User getUser() {
        return user;
    }

}
