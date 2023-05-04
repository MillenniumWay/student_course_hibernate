package Hibernate.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "student_profile", schema = "public", catalog = "postgres")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_of_mark")
    private int id_of_mark;

    @Basic
    @Column(name = "mark", nullable = false)
    private int mark;

    @Column(nullable = false)
    private Long person_id;
    @ManyToOne(targetEntity = Student.class)
    @JoinColumn(name = "person_id", referencedColumnName = "student_id", insertable = false, updatable = false)
    private Student student;


}
