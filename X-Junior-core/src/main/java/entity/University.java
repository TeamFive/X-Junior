package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "University")
@NamedQuery(
        name = "findUniversityByName",
        query = "Select uni from University uni where uni.university_name = :name"
)
public class University extends BaseEntity {
    private Long id;
    private String university_name;

    public University(String university_name) {
        this.university_name = university_name;
    }

    public University() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "university_name")
    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }
}
