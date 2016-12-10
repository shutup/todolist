package com.shutup.repo;

import com.shutup.model.persist.User;
import com.shutup.model.persist.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by shutup on 2016/12/3.
 */
@Repository
public interface UserStatusRepo extends JpaRepository<UserStatus,Long>{

     UserStatus findByUser(User user);

     UserStatus findByToken(String token);
}
