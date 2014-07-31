package DAO.Impl;

import entity.CustomField;
import org.springframework.stereotype.Repository;

@Repository
public class CustomFieldDAOImpl extends BaseDAOImpl<CustomField> {
    public CustomFieldDAOImpl() {
        super(CustomField.class);
    }

    public CustomFieldDAOImpl(Class<CustomField> type) {
        super(type);
    }
}
