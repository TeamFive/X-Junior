package DAO.Impl;

import DAO.BaseDAO;
import exceptions.EntityException;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public T find(Long id) throws JDBCConnectionException, EntityException {
        T t = em.find(type, id);
        if(t == null)
            throw new EntityException("Entity not found");
        return t;
    }

    @Override
    public String delete(Long id) throws JDBCConnectionException, EntityException {
        T t = find(id);
        if(t==null)
            throw new EntityException("Entity not found");
        em.remove(t);
        return "Success";
    }

    @Override
    public String add(T t) throws JDBCConnectionException, EntityException {

        return "Success";
    }

    @Override
    public String update(T t) {
        return "Success";
    }
}
