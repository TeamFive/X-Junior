package DAO;

import exceptions.EntityException;

public interface BaseDAO <T> {
    public T find(Long id) throws EntityException;
    public String delete(Long id) throws EntityException;
    public String add(T t) throws EntityException;
    public String update(T t) throws EntityException;
    public java.util.List<T> getList() throws EntityException;
}
