package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Technology")
public class Technology extends BaseEntity {

    private Long id;
    private String technology_name;

    public Technology(String technology_name) {
        this.technology_name = technology_name;
    }

    public Technology() {
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

    @Column(name = "technology_name")
    public String getTechnology_name() {
        return technology_name;
    }

    public void setTechnology_name(String technology_name) {
        this.technology_name = technology_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Technology)) return false;

        Technology that = (Technology) o;

        if (!technology_name.equals(that.technology_name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return technology_name.hashCode();
    }
}
