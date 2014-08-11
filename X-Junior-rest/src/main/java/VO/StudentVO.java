package VO;

import entity.*;

import java.util.List;

/**
 * Created by ALEX on 07.08.2014.
 */
public class StudentVO implements BaseVO {
    private Long id;
    private String startedWorkDate;
    private boolean hadProbation;
    private int startAtCourse;
    private int wantedWorkHours;
    private String changeHoursDate;
    private String englishLevel;
    private String wantedCourses;
    private String phoneNumber;
    private String skype;
    private boolean wantEnglishTraining;
    private String currentEnglishTraining;
    private String name;
    private String email;
    private List<StudentGroup> studentGroupList;
    private List<StudentCustomField> studentCustomFieldList;
    private List<StudentCertificate> studentCertificateList;
    private List<TechnologyStudentNow> technologyStudentNowList;
    private List<TechnologyStudentFuture> technologyStudentFutureList;
    private List<Interview> interviewList;
    private List<StudentProject> studentProjectList;
    private List<Feedback> feedbackList;

    public StudentVO(Student student) {
        this.id = student.getId();
        this.startedWorkDate = student.getStartedWorkDate();
        this.hadProbation = student.isHadProbation();
        this.startAtCourse = student.getStartAtCourse();
        this.wantedWorkHours = student.getWantedWorkHours();
        this.changeHoursDate = student.getChangeHoursDate();
        this.englishLevel = student.getEnglishLevel();
        this.wantedCourses = student.getWantedCourses();
        this.phoneNumber = student.getPhoneNumber();
        this.skype = student.getSkype();
        this.wantEnglishTraining = student.isWantEnglishTraining();
        this.currentEnglishTraining = student.getCurrentEnglishTraining();
        this.name = student.getUser().getName();
        this.email = student.getUser().getEmail();
        this.studentGroupList = student.getStudentGroupList();
        this.studentCustomFieldList = student.getStudentCustomFieldList();
        this.studentCertificateList = student.getStudentCertificateList();
        this.technologyStudentNowList = student.getTechnologyStudentNowList();
        this.technologyStudentFutureList = student.getTechnologyStudentFutureList();
        this.interviewList = student.getInterviewList();
        this.studentProjectList = student.getStudentProjectList();
        this.feedbackList = student.getFeedbackList();
    }
}
