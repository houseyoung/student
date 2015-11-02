package com.houseyoung.student.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by houseyoung on 15/10/8 21:21.
 */
@Entity
@Table(name = "t_school")
public class School {
    @Id
    private Integer id;
    
    private String name;
    
    private String university;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
