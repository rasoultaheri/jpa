package ir.imrasta.jpatest.domain;

import ir.imrasta.jpatest.validation.codeposti.CodePosti;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
public class Location {

    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String address;
    @CodePosti
    private String codePosti;

    public Location() {
    }

    public Location(String address, String codePosti) {
        this.address = address;
        this.codePosti = codePosti;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCodePosti() {
        return codePosti;
    }

    public void setCodePosti(String codePosti) {
        this.codePosti = codePosti;
    }

}
