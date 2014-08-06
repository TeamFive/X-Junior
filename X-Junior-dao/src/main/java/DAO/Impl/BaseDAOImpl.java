package DAO.Impl;

import DAO.BaseDAO;
import entity.Admin;
import entity.User;
import exceptions.EntityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Repository
public class BaseDAOImpl<T> implements BaseDAO<T> {

    @PersistenceContext
    EntityManager em;

    private Class<T> type;

    public BaseDAOImpl() {
    }

    public BaseDAOImpl(Class<T> type)  {
        this.type = type;
    }

    public Class<T> getMyType() {
        return this.type;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @Override
    public T find(Long id) throws EntityException {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        try{
            T t = em.find(type, id);
            if(t == null){
                logger.error("Entity not found");
                throw new EntityException("Entity not found");
            }
            logger.info("Find " + t.getClass());
            return t;
        } catch (PersistenceException ex){
            logger.error(ex.getMessage());
            throw new EntityException("Database is offline");
        }

    }

    @Override
    @Transactional
    public String delete(Long id) throws EntityException {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        try {
            T t = find(id);
            if(t==null){
                logger.error("Entity not found");
                throw new EntityException("Entity not found");
            }
            em.remove(em.contains(t) ? t : em.merge(t));
            logger.info("Removed " + t.getClass());
            return "success";
        } catch (PersistenceException ex){
            logger.error(ex.getMessage());
            throw new EntityException("Database is offline");
        }

    }

    @Override
    @Transactional
    public String add(T t) throws EntityException{
        Logger logger = LoggerFactory.getLogger(this.getClass());
        try {
            em.persist(t);
            logger.info("Added " + t.getClass());
            return "success";
        } catch (ConstraintViolationException ex){
            throw new EntityException("Duplicate entity");
        } catch (PersistenceException ex){
            logger.error(ex.getMessage());
            throw new EntityException("Database is offline");
        }
    }

    @Override
    @Transactional
    public String update(T t) throws EntityException{
        Logger logger = LoggerFactory.getLogger(this.getClass());
        try {
            em.merge(t);
            logger.info("Updated " + t.getClass());
            return "success";
        } catch (PersistenceException ex) {
            logger.error(ex.getMessage());
            throw new EntityException("Database is offline");
        }
    }

    @Override
    public List<T> getList() throws EntityException {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        try {
            Query query = em.createQuery("from " + type.getName());
            List<T> resultList = query.getResultList();
            if (resultList.size() == 0){
                throw new EntityException("Entities not found");
            }
            logger.info("Find " + resultList.getClass());
            return resultList;
        } catch (PersistenceException ex){
            logger.error(ex.getMessage());
            throw new EntityException("Database is offline");
        }


    }
}
