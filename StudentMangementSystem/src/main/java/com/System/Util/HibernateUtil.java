package com.System.Util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    // Static variable to hold the single instance of SessionFactory
    private static final SessionFactory sessionFactory = buildSessionFactory();

    // Private method to build the SessionFactory object
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception and throw an error as it might be fatal
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Public method to provide the singleton SessionFactory instance
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
