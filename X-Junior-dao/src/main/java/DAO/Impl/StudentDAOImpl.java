package DAO.Impl;

import entity.Student;
import entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class StudentDAOImpl extends BaseDAOImpl<Student> {
    public StudentDAOImpl() {
        super(Student.class);
    }

    public StudentDAOImpl(Class<Student> type) {
        super(type);
    }

    public Student getStudent(long id){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Student student = entityManager.find(Student.class, id);
        return student;
    }

    public String createStudent(Student student, long userId){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        student.setUser(entityManager.find(User.class, userId));

        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();

        return "success";

    }
}
