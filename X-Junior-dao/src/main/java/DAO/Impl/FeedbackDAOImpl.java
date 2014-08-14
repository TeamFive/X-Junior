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

    public Feedback updateFeedback(Feedback feedback){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Feedback feedback1 = entityManager.find(Feedback.class, feedback.getId());

        if( feedback.getStudent()!= null){
            if(feedback.getStudent().getId() != feedback1.getStudent().getId()){
                Student student = entityManager.find(Student.class, feedback.getStudent().getId());
                feedback1.setStudent(student);
            }
        }

        if (feedback.getDate() != null){
            if(!feedback.getDate().equals(feedback1.getDate())){
                feedback1.setDate(feedback.getDate());
            }
        }

        if(feedback.getCurator() != null){
            if(feedback.getCurator().getId() != feedback1.getCurator().getId()){
                Curator curator = entityManager.find(Curator.class, feedback.getCurator().getId());
                feedback1.setCurator(curator);
            }
        }

        if(feedback.getExtra() != null){
            if(!feedback.getExtra().equals(feedback1.getExtra())){
                feedback1.setExtra(feedback.getExtra());
            }
        }


        if(feedback.getPeopleRelation() != feedback1.getPeopleRelation()){
            feedback1.setPeopleRelation(feedback.getPeopleRelation());
        }

        if(feedback.getProffSuitab() != feedback1.getProffSuitab()){
            feedback1.setProffSuitab(feedback.getProffSuitab());
        }

        if(feedback.getRealProject() != null){
            if(!feedback.getRealProject().equals(feedback1.getRealProject())){
                feedback1.setRealProject(feedback.getRealProject());
            }
        }



        if(feedback.getWorkAttitude() != feedback1.getWorkAttitude()){
            feedback1.setWorkAttitude(feedback.getWorkAttitude());
        }

        entityManager.getTransaction().begin();
        entityManager.merge(feedback1);
        entityManager.getTransaction().commit();

        return feedback1;

    }
}
