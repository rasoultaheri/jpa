package ir.imrasta.jpatest.domain;

import javax.persistence.*;

@Entity
public class RizKharid {

    @Id
    @GeneratedValue
    private Integer id;
    private String naam;
    private Integer tedad;
    private Double fi;
    private Double mablaghKol;
    private Double darsadTakhfif;
    private Double mablaghTakhfif;
    private Double mablaghNahayee;

    @ManyToOne(optional = false)
    private Kharid kharid;

    public RizKharid() {
    }

    public RizKharid(Kharid kharid, String naam, Integer tedad, Double fi, Double darsadTakhfif) {
        this.kharid = kharid;
        this.naam = naam;
        this.tedad = tedad;
        this.fi = fi;
        this.darsadTakhfif = darsadTakhfif;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Integer getTedad() {
        return tedad;
    }

    public void setTedad(Integer tedad) {
        this.tedad = tedad;
    }

    public Double getFi() {
        return fi;
    }

    public void setFi(Double fi) {
        this.fi = fi;
    }

    public Double getMablaghKol() {
        return mablaghKol;
    }

    public void setMablaghKol(Double mablaghKol) {
        this.mablaghKol = mablaghKol;
    }

    public Double getDarsadTakhfif() {
        return darsadTakhfif;
    }

    public void setDarsadTakhfif(Double darsadTakhfif) {
        this.darsadTakhfif = darsadTakhfif;
    }

    public Double getMablaghTakhfif() {
        return mablaghTakhfif;
    }

    public void setMablaghTakhfif(Double mablaghTakhfif) {
        this.mablaghTakhfif = mablaghTakhfif;
    }

    public Double getMablaghNahayee() {
        return mablaghNahayee;
    }

    public void setMablaghNahayee(Double mablaghNahayee) {
        this.mablaghNahayee = mablaghNahayee;
    }

    public Kharid getKharid() {
        return kharid;
    }

    public void setKharid(Kharid kharid) {
        this.kharid = kharid;
    }

    @PrePersist
    @PreUpdate
    public void loadDefaultValues() {
        this.mablaghKol = this.fi * this.tedad;
        this.mablaghTakhfif = mablaghKol * darsadTakhfif / 100;
        this.mablaghNahayee = this.mablaghKol - this.mablaghTakhfif;
    }
}
