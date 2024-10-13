package com.auca.ac.rw.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.auca.ac.rw.model.Semester;
import com.auca.ac.rw.util.HibernateUtil;

public class SemesterController {
    @SuppressWarnings("deprecation")
    public String saveSemester(Semester semester) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(semester);
            transaction.commit();
            return "Semester saved successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Failed to save Semester";
        }
    }
}
