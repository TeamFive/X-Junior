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
    private List<Interview> interviewList;
    private List<Project> projectList;
    private List<FeedbackListItem> feedbackList;

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
        this.interviewList = student.getInterviewList();
        this.projectList = student.getProjectList();
        this.feedbackList = new ArrayList<FeedbackListItem>();
        for (Feedback item : student.getFeedbackList()){
            this.feedbackList.add(new FeedbackListItem(item));
        }
    }
}
