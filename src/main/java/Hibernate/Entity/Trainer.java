package Hibernate.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "trainer", schema = "public", catalog = "postgres")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class Trainer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_of_trainer", nullable = false)
    private int idOfTrainer;
    @Basic
    @Column(name = "first_name", nullable = false, length = 128)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = false, length = 128)
    private String lastName;
    @Basic
    @Column(name = "age", nullable = false)
    private int age;
    @Basic
    @Column(name = "education", nullable = false, length = 128)
    private String education;
    @Basic
    @Column(name = "list_of_courses", nullable = false)
    private long listOfCourses;


}
