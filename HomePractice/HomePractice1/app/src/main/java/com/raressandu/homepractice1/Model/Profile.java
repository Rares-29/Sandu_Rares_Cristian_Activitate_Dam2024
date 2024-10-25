package com.raressandu.homepractice1.Model;

public class Profile {

    private String name;
    private Integer age;
    private String gender;
    private Boolean sport;

    public Profile(String name, Integer age, String gender, Boolean sport) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.sport = sport;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setSport(Boolean sport) {
        this.sport = sport;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public Boolean getSport() {
        return sport;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", sport=" + sport +
                '}';
    }
}
