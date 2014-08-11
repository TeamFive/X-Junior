package DAO.Impl;

import entity.PM;
import entity.Project;
import entity.TeamLeader;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class ProjectDAOImpl extends BaseDAOImpl<Project> {
    public ProjectDAOImpl() {
        super(Project.class);
    }

    public ProjectDAOImpl(Class<Project> type) {
        super(type);
    }

    public String createProject(Project project, long pmId, long teamleaderId){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        project.setPm(entityManager.find(PM.class, pmId));
        project.setTeamLeader(entityManager.find(TeamLeader.class, teamleaderId));

        entityManager.getTransaction().begin();
        entityManager.merge(project);
        entityManager.getTransaction().commit();

        return "success";
    }
}
