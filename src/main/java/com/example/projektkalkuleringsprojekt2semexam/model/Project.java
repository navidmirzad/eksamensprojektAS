package com.example.projektkalkuleringsprojekt2semexam.model;

public class Project {

    private int projectid;
    private String name;
    private String description;
    private int estimatedTime;
    private String startDate;
    private String endDate;
    private int projectRank;
    private boolean isDone;

    public Project() {

    }

    public Project(int projectid, String name, String description, int estimatedTime, String startDate,
                   String endDate, int projectRank, boolean isDone) {
        this.projectid = projectid;
        this.name = name;
        this.description = description;
        this.estimatedTime = estimatedTime;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectRank = projectRank;
        this.isDone = isDone;
    }

    public int getProjectid() {
        return projectid;
    }

    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getProjectRank() {
        return projectRank;
    }

    public void setProjectRank(int projectRank) {
        this.projectRank = projectRank;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}