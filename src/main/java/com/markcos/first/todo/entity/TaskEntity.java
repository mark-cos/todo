package com.markcos.first.todo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "task")
@Getter
@Setter
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

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
    private CategoryEntity categoryEntity;

    public TaskEntity(Integer id, UserEntity userEntity, String title, String description, Integer priority, Boolean isCompleted, Date taskDate, Date taskTime, CategoryEntity categoryEntity) {
        this.id = id;
        this.userEntity = userEntity;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.isCompleted = isCompleted;
        this.taskDate = taskDate;
        this.taskTime = taskTime;
        this.categoryEntity = categoryEntity;
    }

    protected TaskEntity() {}
}
