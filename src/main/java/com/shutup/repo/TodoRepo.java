package com.shutup.repo;

import com.shutup.model.persist.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by shutup on 2016/12/4.
 */
public interface TodoRepo extends JpaRepository<Todo,Long> {
    Todo findById(Long tid);
}
