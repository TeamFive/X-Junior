package VO;

import entity.Certificate;

/**
 * Created by ALEX on 07.08.2014.
 */
public class CertificateVO implements BaseVO {
    private Long id;
    private String name;
    private String date;

    public CertificateVO(Certificate certificate) {
        this.id = certificate.getId();
        this.name = certificate.getName();
        this.date = certificate.getDate();
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
