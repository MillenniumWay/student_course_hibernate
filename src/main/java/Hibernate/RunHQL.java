package Hibernate;

import Hibernate.HQL.HQL;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunHQL {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        HQL hql = new HQL();
        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
             session.beginTransaction();
        //     hql.hqlAllStudentsOnJavaEnterprise(session);
        //     hql.hqlDeleteTable(session);
        //     hql.hqlAddToJavaEnterprise(session,"Paul", "Flow");
        //     hql.hqlDeleteFromProfile(session);
             session.close();
        }
    }
}
