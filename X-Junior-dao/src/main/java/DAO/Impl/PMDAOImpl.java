package DAO.Impl;

import entity.PM;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class PMDAOImpl extends BaseDAOImpl<PM> {
    public PMDAOImpl() {
        super(PM.class);
    }

    public PMDAOImpl(Class<PM> type) {
        super(type);
    }

    public String createPM(PM pm){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(pm);
        entityManager.getTransaction().commit();

        return "success";
    }
}
