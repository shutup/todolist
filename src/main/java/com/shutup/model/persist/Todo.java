package com.shutup.model.persist;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by shutup on 2016/12/3.
 */
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  id;

    /** Model created at timestamp. */

    @CreationTimestamp
    private Date createdAt;

    /** Model updated at timestamp. */

    @UpdateTimestamp
    private Date updatedAt;

    @OneToOne(targetEntity = User.class)
    private User user;

    @Lob
    @NotNull(message = "内容不能为空")
    private String todo;

    private boolean isFinish;
    private boolean isDelete;

    public Todo() {
    }

    public Todo(String todo) {
        this.todo = todo;
        this.isFinish = false;
        this.isDelete = false;
    }

    public Todo(String todo, boolean isFinish, boolean isDelete) {
        this.todo = todo;
        this.isFinish = isFinish;
        this.isDelete = isDelete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
