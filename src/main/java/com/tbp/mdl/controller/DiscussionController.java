package com.tbp.mdl.controller;


import com.tbp.mdl.model.moodle.Discussion;
import com.tbp.mdl.repository.DiscussionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("discussion")
public class DiscussionController {

    @Autowired
    DiscussionRepository discussionRepository;

    @RequestMapping(value = "/forum/{forumId}", method = RequestMethod.GET)
    public List<Discussion> findByForum(@PathVariable Long forumId) {
        return discussionRepository.findByForumId(forumId);
    }
}
