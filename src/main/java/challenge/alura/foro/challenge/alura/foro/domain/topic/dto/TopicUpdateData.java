package challenge.alura.foro.challenge.alura.foro.domain.topic.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicUpdateData(
        String title,
        String message,
        Long authorId,
        Long courseId
) {
}
