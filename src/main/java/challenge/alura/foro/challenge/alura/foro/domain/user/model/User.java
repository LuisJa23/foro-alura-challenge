package challenge.alura.foro.challenge.alura.foro.domain.user.model;

import challenge.alura.foro.challenge.alura.foro.domain.profile.model.Profile;
import challenge.alura.foro.challenge.alura.foro.domain.reply.model.Reply;
import challenge.alura.foro.challenge.alura.foro.domain.topic.model.Topic;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "foro_user")
@Entity()
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String name;

    @Column(unique = true)
    private String email;

    private String password;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Topic> topics;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Reply> replies;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_profile",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "profile_id")
    )
    private List<Profile> profile;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
