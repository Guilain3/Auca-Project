package com.auca.ac.rw.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.auca.ac.rw.model.CourseDefinition;
import com.auca.ac.rw.util.HibernateUtil;

public class CourseDefinitionController {
    @SuppressWarnings("deprecation")
    public String saveCourseDefinition(CourseDefinition courseDefinition) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(courseDefinition);
            transaction.commit();
            return "Course Definition saved successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Failed to save Course Definition";
        }
    }
}
