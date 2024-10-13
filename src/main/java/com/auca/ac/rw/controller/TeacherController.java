package com.auca.ac.rw.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.auca.ac.rw.model.Teacher;
import com.auca.ac.rw.util.HibernateUtil;

public class TeacherController {
    @SuppressWarnings("deprecation")
    public String saveTeacher(Teacher teacher) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(teacher);
            transaction.commit();
            return "Teacher saved successfully";  
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Failed to save teacher";
        }
    }
}
