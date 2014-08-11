package DAO.Impl;

import entity.Curator;
import entity.Feedback;
import entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class FeedbackDAOImpl extends BaseDAOImpl<Feedback> {
    public FeedbackDAOImpl() {
        super(Feedback.class);
    }

    public FeedbackDAOImpl(Class<Feedback> type) {
        super(type);
    }

    public String createFeedback(Feedback feedback, long curator_id, long student_id){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Curator curator = entityManager.find(Curator.class, curator_id);
        Student student = entityManager.find(Student.class, student_id);

        feedback.setCurator(curator);
        feedback.setStudent(student);

        entityManager.getTransaction().begin();
        entityManager.merge(feedback);
        entityManager.getTransaction().commit();

        return "success";
    }
}
