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

    @Column(name = "default_value")
    private String defaultValue;

    @Column(name = "field_type")
    private String fieldType;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "FieldsGroup_id")
    private FieldsGroup fieldsGroup;

    public CustomField() {
    }

    public CustomField(String name, String defaultValue, FieldsGroup fieldsGroup, String fieldType) {
        this.name = name;
        this.defaultValue = defaultValue;
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

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public FieldsGroup getFieldsGroup() {
        return fieldsGroup;
    }

    public void setFieldsGroup(FieldsGroup fieldsGroup) {
        this.fieldsGroup = fieldsGroup;
    }
}
