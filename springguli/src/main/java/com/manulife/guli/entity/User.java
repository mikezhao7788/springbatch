package com.manulife.guli.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class User {
    @JsonIgnore
    private  long id;

    @NotNull( message = "用户名不能为空")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name;
   // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date entityDate;

    public User(long id, String name, Date entityDate) {
        this.id = id;
        this.name = name;
        this.entityDate = entityDate;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "com.manulife.guli.entity.User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", entityDate=" + entityDate +
                '}';
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

    public Date getEntityDate() {
        return entityDate;
    }

    public void setEntityDate(Date entityDate) {
        this.entityDate = entityDate;
    }
}
