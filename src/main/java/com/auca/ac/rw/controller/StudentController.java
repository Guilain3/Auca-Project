package com.auca.ac.rw.controller;

import com.auca.ac.rw.model.AcademicUnit;
import com.auca.ac.rw.model.Course;
import com.auca.ac.rw.model.Student;
import com.auca.ac.rw.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentController {
    @SuppressWarnings("deprecation")
    public String saveStudent(Student student) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
            return "Student saved successfully";  
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Failed to save student";
        }
    }

    public List<Student> getStudentsBySemester(int semesterId) {
        List<Student> students;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            students = session.createQuery("SELECT sr.student FROM StudentRegistration sr WHERE sr.semester.id = :semesterId", Student.class)
                    .setParameter("semesterId", semesterId)
                    .getResultList();
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return students;
    }

     public List<Course> getCoursesByStudent(int studentId) {
        List<Course> courses;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            courses = session.createQuery(
                    "SELECT sr.courses FROM StudentRegistration sr WHERE sr.student.id = :studentId", Course.class)
                    .setParameter("studentId", studentId)
                    .getResultList();
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return courses;
    }

public List<Student> getStudentsByDepartmentAndSemester(AcademicUnit department, int semesterId) {
        List<Student> students;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            students = session.createQuery(
                    "SELECT sr.student FROM StudentRegistration sr " +
                    "WHERE sr.department = :department AND sr.semester.id = :semesterId", Student.class)
                    .setParameter("department", department)
                    .setParameter("semesterId", semesterId)
                    .getResultList();
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return students;
    }

}
