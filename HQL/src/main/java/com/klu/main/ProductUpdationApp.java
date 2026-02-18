package com.klu.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

public class ProductUpdationApp {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        Transaction tx = s.beginTransaction();

        // ===== UPDATE =====
        String update = "Update Product set price = price + 1000 where description = :desc";
        MutationQuery q1 = s.createMutationQuery(update);
        q1.setParameter("desc", "Electronics");
        int res = q1.executeUpdate();
        System.out.println("Updated rows: " + res);

        // ===== DELETE =====
        String delete = "Delete from Product where quantity = 0";
        MutationQuery q2 = s.createMutationQuery(delete);
        int res2 = q2.executeUpdate();
        System.out.println("Deleted rows: " + res2);

        tx.commit();
        s.close();
        sf.close();
    }
}
