package challenge.alura.foro.challenge.alura.foro.domain.profile.model;


import challenge.alura.foro.challenge.alura.foro.domain.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "profile")
@Entity()
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileId;
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_profile",
            joinColumns = @JoinColumn(name = "profile_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;




}
