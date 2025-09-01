package anitha.AnnotationDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
    public static void main(String[] args) {
        // Load config from inside the package
        SessionFactory factory = new Configuration()
                .configure("anitha/AnnotationDemo/hibernate.cfg.xml")
                .buildSessionFactory();

        Employee e1 = new Employee();
        e1.setEid(1);
        e1.setEname("ABC");
        e1.setEsal(500000);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.persist(e1);

        tx.commit();
        session.close();
        factory.close();

        System.out.println("✅ Employee saved successfully!");
    }
}
