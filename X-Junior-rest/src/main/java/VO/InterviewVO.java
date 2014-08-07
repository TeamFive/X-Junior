package VO;

import entity.HR;
import entity.Interview;
import entity.Interviewer;
import entity.Student;

/**
 * Created by ALEX on 07.08.2014.
 */
public class InterviewVO implements BaseVO {
    private Long id;
    private String results;
    private String description;
    private Student student;
    private HR hr;
    private Interviewer interviewer;

    public InterviewVO(Interview interview) {
        this.id = interview.getId();
        this.results = interview.getResults();
        this.description = interview.getDescription();
        this.student = interview.getStudent();
        this.hr = interview.getHr();
        this.interviewer = interview.getInterviewer();
    }
}
