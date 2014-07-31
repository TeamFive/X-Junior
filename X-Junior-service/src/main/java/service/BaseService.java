package service;

import exceptions.EntityException;

public interface BaseService <T> {
    public T find(Long id) throws EntityException;
    public String delete(Long id) throws EntityException;
    public String add(T t) throws EntityException;
    public String update(T t);
}
