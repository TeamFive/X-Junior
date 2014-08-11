package DAO.Impl;

import entity.Certificate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Repository
public class CertificateDAOImpl extends BaseDAOImpl<Certificate> {
    public CertificateDAOImpl() {
        super(Certificate.class);
    }

    public CertificateDAOImpl(Class<Certificate> type) {
        super(type);
    }

    public String createCertificate(Certificate certificate){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JaneList");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(certificate);
        entityManager.getTransaction().commit();
        return "success";
    }
}
