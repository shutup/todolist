package com.shutup.repo;

import com.shutup.model.persist.Todo;
import com.shutup.model.persist.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by shutup on 2016/12/4.
 */
@Repository
public interface TodoRepo extends JpaRepository<Todo,Long> {
    Todo findById(Long tid);

    Page<Todo> findAllByUser(User user, Pageable pageable);
}
