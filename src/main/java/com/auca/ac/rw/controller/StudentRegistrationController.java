package com.auca.ac.rw.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.auca.ac.rw.model.StudentRegistration;
import com.auca.ac.rw.util.HibernateUtil;

public class StudentRegistrationController {
    @SuppressWarnings("deprecation")
    public String saveStudentRegistration(StudentRegistration studentRegistration) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(studentRegistration);
            transaction.commit();
            return "Student Registration saved successfully";
        } catch (Exception ex) {
            ex.printStackTrace(); 
            return "Failed to save Student Registration: " + ex.getMessage();
        }
    }
    
}
