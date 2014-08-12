package entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Student")
public class Student extends BaseEntity {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "started_work_date")
    private String startedWorkDate;

    @Column(name = "had_probation")
    private boolean hadProbation;

    @Column(name = "start_at_course")
    private int startAtCourse;

    @Column(name = "wanted_work_hours")
    private int wantedWorkHours;

    @Column(name = "change_hours_date")
    private String changeHoursDate;

    @Column(name = "english_level")
    private String englishLevel;

    @Column(name = "wanted_courses")
    private String wantedCourses;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "skype")
    private String skype;

    @Column(name = "want_english_training")
    private boolean wantEnglishTraining;

    @Column(name = "current_english_training")
    private String currentEnglishTraining;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "User_id")
    private User user;

    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_group",
            joinColumns = {@JoinColumn(name = "Student_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "Group_id", referencedColumnName = "id")})
    private List<Group> groupList;

    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_customfield",
            joinColumns = {@JoinColumn(name = "Student_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "CustomField_id", referencedColumnName = "id")})
    private List<CustomField> customFieldList;

    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "student_certificate",
            joinColumns = {@JoinColumn(name = "Student_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "Certificate_id", referencedColumnName = "id")})
    private List<Certificate> certificateList;

    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "technology_student_now",
            joinColumns = {@JoinColumn(name = "Student_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "Technology_id", referencedColumnName = "id")})
    private List<Technology> technologyStudentNowList;

    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "technology_student_future",
            joinColumns = {@JoinColumn(name = "Student_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "Technology_id", referencedColumnName = "id")})
    private List<Technology> technologyStudentFutureList;

    @Fetch(FetchMode.SELECT)
    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER)
    private List<Interview> interviewList;

    @Fetch(FetchMode.SELECT)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_project",
            joinColumns = {@JoinColumn(name = "Student_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "Project_id", referencedColumnName = "id")})
    private List<Project> projectList;

    @Fetch(FetchMode.SELECT)
    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER)
    private List<Feedback> feedbackList;

    @Fetch(FetchMode.SELECT)
    @OneToMany(mappedBy = "student",fetch = FetchType.EAGER)
    private List<Marks> marksList;

    public Student(User user) {
        this.user = user;
    }

    public Student() {
    }

    public Student(String startedWorkDate, boolean hadProbation, int startAtCourse, int wantedWorkHours, String changeHoursDate, String englishLevel, String wantedCourses, String phoneNumber, String skype, boolean wantEnglishTraining, String currentEnglishTraining, User user, List<Group> groupList, List<CustomField> customFieldList, List<Certificate> certificateList, List<Technology> technologyStudentNowList, List<Technology> technologyStudentFutureList, List<Interview> interviewList, List<Project> projectList, List<Feedback> feedbackList, List<Marks> marksList) {
        this.startedWorkDate = startedWorkDate;
        this.hadProbation = hadProbation;
        this.startAtCourse = startAtCourse;
        this.wantedWorkHours = wantedWorkHours;
        this.changeHoursDate = changeHoursDate;
        this.englishLevel = englishLevel;
        this.wantedCourses = wantedCourses;
        this.phoneNumber = phoneNumber;
        this.skype = skype;
        this.wantEnglishTraining = wantEnglishTraining;
        this.currentEnglishTraining = currentEnglishTraining;
        this.user = user;
        this.groupList = groupList;
        this.customFieldList = customFieldList;
        this.certificateList = certificateList;
        this.technologyStudentNowList = technologyStudentNowList;
        this.technologyStudentFutureList = technologyStudentFutureList;
        this.interviewList = interviewList;
        this.projectList = projectList;
        this.feedbackList = feedbackList;
        this.marksList = marksList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartedWorkDate() {
        return startedWorkDate;
    }

    public void setStartedWorkDate(String startedWorkDate) {
        certificateList = new ArrayList<Certificate>();
        this.startedWorkDate = startedWorkDate;
    }

    public boolean isHadProbation() {
        return hadProbation;
    }

    public void setHadProbation(boolean hadProbation) {
        this.hadProbation = hadProbation;
    }

    public int getStartAtCourse() {
        return startAtCourse;
    }

    public void setStartAtCourse(int startAtCourse) {
        this.startAtCourse = startAtCourse;
    }

    public int getWantedWorkHours() {
        return wantedWorkHours;
    }

    public void setWantedWorkHours(int wantedWorkHours) {
        this.wantedWorkHours = wantedWorkHours;
    }

    public String getChangeHoursDate() {
        return changeHoursDate;
    }

    public void setChangeHoursDate(String changeHoursDate) {
        this.changeHoursDate = changeHoursDate;
    }

    public String getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(String englishLevel) {
        this.englishLevel = englishLevel;
    }

    public String getWantedCourses() {
        return wantedCourses;
    }

    public void setWantedCourses(String wantedCourses) {
        this.wantedCourses = wantedCourses;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public boolean isWantEnglishTraining() {
        return wantEnglishTraining;
    }

    public void setWantEnglishTraining(boolean wantEnglishTraining) {
        this.wantEnglishTraining = wantEnglishTraining;
    }

    public String getCurrentEnglishTraining() {
        return currentEnglishTraining;
    }

    public void setCurrentEnglishTraining(String currentEnglishTraining) {
        this.currentEnglishTraining = currentEnglishTraining;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public List<CustomField> getCustomFieldList() {
        return customFieldList;
    }

    public void setCustomFieldList(List<CustomField> customFieldList) {
        this.customFieldList = customFieldList;
    }

    public List<Certificate> getCertificateList() {
        return certificateList;
    }

    public void setCertificateList(List<Certificate> certificateList) {
        this.certificateList = certificateList;
    }

    public List<Technology> getTechnologyStudentNowList() {
        return technologyStudentNowList;
    }

    public void setTechnologyStudentNowList(List<Technology> technologyStudentNowList) {
        this.technologyStudentNowList = technologyStudentNowList;
    }

    public List<Technology> getTechnologyStudentFutureList() {
        return technologyStudentFutureList;
    }

    public void setTechnologyStudentFutureList(List<Technology> technologyStudentFutureList) {
        this.technologyStudentFutureList = technologyStudentFutureList;
    }

    public List<Interview> getInterviewList() {
        return interviewList;
    }

    public void setInterviewList(List<Interview> interviewList) {
        this.interviewList = interviewList;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public List<Marks> getMarksList() {
        return marksList;
    }

    public void setMarksList(List<Marks> marksList) {
        this.marksList = marksList;
    }
}
