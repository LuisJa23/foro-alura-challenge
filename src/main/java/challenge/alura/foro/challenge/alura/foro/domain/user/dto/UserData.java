package challenge.alura.foro.challenge.alura.foro.domain.user.dto;

import challenge.alura.foro.challenge.alura.foro.domain.user.model.User;

public record UserData(
        Long id,
        String name,
        String email
) {
    public UserData(User user){
        this(user.getUserId(), user.getName(), user.getEmail());
    }
}
