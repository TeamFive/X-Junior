package DAO.Impl;

import entity.HR;
import entity.Interview;
import entity.Interviewer;
import entity.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class InterviewDAOImpl extends BaseDAOImpl<Interview> {
    public InterviewDAOImpl() {
        super(Interview.class);
    }

    public InterviewDAOImpl(Class<Interview> type) {
        super(type);
    }

    public String createInterview(Interview interview,
                                  long studentId,
                                  long hrId, long interviewerId){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        interview.setHr(entityManager.find(HR.class, hrId));
        interview.setInterviewer(entityManager.find(Interviewer.class, interviewerId));
        interview.setStudent(entityManager.find(Student.class, studentId));

        entityManager.getTransaction().begin();
        entityManager.merge(interview);
        entityManager.getTransaction().commit();

        return "success";
    }
}
