package DAO.Impl;

import entity.Project;
import org.springframework.stereotype.Repository;

@Repository
public class ProjectDAOImpl extends BaseDAOImpl<Project> {
    public ProjectDAOImpl() {
        super(Project.class);
    }

    public ProjectDAOImpl(Class<Project> type) {
        super(type);
    }
}
