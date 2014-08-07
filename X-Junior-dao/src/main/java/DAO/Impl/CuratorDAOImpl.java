package DAO.Impl;


import entity.Curator;
import entity.Student;
import entity.User;
import exceptions.EntityException;
import org.hibernate.ejb.EntityManagerFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
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



    @Transactional
    public Curator getCuratorByName(String name) throws EntityException{
        Logger logger = LoggerFactory.getLogger(this.getClass());
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
            Root<User> root = criteriaQuery.from(User.class);
            criteriaQuery.select(root);

            ParameterExpression<String> parameterExpression = criteriaBuilder.parameter(String.class);
            criteriaQuery.where(criteriaBuilder.equal(root.get("name"), parameterExpression));

            TypedQuery<User> query = entityManager.createQuery(criteriaQuery);
            query.setParameter(parameterExpression, name);



            User user = query.getSingleResult();

            return new Curator(user);
        } catch (NoResultException ex){
            throw new EntityException("Entity not found");
        } catch (PersistenceException ex){
            throw new EntityException("Database is offline");
        }

    }

}

