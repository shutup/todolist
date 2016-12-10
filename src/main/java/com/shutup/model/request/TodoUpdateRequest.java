package com.shutup.model.request;

/**
 * Created by shutup on 2016/12/10.
 */
public class TodoUpdateRequest {
    private String todo;

    private boolean isFinish;
    private boolean isDelete;

    public TodoUpdateRequest() {
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
