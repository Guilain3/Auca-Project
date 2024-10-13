package com.auca.ac.rw.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.auca.ac.rw.model.AcademicUnit;
import com.auca.ac.rw.util.HibernateUtil;

public class AcademicUnitController {
    @SuppressWarnings("deprecation")
    public String saveAcademicUnits(AcademicUnit... academicUnits) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            for (AcademicUnit unit : academicUnits) {
                session.save(unit);
            }
            transaction.commit();
            return "Academic Units saved successfully";  
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Failed to save Academic Units";
        }
    }
}
