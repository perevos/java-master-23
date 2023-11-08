package ru.bfu.java.courseapi.dto;

public class CourseResponseDto {
    private Long id;
    private String title;
    private String description;
    private Integer numberOfLectures;

    // GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
