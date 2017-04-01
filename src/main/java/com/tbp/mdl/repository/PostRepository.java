package com.tbp.mdl.repository;


import com.tbp.mdl.model.moodle.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Long> {

    List<Post> findByDiscussionId(Long discussionId);

    @Query(value = "select post.* from mdl_forum_posts post " +
            "inner join mdl_forum_discussions discussion on post.discussion = discussion.id " +
            "inner join mdl_forum forum on discussion.forum = forum.id " +
            "inner join mdl_course course on forum.course = course.id " +
            "where course.id = ?1", nativeQuery = true)
    List<Post> findByCourseId(Long courseId);


}
