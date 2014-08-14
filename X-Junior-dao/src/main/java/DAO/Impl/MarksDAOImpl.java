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


    public Marks addMark(long group_id, long student_id, Marks mark){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        Student student = entityManager.find(Student.class, student_id);
        Group group = entityManager.find(Group.class, group_id);
        mark.setStudent(student);
        mark.setGroup(group);
        entityManager.getTransaction().begin();
        entityManager.merge(mark);
        entityManager.getTransaction().commit();



        return mark;
    }

    public Marks updateMark(Marks mark){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Marks mark1 = entityManager.find(Marks.class, mark.getId());

        if(!mark.getDate().equals(mark1.getDate())){
            mark1.setDate(mark.getDate());
        }

        if(!mark.getMark().equals(mark1.getMark())){
            mark1.setMark(mark.getMark());
        }

        if(!mark.getStudent().getId().equals(mark1.getStudent().getId())){
            mark1.setStudent(mark.getStudent());
        }

        if(!mark.getGroup().getId().equals(mark1.getGroup().getId())){
            mark1.setGroup(mark.getGroup());
        }

        entityManager.getTransaction().begin();
        entityManager.merge(mark);
        entityManager.getTransaction().commit();

        return mark1;


    }

}
