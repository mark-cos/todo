package com.markcos.first.todo.repository;

import com.markcos.first.todo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmailAndPassword(String email, String password);
}
