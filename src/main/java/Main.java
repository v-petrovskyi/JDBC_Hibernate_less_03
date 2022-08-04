import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Animal.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Animal animal = new Animal(5,"cat",true);
            Animal animal2 = new Animal(2,"dog",true);
            Animal animal3 = new Animal(1,"lion",false);
            Animal animal4 = new Animal(4,"tiger",true);

            session.beginTransaction();
            session.persist(animal);
            session.persist(animal2);
            session.persist(animal3);
            session.persist(animal4);
            session.getTransaction().commit();
        }finally {
            factory.close();
        }
    }
}
