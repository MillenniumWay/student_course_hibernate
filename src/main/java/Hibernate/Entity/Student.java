package Hibernate.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "student")
@Getter
@Setter
@Builder

public class Student {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "student_id", nullable = false)
    private long studentId;
    @Basic
    @Column(name = "first_name", nullable = false, length = 128)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = false, length = 128)
    private String lastName;

    private Long course_id;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Course courseByCourseId;
    @OneToMany(targetEntity = Student.class)
    private Collection<StudentProfile> studentProfilesByStudentId;





}
