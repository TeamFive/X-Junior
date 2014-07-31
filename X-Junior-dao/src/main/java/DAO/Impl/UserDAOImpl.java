package DAO.Impl;

import entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends BaseDAOImpl<User>{
    public UserDAOImpl() {
        super(User.class);
    }

    public UserDAOImpl(Class<User> type) {
        super(type);
    }
}
