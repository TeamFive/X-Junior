package DAO.Impl;

import entity.Technology;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class TechnologyDAOImpl extends BaseDAOImpl<Technology> {
    public TechnologyDAOImpl() {
        super(Technology.class);
    }

    public TechnologyDAOImpl(Class<Technology> type) {
        super(type);
    }

    public String createTechnology(Technology technology){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(technology);
        entityManager.getTransaction().commit();

        return "success";
    }
}
