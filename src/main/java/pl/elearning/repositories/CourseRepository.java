package pl.elearning.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.elearning.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findCourseByName(String name);
}