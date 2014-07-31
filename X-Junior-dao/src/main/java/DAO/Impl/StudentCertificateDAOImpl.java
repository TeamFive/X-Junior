package DAO.Impl;

import entity.StudentCertificate;
import org.springframework.stereotype.Repository;

@Repository
public class StudentCertificateDAOImpl extends BaseDAOImpl<StudentCertificate> {
    public StudentCertificateDAOImpl() {
        super(StudentCertificate.class);
    }

    public StudentCertificateDAOImpl(Class<StudentCertificate> type) {
        super(type);
    }
}
