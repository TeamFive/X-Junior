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
            return new StudentElem((Student) baseEntity);
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
        if (baseEntity instanceof FieldsGroup)
            return new FieldsGroupVO((FieldsGroup) baseEntity);
        if (baseEntity instanceof Group)
            return new GroupVO((Group) baseEntity);
        if (baseEntity instanceof Interview)
            return new InterviewVO((Interview) baseEntity);
        if (baseEntity instanceof Interviewer)
            return new InterviewerVO((Interviewer) baseEntity);
        if (baseEntity instanceof Marks)//----------------------------------------------------------------------------
            return new MarksVO((Marks) baseEntity);
        if (baseEntity instanceof PM)
            return new PMVO((PM) baseEntity);
        if (baseEntity instanceof Project)
            return new ProjectVO((Project) baseEntity);
        if (baseEntity instanceof Setting)
            return new SettingVO((Setting) baseEntity);
        if (baseEntity instanceof TeamLeader)
            return new TeamLeaderVO((TeamLeader) baseEntity);
        if (baseEntity instanceof Technology)
            return new TechnologyVO((Technology) baseEntity);
        if (baseEntity instanceof User)
            return new UserVO((User) baseEntity);
        if (baseEntity instanceof University)
            return new UniversityVO((University) baseEntity);
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
                baseVOList.add(new StudentElem((Student) item));
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
        if (entity.equalsIgnoreCase("fieldsgroup")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new FieldsGroupVO((FieldsGroup) item));
            }
            return baseVOList;
        }
        if (entity.equalsIgnoreCase("group")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new GroupVO((Group) item));
            }
            return baseVOList;
        }
        if (entity.equalsIgnoreCase("interview")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new InterviewVO((Interview) item));
            }
            return baseVOList;
        }
        if (entity.equalsIgnoreCase("interviewer")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new InterviewerVO((Interviewer) item));
            }
            return baseVOList;
        }
        if (entity.equalsIgnoreCase("marks")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new MarksVO((Marks) item));
            }
            return baseVOList;
        }
        if (entity.equalsIgnoreCase("pm")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new PMVO((PM) item));
            }
            return baseVOList;
        }
        if (entity.equalsIgnoreCase("project")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new ProjectVO((Project) item));
            }
            return baseVOList;
        }
        if (entity.equalsIgnoreCase("setting")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new SettingVO((Setting) item));
            }
            return baseVOList;
        }
        if (entity.equalsIgnoreCase("teamleader")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new TeamLeaderVO((TeamLeader) item));
            }
            return baseVOList;
        }
        if (entity.equalsIgnoreCase("technology")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new TechnologyVO((Technology) item));
            }
            return baseVOList;
        }
        if (entity.equalsIgnoreCase("user")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new UserVO((User) item));
            }
            return baseVOList;
        }
        if (entity.equalsIgnoreCase("university")) {
            for (BaseEntity item : entityList){
                baseVOList.add(new UniversityVO((University) item));
            }
            return baseVOList;
        }
        return null;
    }
}
