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
    private CuratorElem curator;
    private StudentElem student;

    private class CuratorElem{
        private Long id;
        private String name;
        private String email;

        private CuratorElem(Curator curatorElem) {
            this.id = curatorElem.getId();
            this.name = curatorElem.getUser().getName();
            this.email = curatorElem.getUser().getEmail();
        }
    }

    private class StudentElem{
        private Long id;
        private String name;
        private String email;

        private StudentElem(Student studentElem) {
            this.id = studentElem.getId();
            this.name = studentElem.getUser().getName();
            this.email = studentElem.getUser().getEmail();
        }
    }

    public FeedbackVO(Feedback feedback) {
        this.id = feedback.getId();
        this.peopleRelation = feedback.getPeopleRelation();
        this.workAttitude = feedback.getWorkAttitude();
        this.increaseHours = feedback.isIncreaseHours();
        this.realProject = feedback.getRealProject();
        this.extra = feedback.getExtra();
        this.date = feedback.getDate();
        this.proffSuitab = feedback.getProffSuitab();
        this.curator = new CuratorElem(feedback.getCurator());
        this.student = new StudentElem(feedback.getStudent());
    }
}
