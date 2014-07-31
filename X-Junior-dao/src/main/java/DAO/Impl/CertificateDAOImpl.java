package DAO.Impl;

import entity.Certificate;
import org.springframework.stereotype.Repository;

@Repository
public class CertificateDAOImpl extends BaseDAOImpl<Certificate> {
    public CertificateDAOImpl() {
        super(Certificate.class);
    }

    public CertificateDAOImpl(Class<Certificate> type) {
        super(type);
    }
}
