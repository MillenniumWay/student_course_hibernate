package Hibernate.HQL;

import Hibernate.Entity.Course;
import Hibernate.Entity.Student;
import Hibernate.Entity.StudentProfile;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import java.util.List;
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class HQL {
    public void hqlDeleteTable (Session session) {
        session.createQuery("DELETE FROM Course c WHERE c.nameCourse=:nameCourse")
                .setParameter("nameCourse","Java Enterprise").executeUpdate();
    }
    public List<Student> hqlAllStudentsOnJavaEnterprise (Session session) {
        Long id = session.createQuery("SELECT c FROM Course c WHERE c.nameCourse= :nameCourse", Course.class)
                .setParameter("nameCourse","Java Enterprise").list().get(0).getId();
        System.out.println("ID: "+id + "  OF Java Enterprise ");
        return session.createQuery("FROM Student s " +
                        "WHERE s.course_id = :course_id", Student.class).
                setParameter("course_id", id).list();
    }

    public Student hqlAddToJavaEnterprise (Session session, String first_name, String last_name) {
        return (Student) session.save(Student.builder().firstName(first_name).lastName(last_name)
                .course_id(1L).build());
    }

    public int hqlDeleteFromProfile (Session session) {
       Long id =  session.createQuery("SELECT s FROM " +
                        "StudentProfile s WHERE s.mark =:mark", StudentProfile.class)
                .setParameter("mark",6).list().get(0).getPerson_id();
        System.out.println("ID" + id);
        return session.createQuery("DELETE FROM Student  WHERE studentId=:studentId")
                .setParameter("studentId", id).executeUpdate();
    }


}
