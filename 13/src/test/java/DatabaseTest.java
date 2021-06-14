
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import pl.edu.pjatk.Database;
import pl.edu.pjatk.Student;

@TestMethodOrder(OrderAnnotation.class)
public class DatabaseTest
{

    private static SessionFactory sessionFactory;
    private Session session;

    @BeforeAll
    public static void setup()
    {
        sessionFactory = Database.getSessionFactory();
        System.out.println("SessionFactory created");
    }

    @AfterAll
    public static void tearDown()
    {
        if (sessionFactory != null) sessionFactory.close();
        System.out.println("SessionFactory destroyed");
    }

    @BeforeEach
    public void openSession()
    {
        session = sessionFactory.openSession();
        System.out.println("Session created");
    }

    @AfterEach
    public void closeSession()
    {
        if (session != null) session.close();
        System.out.println("Session closed\n");
    }

    @Test
    @Order(1)
    public void testCreate()
    {
        session.beginTransaction();

        Student student = new Student("Jarek", "Jaro");
        Integer id = (Integer) session.save(student);

        session.getTransaction().commit();

        Assertions.assertTrue(id > 0);
    }

    @Test
    @Order(2)
    public void testRead()
    {
        Student student = session.find(Student.class, 1);

        assertEquals("Jarek", student.getName());
    }


    @Test
    @Order(3)
    public void testUpdate()
    {
        Student student = new Student(1,"updated", "test");

        session.beginTransaction();
        session.update(student);
        session.getTransaction().commit();

        Student updatedStudent = session.find(Student.class, 1);

        assertEquals("updated", updatedStudent.getName());
    }

    @Test
    @Order(4)
    public void testDelete()
    {
        Student student = session.find(Student.class, 1);

        session.beginTransaction();
        session.delete(student);
        session.getTransaction().commit();

        Student deletedStudent = session.find(Student.class, 1);

        Assertions.assertNull(deletedStudent);
    }
}
