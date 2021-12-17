package pl.elearning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.elearning.model.Course;


public interface CourseRepository extends JpaRepository<Course, Long> {
}