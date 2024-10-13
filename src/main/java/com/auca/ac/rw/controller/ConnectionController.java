package com.auca.ac.rw.controller;

import org.hibernate.Session;
import com.auca.ac.rw.util.HibernateUtil;

public class ConnectionController {

    public String establishConnection() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // Check if session is open and connected
            if (session.isOpen() && session.isConnected()) {
                System.out.println("Hibernate session is connected.");
                return "connected";
            } else {
                System.out.println("Hibernate session is not connected.");
                return "not connected";
            }
        } catch (Exception ex) {
            // Log the exception and return the exception message
            System.out.println("Exception during Hibernate session connection: " + ex.getMessage());
            ex.printStackTrace();
            return "connection failed: " + ex.getMessage();
        }
    }
}
