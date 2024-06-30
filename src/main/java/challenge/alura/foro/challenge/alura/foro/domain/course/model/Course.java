package challenge.alura.foro.challenge.alura.foro.domain.course.model;


import challenge.alura.foro.challenge.alura.foro.domain.topic.model.Topic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "course")
@Entity()
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Course {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String name;

    private String category;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Topic> topics;

}
