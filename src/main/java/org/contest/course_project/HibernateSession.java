package org.contest.course_project;

import org.contest.course_project.entities.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession {
    public static SessionFactory sessionFactory() {
        return new Configuration()
                .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5431/comission")
                .setProperty("hibernate.connection.username", "postgres")
                .setProperty("hibernate.connection.password", "sef123")
                .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
                //.setProperty("hibernate.hbm2ddl.auto", "create")
                .addAnnotatedClass(AdmissionCommittee.class)
                .addAnnotatedClass(Applicant.class)
                .addAnnotatedClass(Discipline.class)
                .addAnnotatedClass(Exam.class)
                .addAnnotatedClass(Specialty.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Teacher.class)
                .buildSessionFactory();
    }
}
