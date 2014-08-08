package DAO.Impl;

import entity.Admin;
import org.hibernate.ejb.EntityManagerFactoryImpl;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class AdminDAOImpl extends BaseDAOImpl<Admin> {
    public AdminDAOImpl() {
        super(Admin.class);
    }

    public AdminDAOImpl(Class<Admin> type) {
        super(type);
    }

    public String createAdmin(Admin admin){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(admin);
        entityManager.getTransaction().commit();

        return "success";
    }
}
