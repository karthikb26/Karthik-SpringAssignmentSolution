package com.example.springbootsmsapp.repository;

import com.example.springbootsmsapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u where u.userName=?1")
    public User getUserByUserName(String userName);
    @Query("select u.id from User u where u.userName=?1")
    public Long getUserIdByUserName(String userName);
}
