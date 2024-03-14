package com.markcos.first.todo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "task")
@Getter
@Setter
public class Task {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "priority")
    private Integer priority;

    @Column(name = "is_completed")
    private Boolean isCompleted;

    @Column(name = "task_date")
    private Date taskDate;

    @Column(name = "task_time")
    private Date taskTime;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
