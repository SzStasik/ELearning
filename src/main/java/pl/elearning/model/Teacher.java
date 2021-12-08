package pl.elearning.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "teacher")
public class Teacher {
    @Id
    @Column(name = "teacher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long teacherId;
    private String teacherName;
    private String teacherSurname;
    private String teacherEmail;
    private String teacherPassword;

    public Teacher(Long teacherId, String teacherName, String teacherSurname, String teacherEmail, String teacherPassword) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherSurname = teacherSurname;
        this.teacherEmail = teacherEmail;
        this.teacherPassword = teacherPassword;
    }
}
