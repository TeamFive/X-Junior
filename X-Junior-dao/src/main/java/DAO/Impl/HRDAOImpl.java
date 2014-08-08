package DAO.Impl;

import entity.Curator;
import entity.HR;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class HRDAOImpl extends BaseDAOImpl<HR> {
    public HRDAOImpl() {
        super(HR.class);
    }

    public HRDAOImpl(Class<HR> type) {
        super(type);
    }

    public String saveHr(HR hr){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(hr);
        entityManager.getTransaction().commit();

        return  "success";
    }
}
