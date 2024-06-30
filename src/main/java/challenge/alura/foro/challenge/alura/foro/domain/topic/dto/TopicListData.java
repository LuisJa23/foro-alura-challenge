package challenge.alura.foro.challenge.alura.foro.domain.topic.dto;

import challenge.alura.foro.challenge.alura.foro.domain.course.dto.CourseData;
import challenge.alura.foro.challenge.alura.foro.domain.topic.model.Topic;
import challenge.alura.foro.challenge.alura.foro.domain.user.dto.UserData;


import java.time.LocalDateTime;

public record TopicListData(
        Long id,
        String title,
        LocalDateTime creationDate,
        Boolean status,
        String message,
        UserData author,
        CourseData course
) {


    public TopicListData(Topic topic) {
        this(topic.getTopicId(), topic.getTitle(),topic.getCreationDate(), topic.getStatus(), topic.getMessage(), new UserData(topic.getAuthor()), new CourseData(topic.getCourse()));
    }
}
