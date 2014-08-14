package DAO.Impl;

import entity.CustomField;
import entity.FieldsGroup;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomFieldDAOImpl extends BaseDAOImpl<CustomField> {
    public CustomFieldDAOImpl() {
        super(CustomField.class);
    }

    public CustomFieldDAOImpl(Class<CustomField> type) {
        super(type);
    }

    public CustomField createCustomField(CustomField customField){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        long fieldsGroupId = 1;

        FieldsGroup fieldsGroup = entityManager.find(FieldsGroup.class, fieldsGroupId);
        customField.setFieldsGroup(fieldsGroup);

        entityManager.getTransaction().begin();
        entityManager.merge(customField);
        entityManager.getTransaction().commit();

        Query query = entityManager.createQuery("from " + CustomField.class.getName());
        List<CustomField> resultList = query.getResultList();

        CustomField resultField = new CustomField();

        for(int i = 0; i < resultList.size(); i++){
            if(resultList.get(i).getName().equals(customField.getName()))
                resultField = resultList.get(i);
        }

        return resultField;
    }
}
