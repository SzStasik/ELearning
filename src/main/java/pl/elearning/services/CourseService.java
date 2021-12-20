package pl.elearning.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.elearning.model.Course;
import pl.elearning.repositories.CourseRepository;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> listAll() {
        return courseRepository.findAll();
    }

    public void save(Course course) {
        courseRepository.save(course);
    }

    public Course getCourse(Long id) {
        return courseRepository.findById(id).get();
    }

    public void delete(Long id) {
        courseRepository.deleteById(id);
    }
}
