package pl.elearning.model;

import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 3, max = 20)
    @UniqueElements
    @Column(name = "username", nullable = false, unique = true, length = 60)
    private String username;
    @NotBlank
    @Size(min = 3, max = 20)
    @Column(name = "password")
    private String password;
    @NotBlank
    @Email
    @Column(name = "email")
    private String email;
    @Column(name = "enabled")
    private int enabled;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Course> courses;
    @Column(name = "created_on")
    private LocalDate createdOn;


    public User(Long id, String username, String password, String email, int enabled, Set<Role> roles, LocalDate createdOn) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.roles = roles;
        this.createdOn = createdOn;
    }

    @PrePersist
    public void prePersist() {
        createdOn = LocalDate.now();
    }
}
