package com.muri.web.repository;

import com.muri.web.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by andrei.a.muresan on 10/12/2015.
 */
@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select s from User s where s.username = :username")
    User findByUsername(@Param("username") String username);

    @Query("select s from User s where s.emailAddress = :email")
    User findByEmail(@Param("email") String email);

}
