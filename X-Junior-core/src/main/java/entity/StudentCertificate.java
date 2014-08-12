package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

//@Entity
//@Table(name = "Student_Certificate")
//@SecondaryTable(name = "student_certificate", pkJoinColumns = @PrimaryKeyJoinColumn(name = "id"))
public class StudentCertificate extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;


    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "Student_id")
    private Student student;


    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "Certificate_id")
    private Certificate certificate;

    public StudentCertificate() {
    }

    public StudentCertificate(Student student, Certificate certificate) {
        this.student = student;
        this.certificate = certificate;
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

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }
}
