package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Feedback")
public class Feedback extends BaseEntity {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "people_relation")
    private int peopleRelation;

    @Column(name = "work_attitude")
    private int workAttitude;

    @Column(name = "increase_hours")
    private boolean increaseHours;

    @Column(name = "real_project")
    private String realProject;

    @Column(name = "extra")
    private String extra;

    @Column(name = "date")
    private String date;

    @Column(name = "proff_suitab")
    private int proffSuitab;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "Curator_id")
    private Curator curator;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "Student_id")
    private Student student;

    public Feedback() {
    }

    public Feedback(int peopleRelation,
                    int workAttitude,
                    boolean increaseHours,
                    String realProject,
                    String extra,
                    String date,
                    int proffSuitab,
                    Curator curator,
                    Student student) {
        this.peopleRelation = peopleRelation;
        this.workAttitude = workAttitude;
        this.increaseHours = increaseHours;
        this.realProject = realProject;
        this.extra = extra;
        this.date = date;
        this.proffSuitab = proffSuitab;
        this.curator = curator;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPeopleRelation() {
        return peopleRelation;
    }

    public void setPeopleRelation(int peopleRelation) {
        this.peopleRelation = peopleRelation;
    }

    public int getWorkAttitude() {
        return workAttitude;
    }

    public void setWorkAttitude(int workAttitude) {
        this.workAttitude = workAttitude;
    }

    public boolean isIncreaseHours() {
        return increaseHours;
    }

    public void setIncreaseHours(boolean increaseHours) {
        this.increaseHours = increaseHours;
    }

    public String getRealProject() {
        return realProject;
    }

    public void setRealProject(String realProject) {
        this.realProject = realProject;
    }

    public String getExtra() {
        return extra;
    }

    public void setExtra(String extra) {
        this.extra = extra;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getProffSuitab() {
        return proffSuitab;
    }

    public void setProffSuitab(int proffSuitab) {
        this.proffSuitab = proffSuitab;
    }

    public Curator getCurator() {
        return curator;
    }

    public void setCurator(Curator curator) {
        this.curator = curator;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
