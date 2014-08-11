package DAO.Impl;

import entity.Interview;
import entity.Interviewer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class InterviewerDAOImpl extends BaseDAOImpl<Interviewer> {
    public InterviewerDAOImpl() {
        super(Interviewer.class);
    }

    public InterviewerDAOImpl(Class<Interviewer> type) {
        super(type);
    }

    public String createInterviewer(Interviewer interviewer){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(interviewer);
        entityManager.getTransaction().commit();

        return "success";
    }
}
