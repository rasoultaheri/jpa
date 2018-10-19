package ir.imrasta.jpatest.domain;

import ir.imrasta.jpatest.validation.employee.EmployeeEntity;

import javax.persistence.*;

@Entity
@EmployeeEntity
public class Employee {
 
    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Keshvar melliat;
    private String codeMelli;

    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Location location;

    public Employee() {
    }

    public Employee(String firstName, String lastName, Keshvar melliat, String codeMelli) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.melliat = melliat;
        this.codeMelli = codeMelli;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Keshvar getMelliat() {
        return melliat;
    }

    public void setMelliat(Keshvar melliat) {
        this.melliat = melliat;
    }

    public String getCodeMelli() {
        return codeMelli;
    }

    public void setCodeMelli(String codeMelli) {
        this.codeMelli = codeMelli;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}