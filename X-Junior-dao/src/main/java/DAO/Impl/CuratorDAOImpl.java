package DAO.Impl;


import entity.Curator;
import entity.Interview;
import entity.Student;
import entity.User;
import exceptions.EntityException;
import org.hibernate.ejb.EntityManagerFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class CuratorDAOImpl extends BaseDAOImpl<Curator> {
    public CuratorDAOImpl() {
        super(Curator.class);
    }

    public CuratorDAOImpl(Class<Curator> type) {
        super(type);
    }



//    @Transactional
//    public Curator getCuratorByName(String name) throws EntityException{
//        Logger logger = LoggerFactory.getLogger(this.getClass());
//        try {
//
//            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
//            EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//            Query query = entityManager.createNamedQuery("findCuratorByName");
//            query.setParameter("name", name);
//            Curator curator = (Curator) query.getSingleResult();
//
//
//            return curator;
//
//        } catch (NoResultException ex){
//            throw new EntityException("Entity not found");
//        } catch (PersistenceException ex){
//            throw new EntityException("Database is offline");
//        }
//    }

//    public Curator getCuratorByUser(User user){
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        Query query = entityManager.createNamedQuery("findAllStudentsByName");
//        query.setParameter("name", name);
//        List<Student> resultList = query.getResultList();
//
//        logger.info("Find " + resultList.getClass());
//        return resultList;
//
//        //Curator curator = query.getSingleResult();
//        return null;
//    }

    public Curator saveCurator(Curator curator) throws EntityException {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        if(curator.getId() != null){
            Curator curator1 = entityManager.find(Curator.class, curator.getId());
            for(int i = 0; i < curator.getStudentList().size(); i++){
                Student student = entityManager.find(Student.class, curator.getStudentList().get(i).getId());
                if(!curator1.getStudentList().contains(student)){
                    curator1.getStudentList().add(student);
                }
            }

            entityManager.getTransaction().begin();
            entityManager.merge(curator1);
            entityManager.getTransaction().commit();

            return  curator1;

        }

        entityManager.getTransaction().begin();
        entityManager.merge(curator);
        entityManager.getTransaction().commit();

        List<Curator> curators = getListByName(curator.getUser().getName());


        //Curator curator1 = getCuratorByName(curator.getUser().getName());

        return  curators.get(0);
    }

    public List<Curator> getListByName(String name){
        Logger logger = LoggerFactory.getLogger(this.getClass());


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("select c from Curator c where c.user.name = :name");
        query.setParameter("name", name);
        List<Curator> resultList = query.getResultList();

        logger.info("Find " + resultList.getClass());
        return resultList;
    }

}

