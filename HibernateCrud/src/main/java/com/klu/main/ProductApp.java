package com.klu.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.klu.entity.Product;

public class ProductApp {

	public static void main(String[] args) {

		// retrieving configuration object
		Configuration conf = new Configuration().configure();

		// retrieving SessionFactory object
		SessionFactory sf = conf.buildSessionFactory();
		
		  //================= INSERT DATA =================
			/*
			 * Session s = sf.openSession(); Transaction tx = s.beginTransaction();
			 * 
			 * Product p1 = new Product(); p1.setName("Laptop");
			 * p1.setDescription("Gaming Laptop"); p1.setPrice(75000); p1.setQuantity(10);
			 * 
			 * Product p2 = new Product(); p2.setName("Mouse");
			 * p2.setDescription("Wireless Mouse"); p2.setPrice(1500); p2.setQuantity(50);
			 * 
			 * Product p3 = new Product(); p3.setName("Keyboard");
			 * p3.setDescription("Mechanical Keyboard"); p3.setPrice(3000);
			 * p3.setQuantity(25);
			 * 
			 * Product p4 = new Product(); p4.setName("Monitor");
			 * p4.setDescription("24 inch LED Monitor"); p4.setPrice(12000);
			 * p4.setQuantity(15);
			 * 
			 * Product p5 = new Product(); p5.setName("Printer");
			 * p5.setDescription("Laser Printer"); p5.setPrice(18000); p5.setQuantity(5);
			 * 
			 * Product p6 = new Product(); p6.setName("Headphones");
			 * p6.setDescription("Noise Cancelling Headphones"); p6.setPrice(5000);
			 * p6.setQuantity(20);
			 * 
			 * Product p7 = new Product(); p7.setName("Webcam");
			 * p7.setDescription("HD Webcam"); p7.setPrice(2500); p7.setQuantity(18);
			 * 
			 * Product p8 = new Product(); p8.setName("Router");
			 * p8.setDescription("WiFi Router"); p8.setPrice(3500); p8.setQuantity(12);
			 * 
			 * Product p9 = new Product(); p9.setName("Power Bank");
			 * p9.setDescription("10000mAh Power Bank"); p9.setPrice(2000);
			 * p9.setQuantity(30);
			 * 
			 * Product p10 = new Product(); p10.setName("USB Drive");
			 * p10.setDescription("64GB USB Drive"); p10.setPrice(800); p10.setQuantity(40);
			 * 
			 * s.persist(p1); s.persist(p2); s.persist(p3); s.persist(p4); s.persist(p5);
			 * s.persist(p6); s.persist(p7); s.persist(p8); s.persist(p9); s.persist(p10);
			 * 
			 * tx.commit(); s.close();
			 * 
			 * System.out.println("Inserted 10 products successfully");
			 */

		
		  //================= READ DATA =================
			
			/*
			 * Session s = sf.openSession();
			 * 
			 * // READ DATA List<Product> products =s.createQuery("from Product",
			 * Product.class).list();
			 * 
			 * for (Product p : products) { System.out.println(p); }
			 * 
			 * s.close(); 
			 */

			 
		
			
			  //================= UPDATE DATA =================
			  
				/*
				 * Session s = sf.openSession(); Product p = s.get(Product.class, 1);
				 * p.setPrice(72000); p.setQuantity(8);
				 * 
				 * Transaction tx = s.beginTransaction(); s.merge(p); // UPDATE tx.commit();
				 * System.out.println("Updated Product: " + p); s.close();
				 */
			 
		 

			
			  // ============== DELETE DATA =================
		Session s = sf.openSession();

		// retrieve product using primary key
		Product p = s.get(Product.class, 1);

		Transaction tx = s.beginTransaction();

		s.remove(p);        // DELETE operation
		tx.commit();        // commit transaction

		System.out.println("Deleted Product with ID: " + p.getId());

		s.close();
		

			 
			 

		 

		// closing SessionFactory
		sf.close();
	}
}
