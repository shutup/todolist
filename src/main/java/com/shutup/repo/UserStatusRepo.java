package com.shutup.repo;

import com.shutup.model.persist.User;
import com.shutup.model.persist.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by shutup on 2016/12/3.
 */
public interface UserStatusRepo extends JpaRepository<UserStatus,Long>{

    public UserStatus findByUser(User user);

    public UserStatus findByToken(String token);
}
