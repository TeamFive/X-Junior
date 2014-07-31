package service.Impl;


import DAO.BaseDAO;
import exceptions.EntityException;
import org.springframework.beans.factory.annotation.Autowired;
import service.BaseService;

public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseDAO<T> baseDAO;

    public BaseServiceImpl() {
    }

    public void setBaseDAO(BaseDAO<T> baseDAO) {
        this.baseDAO = baseDAO;
    }

    @Override
    public T find(Long id) throws EntityException {
        return baseDAO.find(id);
    }

    @Override
    public String delete(Long id) throws EntityException {
        return baseDAO.delete(id);
    }

    @Override
    public String add(T t) throws EntityException {
        return baseDAO.add(t);
    }

    @Override
    public String update(T t) {
        return baseDAO.update(t);
    }
}
