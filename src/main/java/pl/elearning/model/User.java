package pl.elearning.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", nullable = false, unique = true, length = 60)
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "enabled")
    private int enabled;
    @Column(name = "details")
    private String details;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Course> courses;
    @Column(name = "created_on")
    private LocalDate createdOn;


    public User(Long id, String username, String password, String email, int enabled, String details, Set<Role> roles, LocalDate createdOn) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.details = details;
        this.roles = roles;
        this.createdOn = createdOn;
    }

    @PrePersist
    public void prePersist() {
        createdOn = LocalDate.now();
    }
}
