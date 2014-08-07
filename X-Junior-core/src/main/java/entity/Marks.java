package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Marks")
public class Marks extends BaseEntity {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "mark")
    private String mark;

    @Column(name = "date")
    private String date;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "Student_id")
    private Student student;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "Group_id")
    private Group group;

    public Marks() {
    }

    public Marks(String mark, String date, Student student, Group group) {
        this.mark = mark;
        this.date = date;
        this.student = student;
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
