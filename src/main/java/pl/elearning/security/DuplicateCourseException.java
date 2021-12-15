package pl.elearning.security;

import pl.elearning.model.Course;

public class DuplicateCourseException extends RuntimeException{
    private final Course course;
    public DuplicateCourseException(Course course){
        this.course = course;
    }
}
