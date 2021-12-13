package pl.elearning.services;

import org.springframework.stereotype.Service;
import pl.elearning.model.Course;
import pl.elearning.repositories.CourseRepository;

import java.util.Collection;

@Service
public class CourseServiceImpl implements CourseService{
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Course findByName(String name) {
        return courseRepository.findCourseByName(name);
    }

    @Override
    public Collection<Course> getCourse() {
        return null;
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.findCourseByName(course.getName());
    }

}
