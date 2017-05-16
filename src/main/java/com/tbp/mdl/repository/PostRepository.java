package com.tbp.mdl.repository;


import com.tbp.mdl.model.moodle.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findByDiscussionId(Long discussionId);

    @Query(value = "select post.* from post post " +
            "inner join discussion discussion on post.discussionid = discussion.id " +
            "inner join forum forum on discussion.forumid = forum.id " +
            "inner join course course on forum.courseid = course.id " +
            "where course.id = ?1", nativeQuery = true)
    List<Post> findByCourseId(Long courseId);


}
