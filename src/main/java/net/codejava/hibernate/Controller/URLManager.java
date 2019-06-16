package net.codejava.hibernate.Controller;

import net.codejava.hibernate.model.URL;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class URLManager {
    protected SessionFactory sessionFactory;

    protected void setup() {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception ex) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    protected void exit() {
        sessionFactory.close();
    }

    protected void create() {
        URL url = new URL();
        url.setUrl("http://www.amazon.com");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(url);
        session.getTransaction().commit();
        session.close();
    }

    public static void main(String[] args) {
        // code to run the program
        URLManager manager = new URLManager();
        manager.setup();
        manager.create();
        manager.exit();
    }
}
