package VO;

import entity.Interviewer;
import entity.User;

/**
 * Created by ALEX on 07.08.2014.
 */
public class InterviewerVO implements BaseVO {
    private Long id;
    private String name;
    private String email;

    public InterviewerVO(Interviewer interviewer) {
        this.id = interviewer.getId();
        this.name = interviewer.getUser().getName();
        this.email = interviewer.getUser().getEmail();
    }
}
