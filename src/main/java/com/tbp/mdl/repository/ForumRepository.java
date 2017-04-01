package com.tbp.mdl.repository;

import com.tbp.mdl.model.moodle.Forum;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ForumRepository extends CrudRepository<Forum, Long> {

    List<Forum> findByCourseId(Long courseId);

}
