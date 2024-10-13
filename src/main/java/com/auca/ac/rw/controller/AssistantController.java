package com.auca.ac.rw.controller;

import com.auca.ac.rw.model.Assistant;
import com.auca.ac.rw.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class AssistantController {

    // Method to save an assistant
    @SuppressWarnings("deprecation")
    public String saveAssistant(Assistant assistant) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(assistant);
            transaction.commit();
            return "Assistant saved successfully";
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Failed to save assistant";
        }
    }

    // Method to retrieve all assistants
    public List<Assistant> getAllAssistants() {
        List<Assistant> assistants;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            assistants = session.createQuery("FROM Assistant", Assistant.class).getResultList();
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return assistants;
    }
}
