package com.auca.ac.rw.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
// import org.hibernate.mapping.List;
import java.util.List;

import com.auca.ac.rw.model.AcademicUnit;
import com.auca.ac.rw.model.Course;
import com.auca.ac.rw.model.Student;
import com.auca.ac.rw.util.HibernateUtil;

public class CourseController {
    @SuppressWarnings("deprecation")
    public String saveCourse(Course course) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(course);
            transaction.commit();
            return "Course saved successfully";  
        } catch (Exception ex) {
            ex.printStackTrace(); 
            return "Failed to save Course: " + ex.getMessage();
        }
    }

public List<Student> getStudentsByCourseAndSemester(String courseCode, int semesterId) {
        List<Student> students;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            students = session.createQuery(
                    "SELECT sr.student FROM StudentRegistration sr " +
                    "JOIN sr.courses c " +
                    "WHERE c.courseCode = :courseCode AND sr.semester.id = :semesterId", Student.class)
                    .setParameter("courseCode", courseCode)
                    .setParameter("semesterId", semesterId)
                    .getResultList();
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return students;
    }

     public List<Course> getCoursesByDepartmentAndSemester(AcademicUnit department, int semesterId) {
        List<Course> courses;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            courses = session.createQuery(
                    "FROM Course c WHERE c.department = :department AND c.semester.id = :semesterId", Course.class)
                    .setParameter("department", department)
                    .setParameter("semesterId", semesterId)
                    .getResultList();
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return courses;
    }

}
