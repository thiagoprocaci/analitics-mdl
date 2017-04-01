package com.tbp.mdl.controller;

import com.tbp.mdl.model.moodle.Course;
import com.tbp.mdl.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Course> findAll() {
        return courseRepository.findWithPosts();
    }
}
