package com.hunter.computerhunter.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.sql.Date;

@Entity
public class Information {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;

    @Min(value = 0, message = "访问次数不能为负")
    private Integer visitetimes;

    public Information(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getVisitetimes() {
        return visitetimes;
    }

    public void setVisitetimes(Integer visitetimes) {
        this.visitetimes = visitetimes;
    }

    private String content;
    private Date time;
    private String source;
    //private Integer visitetimes;

}
