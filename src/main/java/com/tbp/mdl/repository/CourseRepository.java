package com.tbp.mdl.repository;


import com.tbp.mdl.model.moodle.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {

    @Query(value = "select c.* from mdl_course c where c.id in ( " +
            " SELECT course.id  " +
            " FROM mdl_forum_posts post " +
            " INNER JOIN mdl_forum_discussions discussion ON post.discussion = discussion.id " +
            " INNER JOIN mdl_forum forum ON discussion.forum = forum.id " +
            " INNER JOIN mdl_course course ON forum.course = course.id " +
            " group by course.id " +
            " having  count(post.id) > 1 and sum(post.parent) > 0 " +
            " order by course.id ) ", nativeQuery = true)
    List<Course> findWithPosts();

}
