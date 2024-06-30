package challenge.alura.foro.challenge.alura.foro.domain.topic.validation;

import challenge.alura.foro.challenge.alura.foro.domain.topic.dto.TopicRegistrationData;

public interface TopicValidation {

    public void validate(TopicRegistrationData topicRegistrationData);

}
