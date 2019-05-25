package com.letsstartcoding.springbootrestapiexample;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "Employees")
@EntityListeners(AuditingEntityListener.class)
class Employee{
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
   @NotBlank
    private String name;
   @NotBlank
    private String designation;
   @NotBlank
    private String expertise;
   @LastModifiedDate
   @Temporal(TemporalType.TIMESTAMP)

    private Date createdAt;




}
