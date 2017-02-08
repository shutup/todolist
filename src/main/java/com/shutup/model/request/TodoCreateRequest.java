package com.shutup.model.request;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by shutup on 2016/12/4.
 */
public class TodoCreateRequest {

    @NotNull(message = "内容不能为空")
    private String todo;
    @NotNull(message = "")
    private Date createdAt;
    @NotNull(message = "")
    private Date updatedAt;
    @NotNull(message = "")
    private boolean isFinish;
    @NotNull(message = "")
    private boolean isDelete;

    public TodoCreateRequest() {
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }


    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public boolean isFinish() {
        return isFinish;
    }

    public void setFinish(boolean finish) {
        isFinish = finish;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
