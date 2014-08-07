package controller;

import VO.*;
import entity.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class VOConverter {
    public BaseVO convert(BaseEntity baseEntity){
        if(baseEntity instanceof Curator)
            return new CuratorVO((Curator) baseEntity);
        if(baseEntity instanceof Student)
            return new StudentVO((Student) baseEntity);
        if(baseEntity instanceof Admin)
            return new AdminVO((Admin) baseEntity);
        if(baseEntity instanceof Certificate)
            return new CertificateVO((Certificate) baseEntity);
        if(baseEntity instanceof Course)
            return new CourseVO((Course) baseEntity);
        if(baseEntity instanceof CustomField)
            return new CustomFieldVO((CustomField) baseEntity);
        if(baseEntity instanceof HR)
            return new HRVO((HR) baseEntity);
        if(baseEntity instanceof Faculty)
            return new FacultyVO((Faculty) baseEntity);
        if (baseEntity instanceof Feedback)
            return new FeedbackVO((Feedback) baseEntity);
        return null;
    }

    public List<BaseVO> convertList(String entity, List<BaseEntity> entityList){
        List<BaseVO> baseVOList = new ArrayList<BaseVO>();
        if (entity.equalsIgnoreCase("curator")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new CuratorVO((Curator) item));
            }
            return baseVOList;
        }
        if (entity.equalsIgnoreCase("student")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new StudentVO((Student) item));
            }
            return baseVOList;
        }
        if (entity.equalsIgnoreCase("admin")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new AdminVO((Admin) item));
            }
            return baseVOList;
        }
        if (entity.equalsIgnoreCase("certificate")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new CertificateVO((Certificate) item));
            }
            return baseVOList;
        }
        if (entity.equalsIgnoreCase("course")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new CourseVO((Course) item));
            }
            return baseVOList;
        }
        if (entity.equalsIgnoreCase("customfield")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new CustomFieldVO((CustomField) item));
            }
            return baseVOList;
        }
        if (entity.equalsIgnoreCase("hr")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new HRVO((HR) item));
            }
            return baseVOList;
        }
        if (entity.equalsIgnoreCase("faculty")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new FacultyVO((Faculty) item));
            }
            return baseVOList;
        }
        if (entity.equalsIgnoreCase("feedback")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new FeedbackVO((Feedback) item));
            }
            return baseVOList;
        }
        return null;
    }
}
