package DAO.Impl;

import entity.TeamLeader;
import entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class TeamLeaderDAOImpl extends BaseDAOImpl<TeamLeader> {
    public TeamLeaderDAOImpl() {
        super(TeamLeader.class);
    }

    public TeamLeaderDAOImpl(Class<TeamLeader> type) {
        super(type);
    }

    public String createTeamLeader(TeamLeader teamLeader, long userId){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        teamLeader.setUser(entityManager.find(User.class, userId));

        entityManager.getTransaction().begin();
        entityManager.merge(teamLeader);
        entityManager.getTransaction().commit();

        return "success";
    }
}
