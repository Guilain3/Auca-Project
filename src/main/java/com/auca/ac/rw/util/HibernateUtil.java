package com.auca.ac.rw.util;

import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.auca.ac.rw.model.AcademicUnit;
import com.auca.ac.rw.model.Assistant;
import com.auca.ac.rw.model.Course;
import com.auca.ac.rw.model.CourseDefinition;
import com.auca.ac.rw.model.Semester;
import com.auca.ac.rw.model.Student;
import com.auca.ac.rw.model.StudentRegistration;
import com.auca.ac.rw.model.Teacher;

public class HibernateUtil {

    private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration configuration = new Configuration();

            Properties property = new Properties();
            property.put(Environment.URL, "jdbc:postgresql://localhost:5432/auca");
            property.put(Environment.USER, "postgres");
            property.put(Environment.PASS, "000000");
            property.put(Environment.SHOW_SQL, true);
            property.put(Environment.HBM2DDL_AUTO, "update");

            configuration.addProperties(property);
            configuration.addAnnotatedClass(Student.class);
            configuration.addAnnotatedClass(Course.class);
            configuration.addAnnotatedClass(StudentRegistration.class);
            configuration.addAnnotatedClass(AcademicUnit.class);
            configuration.addAnnotatedClass(CourseDefinition.class);
            configuration.addAnnotatedClass(Semester.class);
            configuration.addAnnotatedClass(Teacher.class);
            configuration.addAnnotatedClass(Assistant.class);

            sessionFactory = configuration.buildSessionFactory();
        }
        return sessionFactory;
    }

    public static Session openSession() {
        return getSessionFactory().openSession();
    }
}
