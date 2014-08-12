package VO;

import entity.*;

import java.util.ArrayList;
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
    private List<Group> groupList;
    private List<CustomField> customFieldList;
    private List<Certificate> certificateList;
    private List<Technology> technologyStudentNowList;
    private List<Technology> technologyStudentFutureList;
    private List<InterviewListItem> interviewList;
    private List<ProjectVO> projectList;
    private List<FeedbackListItem> feedbackList;
    private List<MarksListItem> marksList;

    private class FeedbackListItem{
        private Long id;
        private int peopleRelation;
        private int workAttitude;
        private boolean increaseHours;
        private String realProject;
        private String extra;
        private String date;
        private int proffSuitab;
        private CuratorElem curator;

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

        public FeedbackListItem(Feedback feedback) {
            this.id = feedback.getId();
            this.peopleRelation = feedback.getPeopleRelation();
            this.workAttitude = feedback.getWorkAttitude();
            this.increaseHours = feedback.isIncreaseHours();
            this.realProject = feedback.getRealProject();
            this.extra = feedback.getExtra();
            this.date = feedback.getDate();
            this.proffSuitab = feedback.getProffSuitab();
            this.curator = new CuratorElem(feedback.getCurator());
        }
    }

    private class InterviewListItem{
        private Long id;
        private String results;
        private String description;
        private HRVO hr;
        private InterviewerVO interviewer;

        public InterviewListItem(Interview interview) {
            this.id = interview.getId();
            this.results = interview.getResults();
            this.description = interview.getDescription();
            this.hr = new HRVO(interview.getHr());
            this.interviewer = new InterviewerVO(interview.getInterviewer());
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

        public HRVO getHr() {
            return hr;
        }

        public void setHr(HRVO hr) {
            this.hr = hr;
        }

        public InterviewerVO getInterviewer() {
            return interviewer;
        }

        public void setInterviewer(InterviewerVO interviewer) {
            this.interviewer = interviewer;
        }
    }

    private class MarksListItem{
        private Long id;
        private String mark;
        private String date;

        public MarksListItem(Marks marks) {
            this.id = marks.getId();
            this.mark = marks.getMark();
            this.date = marks.getDate();
        }
    }

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
        this.groupList = student.getGroupList();
        this.customFieldList = student.getCustomFieldList();
        this.certificateList = student.getCertificateList();
        this.technologyStudentNowList = student.getTechnologyStudentNowList();
        this.technologyStudentFutureList = student.getTechnologyStudentFutureList();
        this.interviewList = new ArrayList<InterviewListItem>();
        for (Interview item : student.getInterviewList()){
            this.interviewList.add(new InterviewListItem(item));
        }
        this.projectList = new ArrayList<ProjectVO>();
        for (Project item : student.getProjectList()){
            this.projectList.add(new ProjectVO(item));
        }
        this.feedbackList = new ArrayList<FeedbackListItem>();
        for (Feedback item : student.getFeedbackList()){
            this.feedbackList.add(new FeedbackListItem(item));
        }
        this.marksList = new ArrayList<MarksListItem>();
        for (Marks item : student.getMarksList()){
            this.marksList.add(new MarksListItem(item));
        }
    }
}
