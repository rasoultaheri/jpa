package ir.imrasta.jpatest.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Kharid {

    @Id
    @GeneratedValue
    private Integer id;
    private Date tarikhSabt;
    private String sharh;
    private Double jamTakhfif;
    private Double jamMablagh;
    private Double jamMablaghNahayee;

    public Kharid() {
    }

    public Kharid(String sharh) {
        this.sharh = sharh;
    }


    @OneToMany(
            mappedBy = "kharid",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<RizKharid> items;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTarikhSabt() {
        return tarikhSabt;
    }

    public void setTarikhSabt(Date tarikhSabt) {
        this.tarikhSabt = tarikhSabt;
    }

    public String getSharh() {
        return sharh;
    }

    public void setSharh(String sharh) {
        this.sharh = sharh;
    }

    public Double getJamTakhfif() {
        return jamTakhfif;
    }

    public void setJamTakhfif(Double jamTakhfif) {
        this.jamTakhfif = jamTakhfif;
    }

    public Double getJamMablagh() {
        return jamMablagh;
    }

    public void setJamMablagh(Double jamMablagh) {
        this.jamMablagh = jamMablagh;
    }

    public Double getJamMablaghNahayee() {
        return jamMablaghNahayee;
    }

    public void setJamMablaghNahayee(Double jamMablaghNahayee) {
        this.jamMablaghNahayee = jamMablaghNahayee;
    }

    public List<RizKharid> getItems() {
        if (items == null)
            items = new ArrayList<RizKharid>();
        return items;
    }

    public void setItems(List<RizKharid> items) {
        this.items = items;
    }


    @PrePersist
    @PreUpdate
    public void loadDefaultValues() {
        this.tarikhSabt=new Date();

        this.jamMablagh = 0d;
        this.jamTakhfif = 0d;
        this.jamMablaghNahayee = 0d;

        for(RizKharid r : getItems()) {
            r.loadDefaultValues();
            this.jamMablagh += r.getMablaghKol();
            this.jamTakhfif += r.getMablaghTakhfif();
            this.jamMablaghNahayee += r.getMablaghNahayee();
        }
    }


    @Override
    public String toString() {
        return "Kharid{" +
                "sharh='" + sharh + '\'' +
                ", jamMablaghNahayee=" + jamMablaghNahayee +
                '}';
    }
}
