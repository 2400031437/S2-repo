package com.klu.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.klu.entity.Product;

public class ProductApp {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();

        Product p1 = new Product("Laptop", "Electronics", 75000, 10);
        Product p2 = new Product("Mouse", "Accessories", 1500, 50);
        Product p3 = new Product("Keyboard", "Accessories", 3000, 25);
        Product p4 = new Product("Monitor", "Electronics", 12000, 15);
        Product p5 = new Product("Router", "Networking", 3500, 12);

        Transaction tx = s.beginTransaction();
        s.persist(p1);
        s.persist(p2);
        s.persist(p3);
        s.persist(p4);
        s.persist(p5);
        tx.commit();

        s.close();
        sf.close();
    }
}
