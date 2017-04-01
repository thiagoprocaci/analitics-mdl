package com.tbp.mdl.model.moodle;

import com.tbp.mdl.model.support.Identifiable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
    @Column(name = "userid", updatable=false, insertable = false)
    Long userId;

    public Long getId() {
        return id;
    }

    public Long getParentPost() {
        return parentPost;
    }

    public Long getDiscussionId() {
        return discussionId;
    }

    public Long getUserId() {
        return userId;
    }
}
