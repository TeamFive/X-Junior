package VO;

import entity.CustomField;
import entity.FieldsGroup;

/**
 * Created by ALEX on 07.08.2014.
 */
public class CustomFieldVO implements BaseVO {
    private Long id;
    private String name;
    private String defaultValue;
    private String fieldType;
    private FieldsGroup fieldsGroup;

    public CustomFieldVO(CustomField customField) {
        this.id = customField.getId();
        this.name = customField.getName();
        this.defaultValue = customField.getDefaultValue();
        this.fieldType = customField.getFieldType();
        this.fieldsGroup = customField.getFieldsGroup();
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

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
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
}
