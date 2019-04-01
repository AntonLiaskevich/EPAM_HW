package com.example.user.epam_hw.backend.entities;

public class Student {

    private Long id;
    private String name;
    private int homeworkCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHomeworkCount() {
        return homeworkCount;
    }

    public void setHomeworkCount(int homeworkCount) {
        this.homeworkCount = homeworkCount;
    }
}
