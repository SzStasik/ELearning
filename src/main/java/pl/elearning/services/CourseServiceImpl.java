package pl.elearning.services;

import org.springframework.stereotype.Service;
import pl.elearning.model.Course;
import pl.elearning.repositories.CourseRepository;

import java.util.Collection;
import java.util.Collections;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Collection<Course> getCourse() {
        return null;
    }

    @Override
    public Course addCourse(Course course) {
        return null;
    }
}
