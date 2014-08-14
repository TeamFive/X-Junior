package VO;

import entity.CustomField;
import entity.FieldsGroup;

/**
 * Created by ALEX on 07.08.2014.
 */
public class CustomFieldVO implements BaseVO {
    private Long id;
    private String name;
    private String fieldType;
    private FieldsGroup fieldsGroup;
    private String options;

    public CustomFieldVO(CustomField customField) {
        this.id = customField.getId();
        this.name = customField.getName();
        this.fieldType = customField.getFieldType();
        this.fieldsGroup = customField.getFieldsGroup();
        this.options = customField.getOptions();
    }

    public Long getId() {
        return id;
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

    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
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
