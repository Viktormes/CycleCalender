package org.example.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalTime;

public class AddCalenderEventDTO {

    @JsonProperty("title")
    private String title;
    @JsonProperty("description")
    private String description;
    @JsonProperty("start_time")
    private LocalTime startDate;
    @JsonProperty("end_time")
    private LocalTime endDate;

    public AddCalenderEventDTO() {
    }

    public AddCalenderEventDTO(String title, String description, LocalTime startDate, LocalTime endDate) {
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public LocalTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalTime startDate) {
        this.startDate = startDate;
    }

    public LocalTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalTime endDate) {
        this.endDate = endDate;
    }
}
