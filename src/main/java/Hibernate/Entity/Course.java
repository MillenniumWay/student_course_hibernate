package Hibernate.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "course")
@Getter
@Setter
@Builder

public class Course {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private long id;
    @Basic
    @Column(name = "name_course", nullable = true, length = 128)
    private String nameCourse;
    @OneToMany(mappedBy = "courseByCourseId")
    private Collection<Student> studentsById;


}
