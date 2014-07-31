package DAO.Impl;

import entity.StudentCurator;
import org.springframework.stereotype.Repository;

@Repository
public class StudentCuratorDAOImpl extends BaseDAOImpl<StudentCurator> {
    public StudentCuratorDAOImpl() {
        super(StudentCurator.class);
    }

    public StudentCuratorDAOImpl(Class<StudentCurator> type) {
        super(type);
    }
}
