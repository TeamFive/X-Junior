package DAO.Impl;

import DAO.BaseDAO;
import exceptions.EntityException;
import org.hibernate.exception.JDBCConnectionException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Queue;

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
    @Transactional
    public String add(T t) throws JDBCConnectionException, EntityException {
        em.persist(t);
        return "Success";
    }

    @Override
    @Transactional
    public String update(T t) {
        em.merge(t);
        return "Success";
    }

    @Override
    public List<T> getList() throws EntityException {
        Query query = em.createQuery("from " + type.getName());
        List<T> resultList = query.getResultList();
        if (resultList.size() == 0)
            throw new EntityException("Entities not found");
        return resultList;

    }
}
