package org.forten.si.data.dto;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/7.
 */
public class StudentInfo {
    private int id;
    private String name;
    private int age;
    private String gender;
    private Date registTime;

    public StudentInfo() {
        this.registTime = new Date();
    }

    public StudentInfo(int id, String name, int age, String gender) {
        this();
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", registTime=" + registTime +
                '}';
    }
}
