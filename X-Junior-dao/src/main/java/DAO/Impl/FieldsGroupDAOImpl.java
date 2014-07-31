package DAO.Impl;

import entity.FieldsGroup;
import org.springframework.stereotype.Repository;

@Repository
public class FieldsGroupDAOImpl extends BaseDAOImpl<FieldsGroup> {
    public FieldsGroupDAOImpl() {
        super(FieldsGroup.class);
    }

    public FieldsGroupDAOImpl(Class<FieldsGroup> type) {
        super(type);
    }
}
