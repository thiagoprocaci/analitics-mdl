package com.tbp.mdl.controller;


import com.tbp.mdl.model.moodle.Post;
import com.tbp.mdl.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("post")
public class PostController {

    @Autowired
    PostRepository postRepository;

    @RequestMapping(value = "/discussion/{discussionId}", method = RequestMethod.GET)
    public List<Post> findByForum(@PathVariable Long discussionId) {
        return postRepository.findByDiscussionId(discussionId);
    }

    @RequestMapping(value = "/course/{courseId}", method = RequestMethod.GET)
    public List<Post> findByCourse(@PathVariable Long courseId) {
        return postRepository.findByCourseId(courseId);
    }

}
