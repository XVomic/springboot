package com.xxc.learnboot.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "obj")
public class StudentProperty {
    private String sname;
    private int sage;
    private List<String> hobby;
    private Map<String,String> city;

    @Override
    public String toString() {
        return "StudentProperty{" +
                "sname='" + sname + '\'' +
                ", sage=" + sage +
                ", hobby=" + hobby +
                ", city=" + city +
                '}';
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public List<String> getHobby() {
        return hobby;
    }

    public void setHobby(List<String> hobby) {
        this.hobby = hobby;
    }

    public Map<String, String> getCity() {
        return city;
    }

    public void setCity(Map<String, String> city) {
        this.city = city;
    }
}
