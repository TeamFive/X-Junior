package DAO.Impl;

import entity.TeamLeader;
import org.springframework.stereotype.Repository;

@Repository
public class TeamLeaderDAOImpl extends BaseDAOImpl<TeamLeader> {
    public TeamLeaderDAOImpl() {
        super(TeamLeader.class);
    }

    public TeamLeaderDAOImpl(Class<TeamLeader> type) {
        super(type);
    }
}
