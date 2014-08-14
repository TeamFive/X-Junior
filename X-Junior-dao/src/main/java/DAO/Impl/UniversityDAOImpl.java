package DAO.Impl;

import entity.Curator;
import entity.University;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

@Repository
public class UniversityDAOImpl extends BaseDAOImpl<University> {
    public UniversityDAOImpl() {
        super(University.class);
    }

    public UniversityDAOImpl(Class<University> type) {
        super(type);
    }

    public University getUniversityByName(String name){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createNamedQuery("findUniversityByName");
        query.setParameter("name", name);
        University university = (University) query.getSingleResult();


        return university;


    }

    public University createUniversity(University university){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(university);
        entityManager.getTransaction().commit();



        return getUniversityByName(university.getUniversity_name());
    }
}
