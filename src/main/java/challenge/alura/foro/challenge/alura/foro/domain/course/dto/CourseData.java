package challenge.alura.foro.challenge.alura.foro.domain.course.dto;

import challenge.alura.foro.challenge.alura.foro.domain.course.model.Course;

public record CourseData(
        Long id,
        String name,
        String category
) {
    public CourseData(Course course){
        this(course.getCourseId(), course.getName(), course.getCategory());
    }
}
