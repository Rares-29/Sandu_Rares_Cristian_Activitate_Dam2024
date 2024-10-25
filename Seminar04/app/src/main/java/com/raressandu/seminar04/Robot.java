package com.raressandu.seminar04;

import java.util.Date;

public class Robot {
    String name;
    Boolean isSmart;
    Date lastTimeActive;
    String softBytes;

    public Robot(String name, Boolean isSmart, Date lastTimeActive, String softBytes) {
        this.name = name;
        this.isSmart = isSmart;
        this.lastTimeActive = lastTimeActive;
        this.softBytes = softBytes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSmart() {
        return isSmart;
    }

    public void setSmart(Boolean smart) {
        isSmart = smart;
    }

    public Date getLastTimeActive() {
        return lastTimeActive;
    }

    public void setLastTimeActive(Date lastTimeActive) {
        this.lastTimeActive = lastTimeActive;
    }

    public String getSoftBytes() {
        return softBytes;
    }

    public void setSoftBytes(String softBytes) {
        this.softBytes = softBytes;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", isSmart=" + isSmart +
                ", lastTimeActive=" + lastTimeActive +
                ", softBytes='" + softBytes + '\'' +
                '}';
    }
}
