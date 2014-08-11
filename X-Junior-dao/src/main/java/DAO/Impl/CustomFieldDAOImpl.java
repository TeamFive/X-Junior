package DAO.Impl;

import entity.CustomField;
import entity.FieldsGroup;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class CustomFieldDAOImpl extends BaseDAOImpl<CustomField> {
    public CustomFieldDAOImpl() {
        super(CustomField.class);
    }

    public CustomFieldDAOImpl(Class<CustomField> type) {
        super(type);
    }

    public String createCustomField(CustomField customField, long fieldsGroupId){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        FieldsGroup fieldsGroup = entityManager.find(FieldsGroup.class, fieldsGroupId);
        customField.setFieldsGroup(fieldsGroup);

        entityManager.getTransaction().begin();
        entityManager.merge(customField);
        entityManager.getTransaction().commit();

        return "success";
    }
}
