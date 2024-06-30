package challenge.alura.foro.challenge.alura.foro.domain.topic.service;

import challenge.alura.foro.challenge.alura.foro.domain.course.dto.CourseData;
import challenge.alura.foro.challenge.alura.foro.domain.course.model.Course;
import challenge.alura.foro.challenge.alura.foro.domain.course.repository.CourseRepository;
import challenge.alura.foro.challenge.alura.foro.domain.topic.dto.TopicListData;
import challenge.alura.foro.challenge.alura.foro.domain.topic.dto.TopicRegistrationData;
import challenge.alura.foro.challenge.alura.foro.domain.topic.dto.TopicResponseData;
import challenge.alura.foro.challenge.alura.foro.domain.topic.dto.TopicUpdateData;
import challenge.alura.foro.challenge.alura.foro.domain.topic.model.Topic;
import challenge.alura.foro.challenge.alura.foro.domain.topic.repository.TopicRepository;
import challenge.alura.foro.challenge.alura.foro.domain.topic.validation.TopicValidation;
import challenge.alura.foro.challenge.alura.foro.domain.user.dto.UserData;
import challenge.alura.foro.challenge.alura.foro.domain.user.model.User;
import challenge.alura.foro.challenge.alura.foro.domain.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CourseRepository courseRepository;


    @Autowired
    List<TopicValidation> validators;


    public TopicResponseData save(TopicRegistrationData topicRegistrationData) {
        validators.forEach(v -> v.validate(topicRegistrationData));

        User user = userRepository.findById(topicRegistrationData.authorId())
                .orElseThrow(() -> new NoSuchElementException("No user found with id: " + topicRegistrationData.authorId()));

        Course course = courseRepository.findById(topicRegistrationData.courseId())
                .orElseThrow(() -> new NoSuchElementException("No course found with id: " + topicRegistrationData.courseId()));

        var topic = new Topic(topicRegistrationData, user, course);
        topicRepository.save(topic);

        return new TopicResponseData(
                topicRegistrationData.authorId(),
                topicRegistrationData.title(),
                topicRegistrationData.message(),
                new UserData(user),
                new CourseData(course)
        );
    }


    public Page<TopicListData> list(Pageable pageable){
        Page<TopicListData> list = topicRepository.findAllByStatusTrue(pageable).map(TopicListData::new);
        return list;
    }

    public Optional<Topic> unite(Long id){
        var topic = topicRepository.findById(id);
        return topic;
    }

    public Topic update(Long id, TopicUpdateData topicUpdateData){
        var topic = topicRepository.findById(id).get();
        User author =  null;
        Course course = null;
        if(topicUpdateData.authorId() != null){
            author = userRepository.findById(topicUpdateData.authorId()).get();
        }
        if(topicUpdateData.courseId() != null){
            course = courseRepository.findById(topicUpdateData.courseId()).get();
        }
        topic.update(topicUpdateData, author, course);
        return topic;
    }



    public void delete(Long id){
        topicRepository.deleteTopicById(id);
    }
}
