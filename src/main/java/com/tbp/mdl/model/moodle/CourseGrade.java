package com.tbp.mdl.model.moodle;

import com.tbp.mdl.model.support.Identifiable;

import javax.persistence.*;

@Entity
@Table(name = "course_grade")
public class CourseGrade extends Identifiable<Long> {
    @Id
    @Column(name = "id", updatable=false, insertable = false)
    Long id;
    @ManyToOne
    @JoinColumn(name = "userid", updatable=false, insertable = false)
    User user;
    @ManyToOne
    @JoinColumn(name = "courseid", updatable=false, insertable = false)
    Course course;
    @Column(name = "grade", updatable=false, insertable = false)
    Float grade;

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Course getCourse() {
        return course;
    }

    public Float getGrade() {
        return grade;
    }
}
