package pl.elearning.servicesImpl;

import org.springframework.stereotype.Service;
import pl.elearning.model.Course;
import pl.elearning.repositories.CourseRepository;
import pl.elearning.services.CourseService;

import java.util.Collection;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Collection<Course> getCourse() {
        return courseRepository.findAll();
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
}
