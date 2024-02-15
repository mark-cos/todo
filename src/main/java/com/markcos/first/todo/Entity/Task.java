package com.markcos.first.todo.Entity;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "priority")
    private Long priority;

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
