package com.raressandu.prepareforexam03;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Task implements Parcelable {
    String title;
    String description;
    String assignee;
    Date deadline;
    DifficultyGrades difficulty;

    public Task(String title, String description, String assignee, Date deadline, DifficultyGrades difficulty) {
        this.title = title;
        this.description = description;
        this.assignee = assignee;
        this.deadline = deadline;
        this.difficulty = difficulty;
    }

    protected Task(Parcel in) {
        title = in.readString();
        description = in.readString();
        assignee = in.readString();
        deadline = new Date(in.readLong());
        difficulty = DifficultyGrades.values()[in.readInt()];
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(assignee);
        dest.writeLong(deadline.getTime());
        dest.writeInt(difficulty.ordinal());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Task> CREATOR = new Creator<Task>() {
        @Override
        public Task createFromParcel(Parcel in) {
            return new Task(in);
        }

        @Override
        public Task[] newArray(int size) {
            return new Task[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public DifficultyGrades getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(DifficultyGrades difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", assignee='" + assignee + '\'' +
                ", deadline=" + deadline +
                ", difficulty=" + difficulty +
                '}';
    }
}


enum DifficultyGrades {
    EASY,
    MEDIUM,
    HARD
}