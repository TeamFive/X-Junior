package DAO.Impl;

import entity.Faculty;
import org.springframework.stereotype.Repository;

@Repository
public class FacultyDAOImpl extends BaseDAOImpl<Faculty> {
    public FacultyDAOImpl() {
        super(Faculty.class);
    }

    public FacultyDAOImpl(Class<Faculty> type) {
        super(type);
    }
}
