package VO;

import entity.Certificate;

/**
 * Created by ALEX on 07.08.2014.
 */
public class CertificateVO implements BaseVO {
    private Long id;
    private String name;

    public CertificateVO(Certificate certificate) {
        this.id = certificate.getId();
        this.name = certificate.getName();
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
}
