package com.tbp.mdl.repository;


import com.tbp.mdl.model.moodle.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {

    @Query(value = "select c.* from course c where c.id in ( " +
            " SELECT course.id  " +
            " FROM post post " +
            " INNER JOIN discussion discussion ON post.discussionid = discussion.id " +
            " INNER JOIN forum forum ON discussion.forumid = forum.id " +
            " INNER JOIN course course ON forum.courseid = course.id " +
            " group by course.id " +
            " having  count(post.id) > 50 and sum(post.parentpostid) > 0 " +
            " order by course.id ) ", nativeQuery = true)
    List<Course> findWithPosts();

}
