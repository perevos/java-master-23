package ru.bfu.java.courseapi.dto;

public class CourseRequestDto {
    private String title;
    private String description;
    private Integer numberOfLectures;

    // GETTERS AND SETTERS
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

    public Integer getNumberOfLectures() {
        return numberOfLectures;
    }

    public void setNumberOfLectures(Integer numberOfLectures) {
        this.numberOfLectures = numberOfLectures;
    }
}
