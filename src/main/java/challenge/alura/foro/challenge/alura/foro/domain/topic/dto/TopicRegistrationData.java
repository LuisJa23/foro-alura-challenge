package challenge.alura.foro.challenge.alura.foro.domain.topic.dto;



import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record TopicRegistrationData(


     @NotBlank String title,
     @NotBlank String message,
     @NotNull Long authorId,
     @NotNull Long courseId
) {
}
