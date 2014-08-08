package VO;

import entity.TeamLeader;

/**
 * Created by ALEX on 07.08.2014.
 */
public class TeamLeaderVO implements BaseVO {
    private Long id;
    private String name;
    private String email;

    public TeamLeaderVO(TeamLeader teamLeader) {
        this.id = teamLeader.getId();
        this.name = teamLeader.getUser().getName();
        this.email = teamLeader.getUser().getEmail();
    }
}
