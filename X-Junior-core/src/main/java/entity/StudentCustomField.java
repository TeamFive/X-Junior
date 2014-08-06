package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Student_CustomField")
public class StudentCustomField {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "Student_id")
    private Student student;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "CustomField_id")
    private CustomField customField;

    public StudentCustomField() {
    }

    public StudentCustomField(Student student, CustomField customField) {
        this.student = student;
        this.customField = customField;
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

    public CustomField getCustomField() {
        return customField;
    }

    public void setCustomField(CustomField customField) {
        this.customField = customField;
    }
}
