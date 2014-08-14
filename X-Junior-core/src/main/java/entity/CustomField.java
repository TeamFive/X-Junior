package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "CustomField")
public class CustomField extends BaseEntity {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @Column(name = "custom_field_name")
    private String name;

    @Column(name = "field_type")
    private String fieldType;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "FieldsGroup_id")
    private FieldsGroup fieldsGroup;

    @Column(name = "options")
    private String options;

    public CustomField() {
    }

    public CustomField(String name, FieldsGroup fieldsGroup, String fieldType, String options) {
        this.name = name;
        this.options = options;
        this.fieldsGroup = fieldsGroup;
        this.fieldType = fieldType;
    }

    public Long getId() {
        return id;
    }

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FieldsGroup getFieldsGroup() {
        return fieldsGroup;
    }

    public void setFieldsGroup(FieldsGroup fieldsGroup) {
        this.fieldsGroup = fieldsGroup;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
}
