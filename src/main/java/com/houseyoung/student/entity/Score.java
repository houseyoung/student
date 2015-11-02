package com.houseyoung.student.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by houseyoung on 15/10/10 22:37.
 */
@Entity
@Table(name = "t_score")
public class Score {
    @Id
    private Integer id;
    
    private Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
