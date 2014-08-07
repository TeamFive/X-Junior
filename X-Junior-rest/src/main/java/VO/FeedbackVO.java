package VO;

import entity.Curator;
import entity.Feedback;
import entity.Student;

/**
 * Created by ALEX on 07.08.2014.
 */
public class FeedbackVO implements BaseVO {
    private Long id;
    private int peopleRelation;
    private int workAttitude;
    private boolean increaseHours;
    private String realProject;
    private String extra;
    private String date;
    private int proffSuitab;
    private Curator curator;
    private Student student;

    public FeedbackVO(Feedback feedback) {
        this.id = feedback.getId();
        this.peopleRelation = feedback.getPeopleRelation();
        this.workAttitude = feedback.getWorkAttitude();
        this.increaseHours = feedback.isIncreaseHours();
        this.realProject = feedback.getRealProject();
        this.extra = feedback.getExtra();
        this.date = feedback.getDate();
        this.proffSuitab = feedback.getProffSuitab();
        this.curator = feedback.getCurator();
        this.student = feedback.getStudent();
    }
}
