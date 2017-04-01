package com.tbp.mdl.repository;


import com.tbp.mdl.model.moodle.Discussion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiscussionRepository extends CrudRepository<Discussion, Long> {

    List<Discussion> findByForumId(Long forumId);

}
