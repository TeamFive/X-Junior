package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Curator")
public class Curator extends BaseEntity {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "User_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "student_curator",
    joinColumns = @JoinColumn(name = "Student_id"),
    inverseJoinColumns = @JoinColumn(name = "Curator_id"))
    private List<Student> studentList;


    public Curator() {
    }

    public Curator(User user, List<Student> studentList) {
        this.user = user;
        this.studentList = studentList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
