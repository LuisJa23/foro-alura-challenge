package challenge.alura.foro.challenge.alura.foro.domain.topic.dto;

import challenge.alura.foro.challenge.alura.foro.domain.course.dto.CourseData;
import challenge.alura.foro.challenge.alura.foro.domain.topic.model.Topic;
import challenge.alura.foro.challenge.alura.foro.domain.user.dto.UserData;

public record TopicResponseData(

        Long id,
        String title,
        String message,
        UserData author,
        CourseData course
) {

    public TopicResponseData(Topic topic){
        this(topic.getTopicId(), topic.getTitle(), topic.getMessage(), new UserData(topic.getAuthor()), new CourseData(topic.getCourse()));
    }
}
