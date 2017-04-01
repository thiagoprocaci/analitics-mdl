package com.tbp.mdl.controller;

import com.tbp.mdl.model.moodle.Forum;

import com.tbp.mdl.repository.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("forum")
public class ForumController {

    @Autowired
    ForumRepository forumRepository;

    @RequestMapping(value = "/course/{courseId}", method = RequestMethod.GET)
    public List<Forum> findByCourse(@PathVariable Long courseId) {
        return forumRepository.findByCourseId(courseId);

    }

}
