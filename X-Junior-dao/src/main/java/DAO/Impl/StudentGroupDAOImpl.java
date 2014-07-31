package DAO.Impl;

import entity.StudentGroup;
import org.springframework.stereotype.Repository;

@Repository
public class StudentGroupDAOImpl extends BaseDAOImpl<StudentGroup> {
    public StudentGroupDAOImpl() {
        super(StudentGroup.class);
    }

    public StudentGroupDAOImpl(Class<StudentGroup> type) {
        super(type);
    }
}
