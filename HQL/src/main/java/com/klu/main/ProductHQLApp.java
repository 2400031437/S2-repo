package com.klu.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.klu.entity.Product;

public class ProductHQLApp {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();

        // ===== SORT BY PRICE ASC =====
        String hql1 = "From Product order by price ASC";
        Query<Product> q1 = s.createQuery(hql1, Product.class);
        List<Product> list1 = q1.getResultList();
        list1.forEach(p -> System.out.println(p));

        // ===== SORT BY PRICE DESC =====
        String hql2 = "From Product order by price DESC";
        Query<Product> q2 = s.createQuery(hql2, Product.class);
        q2.getResultList().forEach(p -> System.out.println(p));

        // ===== SORT BY QUANTITY DESC =====
        String hql3 = "From Product order by quantity DESC";
        Query<Product> q3 = s.createQuery(hql3, Product.class);
        q3.getResultList().forEach(p -> System.out.println(p));

        // ===== PAGINATION =====
        String hql4 = "From Product";
        Query<Product> q4 = s.createQuery(hql4, Product.class);
        q4.setFirstResult(0);
        q4.setMaxResults(3);
        q4.getResultList().forEach(p -> System.out.println(p));

        q4.setFirstResult(3);
        q4.setMaxResults(3);
        q4.getResultList().forEach(p -> System.out.println(p));

        // ===== AGGREGATES =====
        String count = "Select count(*) from Product";
        String min = "Select min(price) from Product";
        String max = "Select max(price) from Product";

        Long total = s.createQuery(count, Long.class).getSingleResult();
        System.out.println("Total Products: " + total);

        Double minPrice = s.createQuery(min, Double.class).getSingleResult();
        Double maxPrice = s.createQuery(max, Double.class).getSingleResult();
        System.out.println("Min Price: " + minPrice);
        System.out.println("Max Price: " + maxPrice);

        // ===== GROUP BY DESCRIPTION =====
        String grp = "Select description, count(*) from Product group by description";
        List<Object[]> grpList = s.createQuery(grp).getResultList();

        for (Object[] obj : grpList) {
            System.out.println(obj[0] + " : " + obj[1]);
        }

        // ===== WHERE PRICE RANGE =====
        String range = "From Product where price between :min and :max";
        Query<Product> q5 = s.createQuery(range, Product.class);
        q5.setParameter("min", 2000);
        q5.setParameter("max", 20000);
        q5.getResultList().forEach(p -> System.out.println(p));

        // ===== LIKE OPERATIONS =====
        s.createQuery("From Product where name like 'L%'", Product.class)
         .getResultList().forEach(p -> System.out.println(p));

        s.createQuery("From Product where name like '%r'", Product.class)
         .getResultList().forEach(p -> System.out.println(p));

        s.createQuery("From Product where name like '%USB%'", Product.class)
         .getResultList().forEach(p -> System.out.println(p));

        s.createQuery("From Product where length(name)=6", Product.class)
         .getResultList().forEach(p -> System.out.println(p));

        s.close();
        sf.close();
    }
}
