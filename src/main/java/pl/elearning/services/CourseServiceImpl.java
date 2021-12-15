package pl.elearning.services;

import org.springframework.stereotype.Service;
import pl.elearning.repositories.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

}
