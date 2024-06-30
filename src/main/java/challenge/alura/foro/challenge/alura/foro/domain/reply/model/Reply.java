package challenge.alura.foro.challenge.alura.foro.domain.reply.model;

import challenge.alura.foro.challenge.alura.foro.domain.topic.model.Topic;
import challenge.alura.foro.challenge.alura.foro.domain.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "reply")
@Entity()
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;
    private String message;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Topic topic;

    private LocalDate creationDate;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private User author;

    private String solution;

}
