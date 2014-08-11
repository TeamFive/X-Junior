package DAO.Impl;

import entity.Faculty;
import entity.University;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class FacultyDAOImpl extends BaseDAOImpl<Faculty> {
    public FacultyDAOImpl() {
        super(Faculty.class);
    }

    public FacultyDAOImpl(Class<Faculty> type) {
        super(type);
    }

    public String createFaculty(Faculty faculty, long universityId){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        University university = entityManager.find(University.class, universityId);
        faculty.setUniversity(university);

        entityManager.getTransaction().begin();
        entityManager.merge(faculty);
        entityManager.getTransaction().commit();

        return "success";
    }
}
