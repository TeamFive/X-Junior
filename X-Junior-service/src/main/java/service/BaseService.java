package service;

import exceptions.EntityException;

import javax.persistence.EntityManager;
import java.util.List;

public interface BaseService <T> {
    public T find(Long id) throws EntityException;
    public String delete(Long id) throws EntityException;
    public String add(T t) throws EntityException;
    public String update(T t);
    public List<T> getList() throws EntityException;
}
