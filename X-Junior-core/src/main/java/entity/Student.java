package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
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

    @Transient
    @OneToMany(mappedBy = "student")
    private List<StudentGroup> studentGroupList;

    @Transient
    @OneToMany(mappedBy = "student")
    private List<StudentCustomField> studentCustomFieldList;

    @Transient
    @OneToMany(mappedBy = "student")
    private List<StudentCertificate> studentCertificateList;

    @Transient
    @OneToMany(mappedBy = "student")
    private List<TechnologyStudentNow> technologyStudentNowList;

    @Transient
    @OneToMany(mappedBy = "student")
    private List<TechnologyStudentFuture> technologyStudentFutureList;

    @Transient
    @OneToMany(mappedBy = "student")
    private List<Interview> interviewList;

    @Transient
    @OneToMany(mappedBy = "student")
    private List<StudentCurator> studentCuratorList;

    @Transient
    @OneToMany(mappedBy = "student")
    private List<StudentProject> studentProjectList;

    @Transient
    @OneToMany(mappedBy = "student")
    private List<Feedback> feedbackList;

    public Student(User user) {
        this.user = user;
    }

    public Student() {
    }

    public Student(String startedWorkDate,
                   boolean hadProbation,
                   int startAtCourse,
                   int wantedWorkHours,
                   String changeHoursDate,
                   String englishLevel,
                   String wantedCourses,
                   String phoneNumber,
                   String skype,
                   boolean wantEnglishTraining,
                   String currentEnglishTraining,
                   User user,
                   List<StudentGroup> studentGroupList,
                   List<StudentCustomField> studentCustomFieldList,
                   List<StudentCertificate> studentCertificateList,
                   List<TechnologyStudentNow> technologyStudentNowList,
                   List<TechnologyStudentFuture> technologyStudentFutureList,
                   List<Interview> interviewList,
                   List<StudentCurator> studentCuratorList,
                   List<StudentProject> studentProjectList,
                   List<Feedback> feedbackList) {
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
        this.studentGroupList = studentGroupList;
        this.studentCustomFieldList = studentCustomFieldList;
        this.studentCertificateList = studentCertificateList;
        this.technologyStudentNowList = technologyStudentNowList;
        this.technologyStudentFutureList = technologyStudentFutureList;
        this.interviewList = interviewList;
        this.studentCuratorList = studentCuratorList;
        this.studentProjectList = studentProjectList;
        this.feedbackList = feedbackList;
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

    public List<StudentGroup> getStudentGroupList() {
        return studentGroupList;
    }

    public void setStudentGroupList(List<StudentGroup> studentGroupList) {
        this.studentGroupList = studentGroupList;
    }

    public List<StudentCustomField> getStudentCustomFieldList() {
        return studentCustomFieldList;
    }

    public void setStudentCustomFieldList(List<StudentCustomField> studentCustomFieldList) {
        this.studentCustomFieldList = studentCustomFieldList;
    }

    public List<StudentCertificate> getStudentCertificateList() {
        return studentCertificateList;
    }

    public void setStudentCertificateList(List<StudentCertificate> studentCertificateList) {
        this.studentCertificateList = studentCertificateList;
    }

    public List<TechnologyStudentNow> getTechnologyStudentNowList() {
        return technologyStudentNowList;
    }

    public void setTechnologyStudentNowList(List<TechnologyStudentNow> technologyStudentNowList) {
        this.technologyStudentNowList = technologyStudentNowList;
    }

    public List<TechnologyStudentFuture> getTechnologyStudentFutureList() {
        return technologyStudentFutureList;
    }

    public void setTechnologyStudentFutureList(List<TechnologyStudentFuture> technologyStudentFutureList) {
        this.technologyStudentFutureList = technologyStudentFutureList;
    }

    public List<Interview> getInterviewList() {
        return interviewList;
    }

    public void setInterviewList(List<Interview> interviewList) {
        this.interviewList = interviewList;
    }

    public List<StudentCurator> getStudentCuratorList() {
        return studentCuratorList;
    }

    public void setStudentCuratorList(List<StudentCurator> studentCuratorList) {
        this.studentCuratorList = studentCuratorList;
    }

    public List<StudentProject> getStudentProjectList() {
        return studentProjectList;
    }

    public void setStudentProjectList(List<StudentProject> studentProjectList) {
        this.studentProjectList = studentProjectList;
    }

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }
}
