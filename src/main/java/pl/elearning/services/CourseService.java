package pl.elearning.services;

import pl.elearning.model.Course;

import java.util.Collection;

public interface CourseService {
    Course findByName(String name);

    Collection<Course> getCourse();

    Course addCourse(Course course);

}
