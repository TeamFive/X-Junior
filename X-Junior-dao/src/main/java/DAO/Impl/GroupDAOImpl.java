package DAO.Impl;

import entity.Group;
import org.springframework.stereotype.Repository;

@Repository
public class GroupDAOImpl extends BaseDAOImpl<Group> {
    public GroupDAOImpl() {
        super(Group.class);
    }

    public GroupDAOImpl(Class<Group> type) {
        super(type);
    }
}
