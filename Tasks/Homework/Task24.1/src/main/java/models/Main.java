package models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Query<User> userQuery = session.createQuery("from User user where user.id = 2");

        User user = userQuery.getSingleResult();

        System.out.println(user);

        Query<User> usersQuery = session.createQuery("from User");
        List<User> users = usersQuery.getResultList();
        System.out.println(users);
        session.close();

        session = sessionFactory.openSession();
        session.beginTransaction();
        User newUser = User.builder()
                .name("Дмитрий")
                .height(170)
                .age(76)
                .build();

        session.persist(newUser);
        session.getTransaction().commit();
        session.close();

        session = sessionFactory.openSession();

        session.beginTransaction();
        newUser.setName("Алексей");
        session.merge(newUser);
        session.persist(newUser);
        session.getTransaction().commit();
        session.close();
    }
}
