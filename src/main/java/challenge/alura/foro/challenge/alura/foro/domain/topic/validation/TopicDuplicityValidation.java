package challenge.alura.foro.challenge.alura.foro.domain.topic.validation;

import challenge.alura.foro.challenge.alura.foro.domain.topic.dto.TopicRegistrationData;
import challenge.alura.foro.challenge.alura.foro.domain.topic.repository.TopicRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class TopicDuplicityValidation implements TopicValidation{

    @Autowired
    private TopicRepository topicRepository;
    @Override
    public void validate(TopicRegistrationData topicRegistrationData) {
        if(topicRegistrationData!=null){
            var topics = topicRepository.findAll();
            String title = topicRegistrationData.title().toLowerCase();
            String message = topicRegistrationData.message().toLowerCase();

            boolean isDuplicate = topics.stream()
                    .anyMatch(topic -> topic.getTitle().toLowerCase().equals(title) && topic.getMessage().toLowerCase().equals(message));

            if (isDuplicate) {
                throw new IllegalArgumentException("Topico duplicadp con titulo : " + title + " y mensaje: " + message);
            }
        }

    }
}
