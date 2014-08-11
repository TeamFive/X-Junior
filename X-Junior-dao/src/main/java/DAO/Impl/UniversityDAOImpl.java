package DAO.Impl;

import entity.University;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class UniversityDAOImpl extends BaseDAOImpl<University> {
    public UniversityDAOImpl() {
        super(University.class);
    }

    public UniversityDAOImpl(Class<University> type) {
        super(type);
    }

    public String createUniversity(University university){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(university);
        entityManager.getTransaction().commit();

        return "success";
    }
}
