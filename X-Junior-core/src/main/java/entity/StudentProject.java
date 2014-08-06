package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Administrator on 17.07.2014.
 */
@Entity
@Table(name = "student_project")
public class StudentProject extends BaseEntity {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "project_id")
    private Project project;

    @Column(name = "role")
    private String role;

    @Column(name = "project_status")
    private String project_status;

    @Column(name = "billable")
    private boolean billable;

    @Column(name = "want_change_project")
    private boolean want_change_project;

    @Column(name = "present_work_hours")
    private boolean present_work_hours;

    public StudentProject() {
    }

    public StudentProject(Student student,
                          Project project,
                          String role,
                          String project_status,
                          boolean billable,
                          boolean want_change_project,
                          boolean present_work_hours) {
        this.student = student;
        this.project = project;
        this.role = role;
        this.project_status = project_status;
        this.billable = billable;
        this.want_change_project = want_change_project;
        this.present_work_hours = present_work_hours;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProject_status() {
        return project_status;
    }

    public void setProject_status(String project_status) {
        this.project_status = project_status;
    }

    public boolean isBillable() {
        return billable;
    }

    public void setBillable(boolean billable) {
        this.billable = billable;
    }

    public boolean isWant_change_project() {
        return want_change_project;
    }

    public void setWant_change_project(boolean want_change_project) {
        this.want_change_project = want_change_project;
    }

    public boolean isPresent_work_hours() {
        return present_work_hours;
    }

    public void setPresent_work_hours(boolean present_work_hours) {
        this.present_work_hours = present_work_hours;
    }
}
