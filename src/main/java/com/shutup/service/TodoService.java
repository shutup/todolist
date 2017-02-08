package com.shutup.service;

import com.shutup.exception.AuthorizeFailException;
import com.shutup.exception.CustomException;
import com.shutup.mapper.TodoMapper;
import com.shutup.model.persist.Todo;
import com.shutup.model.persist.User;
import com.shutup.model.persist.UserStatus;
import com.shutup.model.request.TodoCreateRequest;
import com.shutup.model.request.TodoUpdateRequest;
import com.shutup.model.response.RestInfo;
import com.shutup.model.response.TodoCreateResponse;
import com.shutup.repo.TodoRepo;
import com.shutup.repo.UserRepo;
import com.shutup.repo.UserStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * Created by shutup on 2016/12/4.
 */
@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;
    @Autowired
    private UserStatusRepo userStatusRepo;
    @Autowired
    private UserRepo userRepo;

    public TodoCreateResponse CreateTodo(String token, TodoCreateRequest todoCreateRequest) {
        UserStatus userStatus = userStatusRepo.findByToken(token);
        if (userStatus != null) {
            Todo todo = TodoMapper.Instance.TodoCreateRequestToTodo(todoCreateRequest);
            todo.setUser(userStatus.getUser());
            Todo newTodo = todoRepo.save(todo);
            User user = userStatus.getUser();
            user.getTodoList().add(newTodo);
            userRepo.save(user);
            if (newTodo != null) {
                return TodoMapper.Instance.TodoToTodoCreateResponse(newTodo);
            }else {
                return null;
            }
        }else {
           throw new AuthorizeFailException("鉴权失败");
        }
    }

    public Todo DelTodo(String token, Long tid) {
        UserStatus userStatus = userStatusRepo.findByToken(token);
        if (userStatus != null) {
            Todo todo = todoRepo.findById(tid);
            if (todo !=null) {
                todo.setDelete(true);
                return todoRepo.save(todo);
            }else {
                throw new CustomException("todo not exist", false, HttpStatus.NOT_FOUND);
            }
        }else {
            throw new AuthorizeFailException("鉴权失败");
        }
    }

    public Todo UpdateTodo(String token, Long tid, TodoUpdateRequest todoUpdateRequest) {
        UserStatus userStatus = userStatusRepo.findByToken(token);
        if (userStatus != null) {
            Todo todo = todoRepo.findById(tid);
            if (todo !=null) {
                todo.setTodo(todoUpdateRequest.getTodo());
                todo.setFinish(todoUpdateRequest.isFinish());
                todo.setDelete(todoUpdateRequest.isDelete());
                return todoRepo.save(todo);
            }else {
                throw new CustomException("todo not exist", false, HttpStatus.NOT_FOUND);
            }
        }else {
            throw new AuthorizeFailException("鉴权失败");
        }
    }


    public Todo GetTodo(String token, Long tid) {
        UserStatus userStatus = userStatusRepo.findByToken(token);
        if (userStatus != null) {
            Todo todo = todoRepo.findById(tid);
            if (todo !=null) {
                return todo;
            }else {
                throw new CustomException("todo not exist", false, HttpStatus.NOT_FOUND);
            }
        }else {
            throw new AuthorizeFailException("鉴权失败");
        }
    }

    public Page<Todo> GetTodoList(String token,int page,int size) {
        UserStatus userStatus = userStatusRepo.findByToken(token);
        if (userStatus != null) {
            Page<Todo> todo = todoRepo.findAllByUser(userStatus.getUser(),new PageRequest(page,size));
            if (todo !=null) {
                return todo;
            }else {
                throw new CustomException("todo not exist", false, HttpStatus.NOT_FOUND);
            }
        }else {
            throw new AuthorizeFailException("鉴权失败");
        }
    }
}
