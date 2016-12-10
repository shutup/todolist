package com.shutup.repo;

import com.shutup.model.persist.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by shutup on 2016/12/3.
 */
@Repository
public interface UserRepo extends CrudRepository<User,Long> {
     User findByUsernameAndPassword(String username,String password);
     User findByUsername(String username);
}
