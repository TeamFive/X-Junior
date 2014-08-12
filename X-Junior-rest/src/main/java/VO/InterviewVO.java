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
    private StudentElem student;
    private HR hr;
    private Interviewer interviewer;

    public InterviewVO(Interview interview) {
        this.id = interview.getId();
        this.results = interview.getResults();
        this.description = interview.getDescription();
        this.student = new StudentElem(interview.getStudent());
        this.hr = interview.getHr();
        this.interviewer = interview.getInterviewer();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public StudentElem getStudent() {
        return student;
    }

    public void setStudent(StudentElem student) {
        this.student = student;
    }

    public HR getHr() {
        return hr;
    }

    public void setHr(HR hr) {
        this.hr = hr;
    }

    public Interviewer getInterviewer() {
        return interviewer;
    }

    public void setInterviewer(Interviewer interviewer) {
        this.interviewer = interviewer;
    }
}
