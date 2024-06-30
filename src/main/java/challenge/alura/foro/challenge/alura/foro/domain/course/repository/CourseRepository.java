package challenge.alura.foro.challenge.alura.foro.domain.course.repository;

import challenge.alura.foro.challenge.alura.foro.domain.course.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
