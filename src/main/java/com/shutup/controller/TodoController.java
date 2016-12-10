package com.shutup.controller;

import com.shutup.model.persist.Todo;
import com.shutup.model.request.TodoCreateRequest;
import com.shutup.model.request.TodoUpdateRequest;
import com.shutup.model.response.TodoCreateResponse;
import com.shutup.service.TodoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by shutup on 2016/12/3.
 */
@Api(value = "Todo API")
@RestController
@RequestMapping(path = {"/todo"})
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<TodoCreateResponse> createTodo(HttpRequest request,@RequestHeader String token, @Valid @RequestBody TodoCreateRequest todoCreateRequest) {
        TodoCreateResponse todoCreateResponse = todoService.CreateTodo(token,todoCreateRequest);
        if (todoCreateResponse != null) {
            return ResponseEntity.ok(todoCreateResponse);
        }else {
            return null;
        }
    }

    @RequestMapping(path = {"/{tid}"},method = RequestMethod.DELETE)
    public ResponseEntity<Todo> deleteTodo(@RequestHeader String token, @PathVariable Long tid) {
        Todo todoCreateResponse = todoService.DelTodo(token, tid);
        if (todoCreateResponse != null) {
            return ResponseEntity.ok(todoCreateResponse);
        }else {
            return null;
        }
    }

    @RequestMapping(path = {"/{tid}"},method = RequestMethod.PUT)
    public ResponseEntity<Todo> updateTodo(@RequestHeader String token, @PathVariable Long tid, @RequestBody TodoUpdateRequest todoUpdateRequest) {
        Todo todoCreateResponse = todoService.UpdateTodo(token, tid,todoUpdateRequest);
        if (todoCreateResponse != null) {
            return ResponseEntity.ok(todoCreateResponse);
        }else {
            return null;
        }
    }

    @RequestMapping(path = {"/{tid}"},method = RequestMethod.GET)
    public ResponseEntity<Todo> getTodo(@RequestHeader String token, @PathVariable Long tid) {
        Todo todoCreateResponse = todoService.GetTodo(token, tid);
        if (todoCreateResponse != null) {
            return ResponseEntity.ok(todoCreateResponse);
        }else {
            return null;
        }
    }

    @RequestMapping(path = "/list",method = RequestMethod.GET)
    public ResponseEntity<Page<Todo>> getTodoList(@RequestHeader String token,@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Todo> todoPage = todoService.GetTodoList(token,page,size);
        if (todoPage != null) {
            return ResponseEntity.ok(todoPage);
        }else {
            return null;
        }
    }
}
