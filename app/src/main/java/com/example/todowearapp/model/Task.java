package com.example.todowearapp.model;

public class Task {
    private String id = "";
    private String taskDetails = "";

    public Task(String id, String taskDetails) {
        this.id = id;
        this.taskDetails = taskDetails;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getTaskDetails(){
        return taskDetails;
    }

    public void setTaskDetails(String taskDetails) {
        this.taskDetails = taskDetails;
    }
}
