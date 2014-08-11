package DAO.Impl;

import entity.Group;
import entity.Marks;
import entity.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class MarksDAOImpl extends BaseDAOImpl<Marks> {
    public MarksDAOImpl() {
        super(Marks.class);
    }

    public MarksDAOImpl(Class<Marks> type) {
        super(type);
    }


    public String addMark(long group_id, long student_id, Marks mark){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        Student student = entityManager.find(Student.class, student_id);
        Group group = entityManager.find(Group.class, group_id);
        mark.setStudent(student);
        mark.setGroup(group);
        entityManager.getTransaction().begin();
        entityManager.merge(mark);
        entityManager.getTransaction().commit();

        return "success";
    }

}
