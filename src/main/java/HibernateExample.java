import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import system.entity.Exam;
import system.entity.Student;

import java.util.List;
import java.util.Set;

public class HibernateExample {

    public static void main(String[] args) {

        // Открытие сессии (сессионФактори->сессион->транзактоин)
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();

        // Вставка нового студента
//        Transaction transaction = session.beginTransaction();
//
//        Student student = new Student("Ivan", "Petrov", 22);
//
//        session.save(student);
//
//        transaction.commit();

       // Transaction transaction = session.beginTransaction();

        // Чтение из базы данных (Читаем из сесси Наш класс Entity и id студента)
       // Student student = session.load(Student.class, 1);
      //  Set<Exam> exams = student.getExams();
      //  System.out.println("");
//        System.out.println(student.toString());

       // Обновление данных
       // student.setAge(45);

       //transaction.commit();

        // Используя HQL
        Query query = session.createQuery("from Student");
        List<Student> students = query.getResultList();

        session.close();
        sessionFactory.close();
    }

}
