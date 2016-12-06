package com.shutup.mapper;

import com.shutup.model.persist.Todo;
import com.shutup.model.request.TodoCreateRequest;
import com.shutup.model.response.TodoCreateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Created by shutup on 2016/12/4.
 */
@Mapper
public interface TodoMapper {
    TodoMapper Instance = Mappers.getMapper(TodoMapper.class);

    Todo TodoCreateRequestToTodo(TodoCreateRequest todoCreateRequest);
    TodoCreateResponse TodoToTodoCreateResponse(Todo todo);
}
