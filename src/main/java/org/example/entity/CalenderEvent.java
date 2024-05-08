package org.example.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalTime;

@Entity
@Table(name = "calender_event")
@JsonPropertyOrder({"id", "title", "description", "start_time", "end_time", "user"})
public class CalenderEvent extends PanacheEntity {

    @Column(name = "id")
    @JsonProperty("id")
    private Long id;

    @Column(name = "title")
    @JsonProperty("title")
    public String title;

    @Column(name = "description")
    @JsonProperty("description")
    public String description;

    @Column(name = "start_time")
    @JsonProperty("start_time")
    public LocalTime startTime;

    @Column(name = "end_time")
    @JsonProperty("end_time")
    public LocalTime endTime;

    @ManyToOne
    @JsonProperty("user")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private User user;

    public CalenderEvent() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
