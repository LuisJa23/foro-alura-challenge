package challenge.alura.foro.challenge.alura.foro.domain.topic.model;

import challenge.alura.foro.challenge.alura.foro.domain.course.model.Course;
import challenge.alura.foro.challenge.alura.foro.domain.reply.model.Reply;
import challenge.alura.foro.challenge.alura.foro.domain.topic.dto.TopicRegistrationData;
import challenge.alura.foro.challenge.alura.foro.domain.topic.dto.TopicUpdateData;
import challenge.alura.foro.challenge.alura.foro.domain.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Table(name = "topic")
@Entity()
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicId;

    private String title;
    private String message;
    private LocalDateTime creationDate;
    private Boolean status;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User author;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Course course;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Reply> replies;

    public Topic(TopicRegistrationData topicRegistrationData, User author, Course course){
        this.title = topicRegistrationData.title();
        this.message = topicRegistrationData.message();
        creationDate = LocalDateTime.now();
        status = true;
        this.author = author;
        this.course = course;

    }

    public void update(TopicUpdateData topicUpdateData, User author, Course course){
        if(topicUpdateData.title() != null){
            this.title = topicUpdateData.title();
        }
        if(topicUpdateData.message() != null){
            this.message = topicUpdateData.message();
        }
        if(topicUpdateData.authorId() != null){
            this.author = author;
        }
        if(topicUpdateData.courseId() != null){
            this.course = course;
        }


    }


}
