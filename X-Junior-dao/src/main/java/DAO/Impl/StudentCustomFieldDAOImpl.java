package DAO.Impl;

import entity.StudentCustomField;
import org.springframework.stereotype.Repository;

@Repository
public class StudentCustomFieldDAOImpl extends BaseDAOImpl<StudentCustomField> {
    public StudentCustomFieldDAOImpl() {
        super(StudentCustomField.class);
    }

    public StudentCustomFieldDAOImpl(Class<StudentCustomField> type) {
        super(type);
    }
}
