package com.shutup.repo;

import com.shutup.model.persist.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by shutup on 2016/12/3.
 */
public interface UserRepo extends CrudRepository<User,Long> {
    public User findByUsernameAndPassword(String username,String password);
    public User findByUsername(String username);
}
