package DAO.Impl;

import entity.Setting;
import entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class SettingsDAOImpl extends BaseDAOImpl<Setting> {
    public SettingsDAOImpl() {
        super(Setting.class);
    }

    public SettingsDAOImpl(Class<Setting> type) {
        super(type);
    }

    public String createSetting(Setting setting, long userId){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        setting.setUser(entityManager.find(User.class, userId));

        entityManager.getTransaction().begin();
        entityManager.persist(setting);
        entityManager.getTransaction().commit();

        return "success";
    }
}
