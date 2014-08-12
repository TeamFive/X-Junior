package VO;

import entity.PM;
import entity.Project;
import entity.TeamLeader;

/**
 * Created by ALEX on 07.08.2014.
 */
public class ProjectVO implements BaseVO {
    private Long id;
    private String name;
    private PMVO pm;
    private TeamLeaderVO teamLeader;

    public ProjectVO(Project project) {
        this.id = project.getId();
        this.name = project.getName();
        this.pm = new PMVO(project.getPm());
        this.teamLeader = new TeamLeaderVO(project.getTeamLeader());
    }
}
