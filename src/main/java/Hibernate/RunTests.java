package Hibernate;

import Hibernate.Entity.Course;
import Hibernate.Entity.Student;
import Hibernate.Entity.StudentProfile;
import Hibernate.Entity.Trainer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.Test;
public class RunTests {

    @Test
    public void deleteTheCourse () {
        Configuration configuration = new Configuration();
        configuration.configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
             session.createQuery("DELETE FROM Course c WHERE c.nameCourse=:nameCourse")
                    .setParameter("nameCourse","Java Enterprise").executeUpdate();
             session.close();
          }
        }

    @Test
    public void addNewTrainer () {
        Configuration configuration = new Configuration();
        configuration.configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
             session.beginTransaction();
            var trainer = Trainer.builder()
                    .firstName("Kelvin")
                    .lastName("McLaren")
                    .age(33)
                    .listOfCourses(1)
                    .education("BGY")
                    .build();
            session.save(trainer);
            session.close();
        }
    }

    @Test
    public void changeCourse () {
        Configuration configuration = new Configuration();
        configuration.configure();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("UPDATE Course c SET c.nameCourse=:nameCourse WHERE c.nameCourse = :nameCourse2", Course.class);
            query.setParameter("nameCourse", "C#");
            query.setParameter("nameCourse2","Kotlin");
            query.executeUpdate();
        } catch (IllegalArgumentException illegalArgumentException) {
            illegalArgumentException.printStackTrace();
        }
    }

    public static void main(String[] args) {
    Configuration configuration = new Configuration();
    configuration.configure();
    try (SessionFactory sessionFactory = configuration.buildSessionFactory();
    Session session = sessionFactory.openSession()){
         session.beginTransaction();




      var trainer = Trainer.builder()
              .firstName("Kelvin")
              .lastName("McLaren")
              .age(33)
              .listOfCourses(1)
              .education("BGY")
              .build();


        var course = Course.builder()
                        .nameCourse("Java Core")
                                .build();

        var student = Student.builder()
                .firstName("Ayaka")
                .lastName("Lazy")
                .course_id(1L)
                .build();

        var profile = StudentProfile.builder()
                .mark(5)
                .person_id(3L)
                .build();

         session.save(course);
         session.close();


        }
    }
    }

