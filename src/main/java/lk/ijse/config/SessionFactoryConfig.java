package lk.ijse.config;

import lk.ijse.entity.Admin;
import lk.ijse.entity.Books;
import lk.ijse.entity.Branch;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryConfig {
    public static SessionFactoryConfig sessionFactoryConfig;
    private final SessionFactory sessionFactory;

    private SessionFactoryConfig() {
        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(serviceRegistry)
                .addAnnotatedClass(Admin.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Books.class)
                .addAnnotatedClass(Branch.class)
                .getMetadataBuilder()
                .build();
        this.sessionFactory = metadata.buildSessionFactory();

    }

    public static SessionFactoryConfig getInstance() {
        return (sessionFactoryConfig == null) ? sessionFactoryConfig = new SessionFactoryConfig() : sessionFactoryConfig;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }
}
