package DAO.Impl;

import entity.Curator;
import entity.Group;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class GroupDAOImpl extends BaseDAOImpl<Group> {
    public GroupDAOImpl() {
        super(Group.class);
    }

    public GroupDAOImpl(Class<Group> type) {
        super(type);
    }

    public Group getGroup(long id){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Group group = entityManager.find(Group.class, id);
        return  group;
    }
}
